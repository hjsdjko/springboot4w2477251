package com.dao;

import com.entity.YijiedingdanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.YijiedingdanVO;
import com.entity.view.YijiedingdanView;


/**
 * 已接订单
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public interface YijiedingdanDao extends BaseMapper<YijiedingdanEntity> {
	
	List<YijiedingdanVO> selectListVO(@Param("ew") Wrapper<YijiedingdanEntity> wrapper);
	
	YijiedingdanVO selectVO(@Param("ew") Wrapper<YijiedingdanEntity> wrapper);
	
	List<YijiedingdanView> selectListView(@Param("ew") Wrapper<YijiedingdanEntity> wrapper);

	List<YijiedingdanView> selectListView(Pagination page,@Param("ew") Wrapper<YijiedingdanEntity> wrapper);

	
	YijiedingdanView selectView(@Param("ew") Wrapper<YijiedingdanEntity> wrapper);
	

}
