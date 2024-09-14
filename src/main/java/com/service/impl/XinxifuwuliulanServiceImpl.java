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


import com.dao.XinxifuwuliulanDao;
import com.entity.XinxifuwuliulanEntity;
import com.service.XinxifuwuliulanService;
import com.entity.vo.XinxifuwuliulanVO;
import com.entity.view.XinxifuwuliulanView;

@Service("xinxifuwuliulanService")
public class XinxifuwuliulanServiceImpl extends ServiceImpl<XinxifuwuliulanDao, XinxifuwuliulanEntity> implements XinxifuwuliulanService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<XinxifuwuliulanEntity> page = this.selectPage(
                new Query<XinxifuwuliulanEntity>(params).getPage(),
                new EntityWrapper<XinxifuwuliulanEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<XinxifuwuliulanEntity> wrapper) {
		  Page<XinxifuwuliulanView> page =new Query<XinxifuwuliulanView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}

    
    @Override
	public List<XinxifuwuliulanVO> selectListVO(Wrapper<XinxifuwuliulanEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public XinxifuwuliulanVO selectVO(Wrapper<XinxifuwuliulanEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<XinxifuwuliulanView> selectListView(Wrapper<XinxifuwuliulanEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public XinxifuwuliulanView selectView(Wrapper<XinxifuwuliulanEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
