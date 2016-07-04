package com.simple.command.param;

/**
 * 验证参数
 * 
 * @author ldm
 * @Date 2016年7月2日
 */
public class Command {
	/**
	 * 身份验证字符串
	 */
	private String v;
	/**
	 * 时间戳
	 */
	private String t;
	/**
	 * 验证策略
	 */
	private String c;
	/**
	 * 请求次数
	 */
	private String n;
	/**
	 * 请求的命令
	 */
	private String r;
	/**
	 * 请求的真实参数
	 */
	private String param;

	public String getV() {
		return v;
	}

	public void setV(String v) {
		this.v = v;
	}

	public String getT() {
		return t;
	}

	public void setT(String t) {
		this.t = t;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public String getN() {
		return n;
	}

	public String getR() {
		return r;
	}

	public void setR(String r) {
		this.r = r;
	}

	public void setN(String n) {
		this.n = n;
	}

	public String getParam() {
		return param;
	}

	public void setParam(String param) {
		this.param = param;
	}

}
