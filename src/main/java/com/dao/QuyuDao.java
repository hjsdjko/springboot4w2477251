package com.dao;

import com.entity.QuyuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.QuyuVO;
import com.entity.view.QuyuView;


/**
 * 区域
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public interface QuyuDao extends BaseMapper<QuyuEntity> {
	
	List<QuyuVO> selectListVO(@Param("ew") Wrapper<QuyuEntity> wrapper);
	
	QuyuVO selectVO(@Param("ew") Wrapper<QuyuEntity> wrapper);
	
	List<QuyuView> selectListView(@Param("ew") Wrapper<QuyuEntity> wrapper);

	List<QuyuView> selectListView(Pagination page,@Param("ew") Wrapper<QuyuEntity> wrapper);

	
	QuyuView selectView(@Param("ew") Wrapper<QuyuEntity> wrapper);
	

}
