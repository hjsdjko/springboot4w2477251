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


import com.dao.DiscussxinxifuwuliulanDao;
import com.entity.DiscussxinxifuwuliulanEntity;
import com.service.DiscussxinxifuwuliulanService;
import com.entity.vo.DiscussxinxifuwuliulanVO;
import com.entity.view.DiscussxinxifuwuliulanView;

@Service("discussxinxifuwuliulanService")
public class DiscussxinxifuwuliulanServiceImpl extends ServiceImpl<DiscussxinxifuwuliulanDao, DiscussxinxifuwuliulanEntity> implements DiscussxinxifuwuliulanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussxinxifuwuliulanEntity> page = this.selectPage(
                new Query<DiscussxinxifuwuliulanEntity>(params).getPage(),
                new EntityWrapper<DiscussxinxifuwuliulanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussxinxifuwuliulanEntity> wrapper) {
		  Page<DiscussxinxifuwuliulanView> page =new Query<DiscussxinxifuwuliulanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<DiscussxinxifuwuliulanVO> selectListVO(Wrapper<DiscussxinxifuwuliulanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussxinxifuwuliulanVO selectVO(Wrapper<DiscussxinxifuwuliulanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussxinxifuwuliulanView> selectListView(Wrapper<DiscussxinxifuwuliulanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussxinxifuwuliulanView selectView(Wrapper<DiscussxinxifuwuliulanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
