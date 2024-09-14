package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.QishouEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.QishouVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.QishouView;


/**
 * 骑手
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public interface QishouService extends IService<QishouEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<QishouVO> selectListVO(Wrapper<QishouEntity> wrapper);
   	
   	QishouVO selectVO(@Param("ew") Wrapper<QishouEntity> wrapper);
   	
   	List<QishouView> selectListView(Wrapper<QishouEntity> wrapper);
   	
   	QishouView selectView(@Param("ew") Wrapper<QishouEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<QishouEntity> wrapper);

   	

}

