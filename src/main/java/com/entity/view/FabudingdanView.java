package com.entity.view;

import com.entity.FabudingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 发布订单
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@TableName("fabudingdan")
public class FabudingdanView  extends FabudingdanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public FabudingdanView(){
	}
 
 	public FabudingdanView(FabudingdanEntity fabudingdanEntity){
 	try {
			BeanUtils.copyProperties(this, fabudingdanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
