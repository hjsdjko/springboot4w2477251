package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussqishouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussqishouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussqishouView;


/**
 * 骑手评论表
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:04
 */
public interface DiscussqishouService extends IService<DiscussqishouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussqishouVO> selectListVO(Wrapper<DiscussqishouEntity> wrapper);
   	
   	DiscussqishouVO selectVO(@Param("ew") Wrapper<DiscussqishouEntity> wrapper);
   	
   	List<DiscussqishouView> selectListView(Wrapper<DiscussqishouEntity> wrapper);
   	
   	DiscussqishouView selectView(@Param("ew") Wrapper<DiscussqishouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussqishouEntity> wrapper);

   	

}

