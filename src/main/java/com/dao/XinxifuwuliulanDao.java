package com.dao;

import com.entity.XinxifuwuliulanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.XinxifuwuliulanVO;
import com.entity.view.XinxifuwuliulanView;


/**
 * 信息服务浏览
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public interface XinxifuwuliulanDao extends BaseMapper<XinxifuwuliulanEntity> {
	
	List<XinxifuwuliulanVO> selectListVO(@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);
	
	XinxifuwuliulanVO selectVO(@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);
	
	List<XinxifuwuliulanView> selectListView(@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);

	List<XinxifuwuliulanView> selectListView(Pagination page,@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);

	
	XinxifuwuliulanView selectView(@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);
	

}
