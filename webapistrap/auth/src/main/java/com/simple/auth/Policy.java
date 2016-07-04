package com.simple.auth;

public enum Policy {
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
