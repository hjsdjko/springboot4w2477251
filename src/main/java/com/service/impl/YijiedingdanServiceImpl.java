package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.YijiedingdanDao;
import com.entity.YijiedingdanEntity;
import com.service.YijiedingdanService;
import com.entity.vo.YijiedingdanVO;
import com.entity.view.YijiedingdanView;

@Service("yijiedingdanService")
public class YijiedingdanServiceImpl extends ServiceImpl<YijiedingdanDao, YijiedingdanEntity> implements YijiedingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<YijiedingdanEntity> page = this.selectPage(
                new Query<YijiedingdanEntity>(params).getPage(),
                new EntityWrapper<YijiedingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<YijiedingdanEntity> wrapper) {
		  Page<YijiedingdanView> page =new Query<YijiedingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<YijiedingdanVO> selectListVO(Wrapper<YijiedingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public YijiedingdanVO selectVO(Wrapper<YijiedingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<YijiedingdanView> selectListView(Wrapper<YijiedingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public YijiedingdanView selectView(Wrapper<YijiedingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
