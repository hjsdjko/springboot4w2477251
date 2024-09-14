package com.entity.view;

import com.entity.FuwuleixingEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 服务类型
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@TableName("fuwuleixing")
public class FuwuleixingView  extends FuwuleixingEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FuwuleixingView(){
	}
 
 	public FuwuleixingView(FuwuleixingEntity fuwuleixingEntity){
 	try {
			BeanUtils.copyProperties(this, fuwuleixingEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
