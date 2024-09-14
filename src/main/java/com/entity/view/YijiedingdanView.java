package com.entity.view;

import com.entity.YijiedingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 已接订单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@TableName("yijiedingdan")
public class YijiedingdanView  extends YijiedingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public YijiedingdanView(){
	}
 
 	public YijiedingdanView(YijiedingdanEntity yijiedingdanEntity){
 	try {
			BeanUtils.copyProperties(this, yijiedingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
