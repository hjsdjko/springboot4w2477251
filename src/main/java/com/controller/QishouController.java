package com.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.annotation.IgnoreAuth;

import com.entity.QishouEntity;
import com.entity.view.QishouView;

import com.service.QishouService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;
import com.entity.WxLoginParam;
import com.utils.WechatUtil;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * 骑手
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@RestController
@RequestMapping("/qishou")
public class QishouController {
    @Autowired
    private QishouService qishouService;




    
	@Autowired
	private TokenService tokenService;
	
	/**
	 * 登录
	 */
	@IgnoreAuth
	@RequestMapping(value = "/login")
	public R login(String username, String password, String captcha, HttpServletRequest request) {
		QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", username));
        if(u==null || !u.getMima().equals(EncryptUtil.md5(password))) {
			return R.error("账号或密码不正确");
		}
        if(!"是".equals(u.getSfsh())) return R.error("账号已锁定，请联系管理员审核。");
		String token = tokenService.generateToken(u.getId(), username,"qishou",  "骑手" );
		return R.ok().put("token", token);
	}


    /**
     * 微信登录
     */
    @RequestMapping(value = "/wx/login")
    @IgnoreAuth
    public R wxLogin(@RequestBody WxLoginParam param) {
        String token = null;
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        com.alibaba.fastjson.JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(param.getCode());

        // 3.接收微信接口服务  获取返回的参数
        String openId = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        if (StringUtils.isBlank(openId) && StringUtils.isBlank(sessionKey)) {
            return R.error("接口请求失败！");
        }

        com.alibaba.fastjson.JSONObject object = WechatUtil.getUserInfo(param.getEncryptedData(), sessionKey, param.getIv());
        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(object));
        
        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(param.getRawData() + sessionKey);
        if (!param.getSignature().equals(signature2)) {
            return R.error("签名校验失败");
        }

        QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("openid", openId));
        if (user == null) {
            return R.error("请登录账号绑定微信后再进行微信登录。");
        } else {
            //已绑定，登录成功
            token = tokenService.generateToken(user.getId(), user.getQishouzhanghao(),"qishou", "骑手");
        }
        
        return R.ok().put("token", token);
    }
    
    /**
     * 微信账号绑定
     */
    @RequestMapping(value = "/wx/bind")
    public R wxBind(@RequestBody WxLoginParam param , HttpServletRequest request){
        // 1.接收小程序发送的code
        // 2.开发者服务器 登录凭证校验接口 appi + appsecret + code
        com.alibaba.fastjson.JSONObject SessionKeyOpenId = WechatUtil.getSessionKeyOrOpenId(param.getCode());

        // 3.接收微信接口服务  获取返回的参数
        String openId = SessionKeyOpenId.getString("openid");
        String sessionKey = SessionKeyOpenId.getString("session_key");

        if (StringUtils.isBlank(openId) && StringUtils.isBlank(sessionKey)) {
            return R.error("接口请求失败！");
        }

        com.alibaba.fastjson.JSONObject object = WechatUtil.getUserInfo(param.getEncryptedData(), sessionKey, param.getIv());
        System.out.println(com.alibaba.fastjson.JSONObject.toJSONString(object));
        
        // 4.校验签名 小程序发送的签名signature与服务器端生成的签名signature2 = sha1(rawData + sessionKey)
        String signature2 = DigestUtils.sha1Hex(param.getRawData() + sessionKey);
        if (!param.getSignature().equals(signature2)) {
            return R.error("签名校验失败");
        }
        String rawData = param.getRawData();
        com.alibaba.fastjson.JSONObject rawDataJson = com.alibaba.fastjson.JSON.parseObject(rawData);
        QishouEntity user = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("openid", openId));
        if (user == null) {
            Long id = (Long)request.getSession().getAttribute("userId");
            user = qishouService.selectById(id);
            if(user!=null) {
                user.setOpenid(openId);
                user.setNickname(rawDataJson.getString("nickName"));
                user.setAvatarurl(rawDataJson.getString("avatarUrl"));
            }
            qishouService.updateById(user);
        } else {
            return R.error("账号已被绑定");
        }
        return R.ok("绑定成功");
    }
    
    /**
     * 微信账号解绑
     */
    @RequestMapping(value = "/wx/unbind")
    public R wxUnbind(HttpServletRequest request){
        Long id = (Long)request.getSession().getAttribute("userId");
        QishouEntity user = qishouService.selectById(id);
        if(StringUtils.isNotBlank(user.getOpenid())) {
            user.setOpenid("");
            user.setNickname("");
            user.setAvatarurl("");
        } else {
            return R.error("账号已解绑");
        }
        qishouService.updateById(user);
        return R.ok("解绑成功");
    }
	
	/**
     * 注册
     */
	@IgnoreAuth
    @RequestMapping("/register")
    public R register(@RequestBody QishouEntity qishou){
    	//ValidatorUtils.validateEntity(qishou);
    	QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()));
		if(u!=null) {
			return R.error("注册用户已存在");
		}
		Long uId = new Date().getTime();
		qishou.setId(uId);
        qishou.setMima(EncryptUtil.md5(qishou.getMima()));
        qishouService.insert(qishou);
        return R.ok();
    }

	
	/**
	 * 退出
	 */
	@RequestMapping("/logout")
	public R logout(HttpServletRequest request) {
		request.getSession().invalidate();
		return R.ok("退出成功");
	}
	
	/**
     * 获取用户的session用户信息
     */
    @RequestMapping("/session")
    public R getCurrUser(HttpServletRequest request){
    	Long id = (Long)request.getSession().getAttribute("userId");
        QishouEntity u = qishouService.selectById(id);
        return R.ok().put("data", u);
    }
    
    /**
     * 密码重置
     */
    @IgnoreAuth
	@RequestMapping(value = "/resetPass")
    public R resetPass(String username, HttpServletRequest request){
    	QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", username));
    	if(u==null) {
    		return R.error("账号不存在");
    	}
        u.setMima(EncryptUtil.md5("123456"));
        qishouService.updateById(u);
        return R.ok("密码已重置为：123456");
    }



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QishouEntity qishou,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("qishou")) {
			qishou.setQishouzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();

		PageUtils page = qishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qishou), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QishouEntity qishou, 
		HttpServletRequest request){
        EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();

		PageUtils page = qishouService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, qishou), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QishouEntity qishou){
       	EntityWrapper<QishouEntity> ew = new EntityWrapper<QishouEntity>();
      	ew.allEq(MPUtil.allEQMapPre( qishou, "qishou")); 
        return R.ok().put("data", qishouService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QishouEntity qishou){
        EntityWrapper< QishouEntity> ew = new EntityWrapper< QishouEntity>();
 		ew.allEq(MPUtil.allEQMapPre( qishou, "qishou")); 
		QishouView qishouView =  qishouService.selectView(ew);
		return R.ok("查询骑手成功").put("data", qishouView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QishouEntity qishou = qishouService.selectById(id);
        return R.ok().put("data", qishou);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QishouEntity qishou = qishouService.selectById(id);
        return R.ok().put("data", qishou);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QishouEntity qishou, HttpServletRequest request){
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
    	qishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qishou);
    	QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		qishou.setId(new Date().getTime());
        qishou.setMima(EncryptUtil.md5(qishou.getMima()));
        qishouService.insert(qishou);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QishouEntity qishou, HttpServletRequest request){
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
    	qishou.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(qishou);
    	QishouEntity u = qishouService.selectOne(new EntityWrapper<QishouEntity>().eq("qishouzhanghao", qishou.getQishouzhanghao()));
		if(u!=null) {
			return R.error("用户已存在");
		}
		qishou.setId(new Date().getTime());
        qishou.setMima(EncryptUtil.md5(qishou.getMima()));
        qishouService.insert(qishou);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QishouEntity qishou, HttpServletRequest request){
        //ValidatorUtils.validateEntity(qishou);
        if(qishouService.selectCount(new EntityWrapper<QishouEntity>().ne("id", qishou.getId()).eq("qishouzhanghao", qishou.getQishouzhanghao()))>0) {
            return R.error("骑手账号已存在");
        }
	QishouEntity qishouEntity = qishouService.selectById(qishou.getId());
        if(StringUtils.isNotBlank(qishou.getMima()) && !qishou.getMima().equals(qishouEntity.getMima())) {
            qishou.setMima(EncryptUtil.md5(qishou.getMima()));
        }
        qishouService.updateById(qishou);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<QishouEntity> list = new ArrayList<QishouEntity>();
        for(Long id : ids) {
            QishouEntity qishou = qishouService.selectById(id);
            qishou.setSfsh(sfsh);
            qishou.setShhf(shhf);
            list.add(qishou);
        }
        qishouService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        qishouService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
