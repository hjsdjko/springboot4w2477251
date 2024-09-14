package com.entity.view;

import com.entity.DiscussqishouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 骑手评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:04
 */
@TableName("discussqishou")
public class DiscussqishouView  extends DiscussqishouEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussqishouView(){
	}
 
 	public DiscussqishouView(DiscussqishouEntity discussqishouEntity){
 	try {
			BeanUtils.copyProperties(this, discussqishouEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
