package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.YijiedingdanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.YijiedingdanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.YijiedingdanView;


/**
 * 已接订单
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public interface YijiedingdanService extends IService<YijiedingdanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<YijiedingdanVO> selectListVO(Wrapper<YijiedingdanEntity> wrapper);
   	
   	YijiedingdanVO selectVO(@Param("ew") Wrapper<YijiedingdanEntity> wrapper);
   	
   	List<YijiedingdanView> selectListView(Wrapper<YijiedingdanEntity> wrapper);
   	
   	YijiedingdanView selectView(@Param("ew") Wrapper<YijiedingdanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<YijiedingdanEntity> wrapper);

   	

}

