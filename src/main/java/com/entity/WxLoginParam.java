package com.entity;

/**
* 类说明 : 
*/
public class WxLoginParam {
	/**
	 * 临时登录凭证
	 */
	private String code;
	
	/**
	 * 用户非敏感信息
	 */
	private String rawData;
	
	/**
	 * 签名
	 */
	private String signature;
	
	/**
	 * 用户敏感信息
	 */
	private String encryptedData;
	
	/**
	 * 解密算法的向量
	 */
	private String iv;
	
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}
	
}
