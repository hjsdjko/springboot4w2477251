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
 * 完成订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
@TableName("wanchengdingdan")
public class WanchengdingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public WanchengdingdanEntity() {
		
	}
	
	public WanchengdingdanEntity(T t) {
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
	 * 订单编号
	 */
					
	private String dingdanbianhao;
	
	/**
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 物品重量
	 */
					
	private String wupinzhongliang;
	
	/**
	 * 物品价格
	 */
					
	private Double wupinjiage;
	
	/**
	 * 配送距离
	 */
					
	private String peisongjuli;
	
	/**
	 * 发布人账号
	 */
					
	private String zhanghao;
	
	/**
	 * 时间
	 */
				
	@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat 		
	private Date shijian;
	
	/**
	 * 状态
	 */
					
	private String zhuangtai;
	
	/**
	 * 本单收入
	 */
					
	private Double yue;
	
	/**
	 * 骑手账号
	 */
					
	private String qishouzhanghao;
	
	/**
	 * 骑手姓名
	 */
					
	private String qishouxingming;
	
	
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
	 * 设置：订单编号
	 */
	public void setDingdanbianhao(String dingdanbianhao) {
		this.dingdanbianhao = dingdanbianhao;
	}
	/**
	 * 获取：订单编号
	 */
	public String getDingdanbianhao() {
		return dingdanbianhao;
	}
	/**
	 * 设置：物品名称
	 */
	public void setWupinmingcheng(String wupinmingcheng) {
		this.wupinmingcheng = wupinmingcheng;
	}
	/**
	 * 获取：物品名称
	 */
	public String getWupinmingcheng() {
		return wupinmingcheng;
	}
	/**
	 * 设置：照片
	 */
	public void setZhaopian(String zhaopian) {
		this.zhaopian = zhaopian;
	}
	/**
	 * 获取：照片
	 */
	public String getZhaopian() {
		return zhaopian;
	}
	/**
	 * 设置：物品重量
	 */
	public void setWupinzhongliang(String wupinzhongliang) {
		this.wupinzhongliang = wupinzhongliang;
	}
	/**
	 * 获取：物品重量
	 */
	public String getWupinzhongliang() {
		return wupinzhongliang;
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
	 * 设置：配送距离
	 */
	public void setPeisongjuli(String peisongjuli) {
		this.peisongjuli = peisongjuli;
	}
	/**
	 * 获取：配送距离
	 */
	public String getPeisongjuli() {
		return peisongjuli;
	}
	/**
	 * 设置：发布人账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：发布人账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：时间
	 */
	public void setShijian(Date shijian) {
		this.shijian = shijian;
	}
	/**
	 * 获取：时间
	 */
	public Date getShijian() {
		return shijian;
	}
	/**
	 * 设置：状态
	 */
	public void setZhuangtai(String zhuangtai) {
		this.zhuangtai = zhuangtai;
	}
	/**
	 * 获取：状态
	 */
	public String getZhuangtai() {
		return zhuangtai;
	}
	/**
	 * 设置：本单收入
	 */
	public void setYue(Double yue) {
		this.yue = yue;
	}
	/**
	 * 获取：本单收入
	 */
	public Double getYue() {
		return yue;
	}
	/**
	 * 设置：骑手账号
	 */
	public void setQishouzhanghao(String qishouzhanghao) {
		this.qishouzhanghao = qishouzhanghao;
	}
	/**
	 * 获取：骑手账号
	 */
	public String getQishouzhanghao() {
		return qishouzhanghao;
	}
	/**
	 * 设置：骑手姓名
	 */
	public void setQishouxingming(String qishouxingming) {
		this.qishouxingming = qishouxingming;
	}
	/**
	 * 获取：骑手姓名
	 */
	public String getQishouxingming() {
		return qishouxingming;
	}

}
