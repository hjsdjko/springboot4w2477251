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

import com.entity.PaotuifuwuEntity;
import com.entity.view.PaotuifuwuView;

import com.service.PaotuifuwuService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 跑腿服务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@RestController
@RequestMapping("/paotuifuwu")
public class PaotuifuwuController {
    @Autowired
    private PaotuifuwuService paotuifuwuService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,PaotuifuwuEntity paotuifuwu,
		HttpServletRequest request){
        EntityWrapper<PaotuifuwuEntity> ew = new EntityWrapper<PaotuifuwuEntity>();

		PageUtils page = paotuifuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuifuwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,PaotuifuwuEntity paotuifuwu, 
		HttpServletRequest request){
        EntityWrapper<PaotuifuwuEntity> ew = new EntityWrapper<PaotuifuwuEntity>();

		PageUtils page = paotuifuwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, paotuifuwu), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( PaotuifuwuEntity paotuifuwu){
       	EntityWrapper<PaotuifuwuEntity> ew = new EntityWrapper<PaotuifuwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( paotuifuwu, "paotuifuwu")); 
        return R.ok().put("data", paotuifuwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(PaotuifuwuEntity paotuifuwu){
        EntityWrapper< PaotuifuwuEntity> ew = new EntityWrapper< PaotuifuwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( paotuifuwu, "paotuifuwu")); 
		PaotuifuwuView paotuifuwuView =  paotuifuwuService.selectView(ew);
		return R.ok("查询跑腿服务成功").put("data", paotuifuwuView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        PaotuifuwuEntity paotuifuwu = paotuifuwuService.selectById(id);
        return R.ok().put("data", paotuifuwu);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        PaotuifuwuEntity paotuifuwu = paotuifuwuService.selectById(id);
        return R.ok().put("data", paotuifuwu);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody PaotuifuwuEntity paotuifuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(paotuifuwu);
        paotuifuwuService.insert(paotuifuwu);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody PaotuifuwuEntity paotuifuwu, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(paotuifuwu);
        paotuifuwuService.insert(paotuifuwu);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody PaotuifuwuEntity paotuifuwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(paotuifuwu);
        paotuifuwuService.updateById(paotuifuwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        paotuifuwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
