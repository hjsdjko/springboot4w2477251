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

import com.entity.FabudingdanEntity;
import com.entity.view.FabudingdanView;

import com.service.FabudingdanService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 发布订单
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@RestController
@RequestMapping("/fabudingdan")
public class FabudingdanController {
    @Autowired
    private FabudingdanService fabudingdanService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,FabudingdanEntity fabudingdan,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			fabudingdan.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<FabudingdanEntity> ew = new EntityWrapper<FabudingdanEntity>();

		PageUtils page = fabudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabudingdan), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,FabudingdanEntity fabudingdan, 
		HttpServletRequest request){
        EntityWrapper<FabudingdanEntity> ew = new EntityWrapper<FabudingdanEntity>();

		PageUtils page = fabudingdanService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, fabudingdan), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( FabudingdanEntity fabudingdan){
       	EntityWrapper<FabudingdanEntity> ew = new EntityWrapper<FabudingdanEntity>();
      	ew.allEq(MPUtil.allEQMapPre( fabudingdan, "fabudingdan")); 
        return R.ok().put("data", fabudingdanService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(FabudingdanEntity fabudingdan){
        EntityWrapper< FabudingdanEntity> ew = new EntityWrapper< FabudingdanEntity>();
 		ew.allEq(MPUtil.allEQMapPre( fabudingdan, "fabudingdan")); 
		FabudingdanView fabudingdanView =  fabudingdanService.selectView(ew);
		return R.ok("查询发布订单成功").put("data", fabudingdanView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        FabudingdanEntity fabudingdan = fabudingdanService.selectById(id);
        return R.ok().put("data", fabudingdan);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        FabudingdanEntity fabudingdan = fabudingdanService.selectById(id);
        return R.ok().put("data", fabudingdan);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody FabudingdanEntity fabudingdan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fabudingdan);
        fabudingdanService.insert(fabudingdan);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody FabudingdanEntity fabudingdan, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(fabudingdan);
        fabudingdanService.insert(fabudingdan);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody FabudingdanEntity fabudingdan, HttpServletRequest request){
        //ValidatorUtils.validateEntity(fabudingdan);
        fabudingdanService.updateById(fabudingdan);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        fabudingdanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
