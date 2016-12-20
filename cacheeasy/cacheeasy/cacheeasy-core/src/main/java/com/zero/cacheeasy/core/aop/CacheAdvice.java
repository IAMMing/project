package com.zero.cacheeasy.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * 
 * CacheAdvice.java
 * 
 * @description 缓存拦截器
 * @author ldm
 * @date 2016年12月20日
 * @detail
 */

public class CacheAdvice {
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		return joinPoint.proceed();
	}
}
