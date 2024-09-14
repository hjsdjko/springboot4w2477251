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


import com.dao.FabudingdanDao;
import com.entity.FabudingdanEntity;
import com.service.FabudingdanService;
import com.entity.vo.FabudingdanVO;
import com.entity.view.FabudingdanView;

@Service("fabudingdanService")
public class FabudingdanServiceImpl extends ServiceImpl<FabudingdanDao, FabudingdanEntity> implements FabudingdanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<FabudingdanEntity> page = this.selectPage(
                new Query<FabudingdanEntity>(params).getPage(),
                new EntityWrapper<FabudingdanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<FabudingdanEntity> wrapper) {
		  Page<FabudingdanView> page =new Query<FabudingdanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<FabudingdanVO> selectListVO(Wrapper<FabudingdanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public FabudingdanVO selectVO(Wrapper<FabudingdanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<FabudingdanView> selectListView(Wrapper<FabudingdanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public FabudingdanView selectView(Wrapper<FabudingdanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
