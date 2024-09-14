package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;


/**
 * 跑腿服务
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@TableName("paotuifuwu")
public class PaotuifuwuEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public PaotuifuwuEntity() {
		
	}
	
	public PaotuifuwuEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * 主键id
	 */
    @TableId(type = IdType.AUTO)
    private Long id;
	/**
	 * 跑腿服务
	 */
					
	private String paotuifuwu;
	
	/**
	 * 物品价格
	 */
					
	private Double wupinjiage;
	
	/**
	 * 距离/公里
	 */
					
	private String peisongjuli;
	
	
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
	private Date addtime;

	public Date getAddtime() {
		return addtime;
	}
	public void setAddtime(Date addtime) {
		this.addtime = addtime;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * 设置：跑腿服务
	 */
	public void setPaotuifuwu(String paotuifuwu) {
		this.paotuifuwu = paotuifuwu;
	}
	/**
	 * 获取：跑腿服务
	 */
	public String getPaotuifuwu() {
		return paotuifuwu;
	}
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
