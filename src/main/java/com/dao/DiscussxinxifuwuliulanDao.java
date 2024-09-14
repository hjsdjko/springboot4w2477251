package com.dao;

import com.entity.DiscussxinxifuwuliulanEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscussxinxifuwuliulanVO;
import com.entity.view.DiscussxinxifuwuliulanView;


/**
 * 信息服务浏览评论表
 * 
 * @author 
 * @email 
 * @date 2024-04-26 17:54:04
 */
public interface DiscussxinxifuwuliulanDao extends BaseMapper<DiscussxinxifuwuliulanEntity> {
	
	List<DiscussxinxifuwuliulanVO> selectListVO(@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
	
	DiscussxinxifuwuliulanVO selectVO(@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
	
	List<DiscussxinxifuwuliulanView> selectListView(@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);

	List<DiscussxinxifuwuliulanView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);

	
	DiscussxinxifuwuliulanView selectView(@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
	

}
