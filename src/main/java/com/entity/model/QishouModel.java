package com.entity.model;

import com.entity.QishouEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
 

/**
 * 骑手
 * 接收传参的实体类  
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了） 
 * 取自ModelAndView 的model名称
 * @author 
 * @email 
 * @date 2024-04-26 17:54:03
 */
public class QishouModel  implements Serializable {
	private static final long serialVersionUID = 1L;

	 			
	/**
	 * 骑手姓名
	 */
	
	private String qishouxingming;
		
	/**
	 * 密码
	 */
	
	private String mima;
		
	/**
	 * 性别
	 */
	
	private String xingbie;
		
	/**
	 * 联系电话
	 */
	
	private String lianxidianhua;
		
	/**
	 * 工作状态
	 */
	
	private String gongzuozhuangtai;
		
	/**
	 * 照片
	 */
	
	private String zhaopian;
		
	/**
	 * 余额
	 */
	
	private Double yue;
		
	/**
	 * 提交认证
	 */
	
	private String tijiaorenzheng;
		
	/**
	 * 用户协议
	 */
	
	private String yonghuxieyi;
		
	/**
	 * 是否审核
	 */
	
	private String sfsh;
		
	/**
	 * 审核回复
	 */
	
	private String shhf;
		
	/**
	 * 评论数
	 */
	
	private Integer discussnum;
		
	/**
	 * 微信openid
	 */
	
	private String openid;
		
	/**
	 * 微信昵称
	 */
	
	private String nickname;
		
	/**
	 * 微信头像
	 */
	
	private String avatarurl;
				
	
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
	 * 设置：密码
	 */
	 
	public void setMima(String mima) {
		this.mima = mima;
	}
	
	/**
	 * 获取：密码
	 */
	public String getMima() {
		return mima;
	}
				
	
	/**
	 * 设置：性别
	 */
	 
	public void setXingbie(String xingbie) {
		this.xingbie = xingbie;
	}
	
	/**
	 * 获取：性别
	 */
	public String getXingbie() {
		return xingbie;
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
	 * 设置：工作状态
	 */
	 
	public void setGongzuozhuangtai(String gongzuozhuangtai) {
		this.gongzuozhuangtai = gongzuozhuangtai;
	}
	
	/**
	 * 获取：工作状态
	 */
	public String getGongzuozhuangtai() {
		return gongzuozhuangtai;
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
	 * 设置：余额
	 */
	 
	public void setYue(Double yue) {
		this.yue = yue;
	}
	
	/**
	 * 获取：余额
	 */
	public Double getYue() {
		return yue;
	}
				
	
	/**
	 * 设置：提交认证
	 */
	 
	public void setTijiaorenzheng(String tijiaorenzheng) {
		this.tijiaorenzheng = tijiaorenzheng;
	}
	
	/**
	 * 获取：提交认证
	 */
	public String getTijiaorenzheng() {
		return tijiaorenzheng;
	}
				
	
	/**
	 * 设置：用户协议
	 */
	 
	public void setYonghuxieyi(String yonghuxieyi) {
		this.yonghuxieyi = yonghuxieyi;
	}
	
	/**
	 * 获取：用户协议
	 */
	public String getYonghuxieyi() {
		return yonghuxieyi;
	}
				
	
	/**
	 * 设置：是否审核
	 */
	 
	public void setSfsh(String sfsh) {
		this.sfsh = sfsh;
	}
	
	/**
	 * 获取：是否审核
	 */
	public String getSfsh() {
		return sfsh;
	}
				
	
	/**
	 * 设置：审核回复
	 */
	 
	public void setShhf(String shhf) {
		this.shhf = shhf;
	}
	
	/**
	 * 获取：审核回复
	 */
	public String getShhf() {
		return shhf;
	}
				
	
	/**
	 * 设置：评论数
	 */
	 
	public void setDiscussnum(Integer discussnum) {
		this.discussnum = discussnum;
	}
	
	/**
	 * 获取：评论数
	 */
	public Integer getDiscussnum() {
		return discussnum;
	}
				
	
	/**
	 * 设置：微信openid
	 */
	 
	public void setOpenid(String openid) {
		this.openid = openid;
	}
	
	/**
	 * 获取：微信openid
	 */
	public String getOpenid() {
		return openid;
	}
				
	
	/**
	 * 设置：微信昵称
	 */
	 
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	/**
	 * 获取：微信昵称
	 */
	public String getNickname() {
		return nickname;
	}
				
	
	/**
	 * 设置：微信头像
	 */
	 
	public void setAvatarurl(String avatarurl) {
		this.avatarurl = avatarurl;
	}
	
	/**
	 * 获取：微信头像
	 */
	public String getAvatarurl() {
		return avatarurl;
	}
			
}
