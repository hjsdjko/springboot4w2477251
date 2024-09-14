package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.FabudingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.FabudingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.FabudingdanView;


/**
 * 发布订单
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public interface FabudingdanService extends IService<FabudingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<FabudingdanVO> selectListVO(Wrapper<FabudingdanEntity> wrapper);
   	
   	FabudingdanVO selectVO(@Param("ew") Wrapper<FabudingdanEntity> wrapper);
   	
   	List<FabudingdanView> selectListView(Wrapper<FabudingdanEntity> wrapper);
   	
   	FabudingdanView selectView(@Param("ew") Wrapper<FabudingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<FabudingdanEntity> wrapper);

   	

}

