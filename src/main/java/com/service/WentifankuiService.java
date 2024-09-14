package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.WentifankuiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.WentifankuiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.WentifankuiView;


/**
 * 问题反馈
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public interface WentifankuiService extends IService<WentifankuiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<WentifankuiVO> selectListVO(Wrapper<WentifankuiEntity> wrapper);
   	
   	WentifankuiVO selectVO(@Param("ew") Wrapper<WentifankuiEntity> wrapper);
   	
   	List<WentifankuiView> selectListView(Wrapper<WentifankuiEntity> wrapper);
   	
   	WentifankuiView selectView(@Param("ew") Wrapper<WentifankuiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<WentifankuiEntity> wrapper);

   	

}

