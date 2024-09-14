package com.entity.vo;

import com.entity.YijiedingdanEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 已接订单
 * @author 
 * @email 
 * @date 2024-04-26 17:54:02
 */
public class YijiedingdanVO  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 发布人账号
	 */
	
	private String zhanghao;
		
	/**
	 * 发布人姓名
	 */
	
	private String xingming;
		
	/**
	 * 发布人手机
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
	 * 备注要求
	 */
	
	private String beizhuyaoqiu;
		
	/**
	 * 骑手账号
	 */
	
	private String qishouzhanghao;
		
	/**
	 * 骑手姓名
	 */
	
	private String qishouxingming;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 配送地址
	 */
	
	private String peisongdizhi;
				
	
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
	 * 设置：发布人姓名
	 */
	 
	public void setXingming(String xingming) {
		this.xingming = xingming;
	}
	
	/**
	 * 获取：发布人姓名
	 */
	public String getXingming() {
		return xingming;
	}
				
	
	/**
	 * 设置：发布人手机
	 */
	 
	public void setShouji(String shouji) {
		this.shouji = shouji;
	}
	
	/**
	 * 获取：发布人手机
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
				
	
	/**
	 * 设置：联系电话
	 */
	 
	public void setLianxidianhua(String lianxidianhua) {
		this.lianxidianhua = lianxidianhua;
	}
	
	/**
	 * 获取：联系电话
	 */
	public String getLianxidianhua() {
		return lianxidianhua;
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
			
}
