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


import com.dao.WentifankuiDao;
import com.entity.WentifankuiEntity;
import com.service.WentifankuiService;
import com.entity.vo.WentifankuiVO;
import com.entity.view.WentifankuiView;

@Service("wentifankuiService")
public class WentifankuiServiceImpl extends ServiceImpl<WentifankuiDao, WentifankuiEntity> implements WentifankuiService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<WentifankuiEntity> page = this.selectPage(
                new Query<WentifankuiEntity>(params).getPage(),
                new EntityWrapper<WentifankuiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<WentifankuiEntity> wrapper) {
		  Page<WentifankuiView> page =new Query<WentifankuiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<WentifankuiVO> selectListVO(Wrapper<WentifankuiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public WentifankuiVO selectVO(Wrapper<WentifankuiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<WentifankuiView> selectListView(Wrapper<WentifankuiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public WentifankuiView selectView(Wrapper<WentifankuiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
