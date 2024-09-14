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


import com.dao.QishouDao;
import com.entity.QishouEntity;
import com.service.QishouService;
import com.entity.vo.QishouVO;
import com.entity.view.QishouView;

@Service("qishouService")
public class QishouServiceImpl extends ServiceImpl<QishouDao, QishouEntity> implements QishouService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QishouEntity> page = this.selectPage(
                new Query<QishouEntity>(params).getPage(),
                new EntityWrapper<QishouEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QishouEntity> wrapper) {
		  Page<QishouView> page =new Query<QishouView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QishouVO> selectListVO(Wrapper<QishouEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QishouVO selectVO(Wrapper<QishouEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QishouView> selectListView(Wrapper<QishouEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QishouView selectView(Wrapper<QishouEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
