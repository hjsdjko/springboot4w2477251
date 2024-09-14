package com.entity.view;

import com.entity.WentifankuiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 问题反馈
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@TableName("wentifankui")
public class WentifankuiView  extends WentifankuiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public WentifankuiView(){
	}
 
 	public WentifankuiView(WentifankuiEntity wentifankuiEntity){
 	try {
			BeanUtils.copyProperties(this, wentifankuiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
