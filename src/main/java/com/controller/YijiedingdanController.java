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

import com.entity.YijiedingdanEntity;
import com.entity.view.YijiedingdanView;

import com.service.YijiedingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 已接订单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@RestController
@RequestMapping("/yijiedingdan")
public class YijiedingdanController {
    @Autowired
    private YijiedingdanService yijiedingdanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,YijiedingdanEntity yijiedingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			yijiedingdan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
		if(tableName.equals("qishou")) {
			yijiedingdan.setQishouzhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<YijiedingdanEntity> ew = new EntityWrapper<YijiedingdanEntity>();

		PageUtils page = yijiedingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yijiedingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,YijiedingdanEntity yijiedingdan, 
		HttpServletRequest request){
        EntityWrapper<YijiedingdanEntity> ew = new EntityWrapper<YijiedingdanEntity>();

		PageUtils page = yijiedingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, yijiedingdan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( YijiedingdanEntity yijiedingdan){
       	EntityWrapper<YijiedingdanEntity> ew = new EntityWrapper<YijiedingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( yijiedingdan, "yijiedingdan")); 
        return R.ok().put("data", yijiedingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(YijiedingdanEntity yijiedingdan){
        EntityWrapper< YijiedingdanEntity> ew = new EntityWrapper< YijiedingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( yijiedingdan, "yijiedingdan")); 
		YijiedingdanView yijiedingdanView =  yijiedingdanService.selectView(ew);
		return R.ok("查询已接订单成功").put("data", yijiedingdanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        YijiedingdanEntity yijiedingdan = yijiedingdanService.selectById(id);
        return R.ok().put("data", yijiedingdan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        YijiedingdanEntity yijiedingdan = yijiedingdanService.selectById(id);
        return R.ok().put("data", yijiedingdan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody YijiedingdanEntity yijiedingdan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yijiedingdan);
        yijiedingdanService.insert(yijiedingdan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody YijiedingdanEntity yijiedingdan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(yijiedingdan);
        yijiedingdanService.insert(yijiedingdan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody YijiedingdanEntity yijiedingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(yijiedingdan);
        yijiedingdanService.updateById(yijiedingdan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        yijiedingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
