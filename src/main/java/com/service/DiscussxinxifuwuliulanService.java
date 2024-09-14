package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscussxinxifuwuliulanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscussxinxifuwuliulanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscussxinxifuwuliulanView;


/**
 * 信息服务浏览评论表
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:04
 */
public interface DiscussxinxifuwuliulanService extends IService<DiscussxinxifuwuliulanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscussxinxifuwuliulanVO> selectListVO(Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
   	
   	DiscussxinxifuwuliulanVO selectVO(@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
   	
   	List<DiscussxinxifuwuliulanView> selectListView(Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
   	
   	DiscussxinxifuwuliulanView selectView(@Param("ew") Wrapper<DiscussxinxifuwuliulanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscussxinxifuwuliulanEntity> wrapper);

   	

}

