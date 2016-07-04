package com.simple.auth.policy;
/**
 * 整个系统的验证策略的设计
 * @author ldm
 * @Date 2016年7月4日
 */
public enum Policy {
	/**
	 * 为获取到验证策略，验证将不会通过
	 */
	ERROR,
	/**
	 * 不需要验证
	 */
	NONE,
	/**
	 * 严格的验证方式
	 */
	STRICT,
	/**
	 * 半严格认证（扩大验证范围）
	 */
	LAX_STRICT,
	/**
	 * 松散验证
	 */
	LAX

}
