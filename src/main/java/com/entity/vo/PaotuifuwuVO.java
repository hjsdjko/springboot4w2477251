package com.entity.vo;

import com.entity.PaotuifuwuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 跑腿服务
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public class PaotuifuwuVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 物品价格
	 */
	
	private Double wupinjiage;
		
	/**
	 * 距离/公里
	 */
	
	private String peisongjuli;
				
	
	/**
	 * 设置：物品价格
	 */
	 
	public void setWupinjiage(Double wupinjiage) {
		this.wupinjiage = wupinjiage;
	}
	
	/**
	 * 获取：物品价格
	 */
	public Double getWupinjiage() {
		return wupinjiage;
	}
				
	
	/**
	 * 设置：距离/公里
	 */
	 
	public void setPeisongjuli(String peisongjuli) {
		this.peisongjuli = peisongjuli;
	}
	
	/**
	 * 获取：距离/公里
	 */
	public String getPeisongjuli() {
		return peisongjuli;
	}
			
}
