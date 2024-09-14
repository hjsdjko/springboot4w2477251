package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.XinxifuwuliulanEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.XinxifuwuliulanVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.XinxifuwuliulanView;


/**
 * 信息服务浏览
 *
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public interface XinxifuwuliulanService extends IService<XinxifuwuliulanEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<XinxifuwuliulanVO> selectListVO(Wrapper<XinxifuwuliulanEntity> wrapper);
   	
   	XinxifuwuliulanVO selectVO(@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);
   	
   	List<XinxifuwuliulanView> selectListView(Wrapper<XinxifuwuliulanEntity> wrapper);
   	
   	XinxifuwuliulanView selectView(@Param("ew") Wrapper<XinxifuwuliulanEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<XinxifuwuliulanEntity> wrapper);

   	

}

