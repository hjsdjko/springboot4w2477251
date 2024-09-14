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

import com.entity.XinxifuwuliulanEntity;
import com.entity.view.XinxifuwuliulanView;

import com.service.XinxifuwuliulanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 信息服务浏览
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@RestController
@RequestMapping("/xinxifuwuliulan")
public class XinxifuwuliulanController {
    @Autowired
    private XinxifuwuliulanService xinxifuwuliulanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,XinxifuwuliulanEntity xinxifuwuliulan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			xinxifuwuliulan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<XinxifuwuliulanEntity> ew = new EntityWrapper<XinxifuwuliulanEntity>();

		PageUtils page = xinxifuwuliulanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinxifuwuliulan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,XinxifuwuliulanEntity xinxifuwuliulan, 
		HttpServletRequest request){
        EntityWrapper<XinxifuwuliulanEntity> ew = new EntityWrapper<XinxifuwuliulanEntity>();

		PageUtils page = xinxifuwuliulanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, xinxifuwuliulan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( XinxifuwuliulanEntity xinxifuwuliulan){
       	EntityWrapper<XinxifuwuliulanEntity> ew = new EntityWrapper<XinxifuwuliulanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( xinxifuwuliulan, "xinxifuwuliulan")); 
        return R.ok().put("data", xinxifuwuliulanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(XinxifuwuliulanEntity xinxifuwuliulan){
        EntityWrapper< XinxifuwuliulanEntity> ew = new EntityWrapper< XinxifuwuliulanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( xinxifuwuliulan, "xinxifuwuliulan")); 
		XinxifuwuliulanView xinxifuwuliulanView =  xinxifuwuliulanService.selectView(ew);
		return R.ok("查询信息服务浏览成功").put("data", xinxifuwuliulanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        XinxifuwuliulanEntity xinxifuwuliulan = xinxifuwuliulanService.selectById(id);
        return R.ok().put("data", xinxifuwuliulan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        XinxifuwuliulanEntity xinxifuwuliulan = xinxifuwuliulanService.selectById(id);
        return R.ok().put("data", xinxifuwuliulan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody XinxifuwuliulanEntity xinxifuwuliulan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xinxifuwuliulan);
        xinxifuwuliulanService.insert(xinxifuwuliulan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody XinxifuwuliulanEntity xinxifuwuliulan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(xinxifuwuliulan);
        xinxifuwuliulanService.insert(xinxifuwuliulan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody XinxifuwuliulanEntity xinxifuwuliulan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(xinxifuwuliulan);
        xinxifuwuliulanService.updateById(xinxifuwuliulan);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<XinxifuwuliulanEntity> list = new ArrayList<XinxifuwuliulanEntity>();
        for(Long id : ids) {
            XinxifuwuliulanEntity xinxifuwuliulan = xinxifuwuliulanService.selectById(id);
            xinxifuwuliulan.setSfsh(sfsh);
            xinxifuwuliulan.setShhf(shhf);
            list.add(xinxifuwuliulan);
        }
        xinxifuwuliulanService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        xinxifuwuliulanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
