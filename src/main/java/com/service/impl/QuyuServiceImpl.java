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


import com.dao.QuyuDao;
import com.entity.QuyuEntity;
import com.service.QuyuService;
import com.entity.vo.QuyuVO;
import com.entity.view.QuyuView;

@Service("quyuService")
public class QuyuServiceImpl extends ServiceImpl<QuyuDao, QuyuEntity> implements QuyuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<QuyuEntity> page = this.selectPage(
                new Query<QuyuEntity>(params).getPage(),
                new EntityWrapper<QuyuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<QuyuEntity> wrapper) {
		  Page<QuyuView> page =new Query<QuyuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<QuyuVO> selectListVO(Wrapper<QuyuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public QuyuVO selectVO(Wrapper<QuyuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<QuyuView> selectListView(Wrapper<QuyuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public QuyuView selectView(Wrapper<QuyuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
