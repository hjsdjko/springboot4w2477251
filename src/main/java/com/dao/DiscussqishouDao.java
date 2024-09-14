package com.dao;

import com.entity.DiscussqishouEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussqishouVO;
import com.entity.view.DiscussqishouView;


/**
 * 骑手评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:04
 */
public interface DiscussqishouDao extends BaseMapper<DiscussqishouEntity> {
	
	List<DiscussqishouVO> selectListVO(@Param("ew") Wrapper<DiscussqishouEntity> wrapper);
	
	DiscussqishouVO selectVO(@Param("ew") Wrapper<DiscussqishouEntity> wrapper);
	
	List<DiscussqishouView> selectListView(@Param("ew") Wrapper<DiscussqishouEntity> wrapper);

	List<DiscussqishouView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussqishouEntity> wrapper);

	
	DiscussqishouView selectView(@Param("ew") Wrapper<DiscussqishouEntity> wrapper);
	

}
