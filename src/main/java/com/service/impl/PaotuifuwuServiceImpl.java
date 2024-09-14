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


import com.dao.PaotuifuwuDao;
import com.entity.PaotuifuwuEntity;
import com.service.PaotuifuwuService;
import com.entity.vo.PaotuifuwuVO;
import com.entity.view.PaotuifuwuView;

@Service("paotuifuwuService")
public class PaotuifuwuServiceImpl extends ServiceImpl<PaotuifuwuDao, PaotuifuwuEntity> implements PaotuifuwuService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<PaotuifuwuEntity> page = this.selectPage(
                new Query<PaotuifuwuEntity>(params).getPage(),
                new EntityWrapper<PaotuifuwuEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<PaotuifuwuEntity> wrapper) {
		  Page<PaotuifuwuView> page =new Query<PaotuifuwuView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<PaotuifuwuVO> selectListVO(Wrapper<PaotuifuwuEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public PaotuifuwuVO selectVO(Wrapper<PaotuifuwuEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<PaotuifuwuView> selectListView(Wrapper<PaotuifuwuEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public PaotuifuwuView selectView(Wrapper<PaotuifuwuEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
