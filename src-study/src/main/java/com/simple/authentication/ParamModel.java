package com.simple.authentication;

import java.util.Calendar;

import org.apache.commons.lang.time.DateUtils;

public class ParamModel {
	/**
	 * 客户端加密流程
	 */
	private String clientEncry;
	/**
	 * 客户端时间戳
	 */
	private long clientTimestamp;
	/**
	 * 验证策略
	 */
	private Policy policy;
	/**
	 * 请求次数
	 */
	private int requestTimes;

	private Calendar clientCalendar = Calendar.getInstance();

	public Calendar getClientCalendar() {
		return clientCalendar;
	}

	public void setClientCalendar(Calendar clientCalendar) {
		this.clientCalendar = clientCalendar;
	}

	public String getClientEncry() {
		return clientEncry;
	}

	public void setClientEncry(String clientEncry) {
		this.clientEncry = clientEncry;
	}

	public long getClientTimestamp() {
		return clientTimestamp;
	}

	public void setClientTimestamp(long clientTimestamp) {
		this.clientTimestamp = clientTimestamp;
	}

	public Policy getPolicy() {
		return policy;
	}

	public void setPolicy(Policy policy) {
		this.policy = policy;
	}

	public int getRequestTimes() {
		return requestTimes;
	}

	public void setRequestTimes(int requestTimes) {
		this.requestTimes = requestTimes;
	}

	public ParamModel(Param param) {
		this.clientEncry = param.getE();
		this.policy = Policy.values()[Integer.parseInt(param.getP())];
		this.clientTimestamp = Long.parseLong(param.getT());
		this.requestTimes = Integer.parseInt(param.getN());

		this.clientCalendar.setTimeInMillis(clientTimestamp);

	}
}
