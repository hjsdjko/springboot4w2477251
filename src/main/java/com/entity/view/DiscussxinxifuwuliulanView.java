package com.entity.view;

import com.entity.DiscussxinxifuwuliulanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

import java.io.Serializable;
import com.utils.EncryptUtil;
 

/**
 * 信息服务浏览评论表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:04
 */
@TableName("discussxinxifuwuliulan")
public class DiscussxinxifuwuliulanView  extends DiscussxinxifuwuliulanEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public DiscussxinxifuwuliulanView(){
	}
 
 	public DiscussxinxifuwuliulanView(DiscussxinxifuwuliulanEntity discussxinxifuwuliulanEntity){
 	try {
			BeanUtils.copyProperties(this, discussxinxifuwuliulanEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}


}
