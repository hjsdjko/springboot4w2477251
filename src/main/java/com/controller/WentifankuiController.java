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

import com.entity.WentifankuiEntity;
import com.entity.view.WentifankuiView;

import com.service.WentifankuiService;
import com.service.TokenService;
import com.utils.PageUtils;
import com.utils.R;
import com.utils.EncryptUtil;
import com.utils.MPUtil;
import com.utils.MapUtils;
import com.utils.CommonUtil;
import java.io.IOException;

/**
 * 问题反馈
 * 后端接口
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@RestController
@RequestMapping("/wentifankui")
public class WentifankuiController {
    @Autowired
    private WentifankuiService wentifankuiService;




    



    /**
     * 后台列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,WentifankuiEntity wentifankui,
		HttpServletRequest request){
		String tableName = request.getSession().getAttribute("tableName").toString();
		if(tableName.equals("yonghu")) {
			wentifankui.setZhanghao((String)request.getSession().getAttribute("username"));
		}
        EntityWrapper<WentifankuiEntity> ew = new EntityWrapper<WentifankuiEntity>();

		PageUtils page = wentifankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wentifankui), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前台列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,WentifankuiEntity wentifankui, 
		HttpServletRequest request){
        EntityWrapper<WentifankuiEntity> ew = new EntityWrapper<WentifankuiEntity>();

		PageUtils page = wentifankuiService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, wentifankui), params), params));
        return R.ok().put("data", page);
    }



	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( WentifankuiEntity wentifankui){
       	EntityWrapper<WentifankuiEntity> ew = new EntityWrapper<WentifankuiEntity>();
      	ew.allEq(MPUtil.allEQMapPre( wentifankui, "wentifankui")); 
        return R.ok().put("data", wentifankuiService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(WentifankuiEntity wentifankui){
        EntityWrapper< WentifankuiEntity> ew = new EntityWrapper< WentifankuiEntity>();
 		ew.allEq(MPUtil.allEQMapPre( wentifankui, "wentifankui")); 
		WentifankuiView wentifankuiView =  wentifankuiService.selectView(ew);
		return R.ok("查询问题反馈成功").put("data", wentifankuiView);
    }
	
    /**
     * 后台详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        WentifankuiEntity wentifankui = wentifankuiService.selectById(id);
        return R.ok().put("data", wentifankui);
    }

    /**
     * 前台详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        WentifankuiEntity wentifankui = wentifankuiService.selectById(id);
        return R.ok().put("data", wentifankui);
    }
    



    /**
     * 后台保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody WentifankuiEntity wentifankui, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(wentifankui);
        wentifankuiService.insert(wentifankui);
        return R.ok();
    }
    
    /**
     * 前台保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody WentifankuiEntity wentifankui, HttpServletRequest request){
    	//ValidatorUtils.validateEntity(wentifankui);
        wentifankuiService.insert(wentifankui);
        return R.ok();
    }





    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody WentifankuiEntity wentifankui, HttpServletRequest request){
        //ValidatorUtils.validateEntity(wentifankui);
        wentifankuiService.updateById(wentifankui);//全部更新
        return R.ok();
    }

    /**
     * 审核
     */
    @RequestMapping("/shBatch")
    @Transactional
    public R update(@RequestBody Long[] ids, @RequestParam String sfsh, @RequestParam String shhf){
        List<WentifankuiEntity> list = new ArrayList<WentifankuiEntity>();
        for(Long id : ids) {
            WentifankuiEntity wentifankui = wentifankuiService.selectById(id);
            wentifankui.setSfsh(sfsh);
            wentifankui.setShhf(shhf);
            list.add(wentifankui);
        }
        wentifankuiService.updateBatchById(list);
        return R.ok();
    }


    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        wentifankuiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	










}
