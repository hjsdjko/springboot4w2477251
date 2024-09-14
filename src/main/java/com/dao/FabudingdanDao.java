package com.dao;

import com.entity.FabudingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.FabudingdanVO;
import com.entity.view.FabudingdanView;


/**
 * 发布订单
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public interface FabudingdanDao extends BaseMapper<FabudingdanEntity> {
	
	List<FabudingdanVO> selectListVO(@Param("ew") Wrapper<FabudingdanEntity> wrapper);
	
	FabudingdanVO selectVO(@Param("ew") Wrapper<FabudingdanEntity> wrapper);
	
	List<FabudingdanView> selectListView(@Param("ew") Wrapper<FabudingdanEntity> wrapper);

	List<FabudingdanView> selectListView(Pagination page,@Param("ew") Wrapper<FabudingdanEntity> wrapper);

	
	FabudingdanView selectView(@Param("ew") Wrapper<FabudingdanEntity> wrapper);
	

}
