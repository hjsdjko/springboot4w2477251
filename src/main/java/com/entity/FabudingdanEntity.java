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
 * 发布订单
 * 数据库通用操作实体类（普通增删改查）
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
@TableName("fabudingdan")
public class FabudingdanEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public FabudingdanEntity() {
		
	}
	
	public FabudingdanEntity(T t) {
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
	 * 账号
	 */
					
	private String zhanghao;
	
	/**
	 * 姓名
	 */
					
	private String xingming;
	
	/**
	 * 手机
	 */
					
	private String shouji;
	
	/**
	 * 区域
	 */
					
	private String quyu;
	
	/**
	 * 物品名称
	 */
					
	private String wupinmingcheng;
	
	/**
	 * 照片
	 */
					
	private String zhaopian;
	
	/**
	 * 取货地址
	 */
					
	private String quhuodizhi;
	
	/**
	 * 跑腿服务
	 */
					
	private String paotuifuwu;
	
	/**
	 * 物品价格
	 */
					
	private Double wupinjiage;
	
	/**
	 * 配送距离
	 */
					
	private String peisongjuli;
	
	/**
	 * 备注要求
	 */
					
	private String beizhuyaoqiu;
	
	/**
	 * 订单状态
	 */
					
	private String dingdanzhuangtai;
	
	/**
	 * 配送地址
	 */
					
	private String peisongdizhi;
	
	/**
	 * 是否支付
	 */
					
	private String ispay;
	
	
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
	 * 设置：账号
	 */
	public void setZhanghao(String zhanghao) {
		this.zhanghao = zhanghao;
	}
	/**
	 * 获取：账号
	 */
	public String getZhanghao() {
		return zhanghao;
	}
	/**
	 * 设置：姓名
	 */
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	/**
	 * 获取：姓名
	 */
	public String getXingming() {
		return xingming;
	}
	/**
	 * 设置：手机
	 */
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	/**
	 * 获取：手机
	 */
	public String getShouji() {
		return shouji;
	}
	/**
	 * 设置：区域
	 */
	public void setQuyu(String quyu) {
		this.quyu = quyu;
	}
	/**
	 * 获取：区域
	 */
	public String getQuyu() {
		return quyu;
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
	 * 设置：取货地址
	 */
	public void setQuhuodizhi(String quhuodizhi) {
		this.quhuodizhi = quhuodizhi;
	}
	/**
	 * 获取：取货地址
	 */
	public String getQuhuodizhi() {
		return quhuodizhi;
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
	 * 设置：备注要求
	 */
	public void setBeizhuyaoqiu(String beizhuyaoqiu) {
		this.beizhuyaoqiu = beizhuyaoqiu;
	}
	/**
	 * 获取：备注要求
	 */
	public String getBeizhuyaoqiu() {
		return beizhuyaoqiu;
	}
	/**
	 * 设置：订单状态
	 */
	public void setDingdanzhuangtai(String dingdanzhuangtai) {
		this.dingdanzhuangtai = dingdanzhuangtai;
	}
	/**
	 * 获取：订单状态
	 */
	public String getDingdanzhuangtai() {
		return dingdanzhuangtai;
	}
	/**
	 * 设置：配送地址
	 */
	public void setPeisongdizhi(String peisongdizhi) {
		this.peisongdizhi = peisongdizhi;
	}
	/**
	 * 获取：配送地址
	 */
	public String getPeisongdizhi() {
		return peisongdizhi;
	}
	/**
	 * 设置：是否支付
	 */
	public void setIspay(String ispay) {
		this.ispay = ispay;
	}
	/**
	 * 获取：是否支付
	 */
	public String getIspay() {
		return ispay;
	}

}
