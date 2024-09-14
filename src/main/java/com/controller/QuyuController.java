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

import com.entity.QuyuEntity;
import com.entity.view.QuyuView;

import com.service.QuyuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 区域
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@RestController
@RequestMapping("/quyu")
public class QuyuController {
    @Autowired
    private QuyuService quyuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,QuyuEntity quyu,
		HttpServletRequest request){
        EntityWrapper<QuyuEntity> ew = new EntityWrapper<QuyuEntity>();

		PageUtils page = quyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,QuyuEntity quyu, 
		HttpServletRequest request){
        EntityWrapper<QuyuEntity> ew = new EntityWrapper<QuyuEntity>();

		PageUtils page = quyuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, quyu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( QuyuEntity quyu){
       	EntityWrapper<QuyuEntity> ew = new EntityWrapper<QuyuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( quyu, "quyu")); 
        return R.ok().put("data", quyuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(QuyuEntity quyu){
        EntityWrapper< QuyuEntity> ew = new EntityWrapper< QuyuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( quyu, "quyu")); 
		QuyuView quyuView =  quyuService.selectView(ew);
		return R.ok("查询区域成功").put("data", quyuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        QuyuEntity quyu = quyuService.selectById(id);
        return R.ok().put("data", quyu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        QuyuEntity quyu = quyuService.selectById(id);
        return R.ok().put("data", quyu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody QuyuEntity quyu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quyu);
        quyuService.insert(quyu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody QuyuEntity quyu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(quyu);
        quyuService.insert(quyu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody QuyuEntity quyu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(quyu);
        quyuService.updateById(quyu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        quyuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
