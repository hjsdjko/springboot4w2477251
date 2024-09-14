package com.dao;

import com.entity.WentifankuiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.WentifankuiVO;
import com.entity.view.WentifankuiView;


/**
 * 问题反馈
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public interface WentifankuiDao extends BaseMapper<WentifankuiEntity> {
	
	List<WentifankuiVO> selectListVO(@Param("ew") Wrapper<WentifankuiEntity> wrapper);
	
	WentifankuiVO selectVO(@Param("ew") Wrapper<WentifankuiEntity> wrapper);
	
	List<WentifankuiView> selectListView(@Param("ew") Wrapper<WentifankuiEntity> wrapper);

	List<WentifankuiView> selectListView(Pagination page,@Param("ew") Wrapper<WentifankuiEntity> wrapper);

	
	WentifankuiView selectView(@Param("ew") Wrapper<WentifankuiEntity> wrapper);
	

}
