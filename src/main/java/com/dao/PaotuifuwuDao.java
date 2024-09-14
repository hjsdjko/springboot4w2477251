package com.dao;

import com.entity.PaotuifuwuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.PaotuifuwuVO;
import com.entity.view.PaotuifuwuView;


/**
 * 跑腿服务
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public interface PaotuifuwuDao extends BaseMapper<PaotuifuwuEntity> {
	
	List<PaotuifuwuVO> selectListVO(@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);
	
	PaotuifuwuVO selectVO(@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);
	
	List<PaotuifuwuView> selectListView(@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);

	List<PaotuifuwuView> selectListView(Pagination page,@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);

	
	PaotuifuwuView selectView(@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);
	

}
