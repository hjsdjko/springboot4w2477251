package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.PaotuifuwuEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.PaotuifuwuVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.PaotuifuwuView;


/**
 * 跑腿服务
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public interface PaotuifuwuService extends IService<PaotuifuwuEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<PaotuifuwuVO> selectListVO(Wrapper<PaotuifuwuEntity> wrapper);
   	
   	PaotuifuwuVO selectVO(@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);
   	
   	List<PaotuifuwuView> selectListView(Wrapper<PaotuifuwuEntity> wrapper);
   	
   	PaotuifuwuView selectView(@Param("ew") Wrapper<PaotuifuwuEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<PaotuifuwuEntity> wrapper);

   	

}

