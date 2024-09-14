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


import com.dao.DiscussqishouDao;
import com.entity.DiscussqishouEntity;
import com.service.DiscussqishouService;
import com.entity.vo.DiscussqishouVO;
import com.entity.view.DiscussqishouView;

@Service("discussqishouService")
public class DiscussqishouServiceImpl extends ServiceImpl<DiscussqishouDao, DiscussqishouEntity> implements DiscussqishouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussqishouEntity> page = this.selectPage(
                new Query<DiscussqishouEntity>(params).getPage(),
                new EntityWrapper<DiscussqishouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussqishouEntity> wrapper) {
		  Page<DiscussqishouView> page =new Query<DiscussqishouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussqishouVO> selectListVO(Wrapper<DiscussqishouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussqishouVO selectVO(Wrapper<DiscussqishouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussqishouView> selectListView(Wrapper<DiscussqishouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussqishouView selectView(Wrapper<DiscussqishouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
