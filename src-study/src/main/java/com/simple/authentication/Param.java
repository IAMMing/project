package com.simple.authentication;

public class Param {
	/**
	 * 客户端加密串
	 */
	private String e;
	/**
	 * 客户端时间戳
	 */
	private String t;
	/**
	 * 客户端验证策略
	 */
	private String p;
	/**
	 * 客户端请求次数
	 */
	private String n;

	public String getE() {
		return e;
	}

	public void setE(String e) {
		this.e = e;
	}

	

	public String getP() {
		return p;
	}

	public void setP(String p) {
		this.p = p;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getN() {
		return n;
	}

	public void setN(String n) {
		this.n = n;
	}

	

}
