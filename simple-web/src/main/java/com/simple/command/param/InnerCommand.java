package com.simple.command.param;

import java.util.Calendar;

import org.apache.commons.lang.StringUtils;

import com.simple.auth.ValidHelper;
import com.simple.auth.policy.Policy;

/**
 * 内部访问真实命令
 * 
 * @author ldm
 * @Date 2016年7月3日
 */
public class InnerCommand {
	/**
	 * 认证字符串
	 */
	private String authString;
	/**
	 * 客户端时间戳
	 */
	private long clientTimestamp;
	/**
	 * 客户端生成串的日期
	 */
	private Calendar authDate;
	/**
	 * 验证策略
	 */
	private Policy policy;
	/**
	 * 请求次数
	 */
	private int requestTimes;
	/**
	 * 请求命令，可以解析为指定路径
	 */
	private int requestCommand;
	/**
	 * 真实的请求参数
	 */
	private String requestParam;
	/**
	 * 验证结果
	 */
	private boolean isAuth = false;

	public String getAuthString() {
		return authString;
	}

	public void setAuthString(String authString) {
		this.authString = authString;
	}

	public long getClientTimestamp() {
		return clientTimestamp;
	}

	public void setClientTimestamp(long clientTimestamp) {
		this.clientTimestamp = clientTimestamp;
	}

	public Calendar getAuthDate() {
		return authDate;
	}

	public void setAuthDate(Calendar authDate) {
		this.authDate = authDate;
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

	public String getRequestParam() {
		return requestParam;
	}

	public void setRequestParam(String requestParam) {
		this.requestParam = requestParam;
	}

	public int getRequestCommand() {
		return requestCommand;
	}

	public void setRequestCommand(int requestCommand) {
		this.requestCommand = requestCommand;
	}

	public boolean isAuth() {
		return isAuth;
	}

	public void setAuth(boolean isAuth) {
		this.isAuth = isAuth;
	}

	public InnerCommand(Command cmd) {
		this.authString = cmd.getV();
		// 判断时间戳，并设置客户端验证串的生成时间
		System.out.println(cmd.getT());
		if (StringUtils.isNumeric(cmd.getT())) {
			this.clientTimestamp = Long.parseLong(cmd.getT());
			this.authDate = Calendar.getInstance();
			this.authDate.setTimeInMillis(this.clientTimestamp);
		}
		System.out.println(cmd.getParam());
		this.requestParam = cmd.getParam();
		// 设置解析命令
		System.out.println(cmd.getR());
		if (StringUtils.isNumeric(cmd.getR())) {
			this.requestCommand = Integer.parseInt(cmd.getR());
		}
		// 设置验证策略
		if (StringUtils.isNumeric(cmd.getC())) {
			int p = Integer.parseInt(cmd.getC());
			if (p >= 0 && p < Policy.values().length) {
				this.policy = Policy.values()[p];
			} else {
				this.policy = Policy.values()[0];
			}
		}
		// 设置请求次数
		if (StringUtils.isNumeric(cmd.getN())) {
			this.requestTimes = Integer.parseInt(cmd.getN());
		}
	}

	/**
	 * 验证客户端请求
	 * <p>
	 * 验证通过返回请求的参数
	 * </p>
	 * 验证失败返回<tt>null</tt>
	 * 
	 * @author ldm
	 * @Date 2016年7月4日
	 * @return
	 */
	public String auth() {
		ValidHelper validHelper = new ValidHelper(this.authDate);
		boolean authResult = validHelper.valid(authString);
		if (!authResult) {
			this.requestParam = null;
		} else {
			if (this.requestParam == null) {
				this.requestParam = StringUtils.EMPTY;
			}
		}
		return requestParam;
	}
}
