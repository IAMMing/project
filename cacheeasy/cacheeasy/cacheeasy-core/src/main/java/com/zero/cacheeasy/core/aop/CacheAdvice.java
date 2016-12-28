package com.zero.cacheeasy.core.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSON;
import com.zero.cacheeasy.core.annonation.Cache;
import com.zero.cacheeasy.core.annonation.Cacheable;
import com.zero.cacheeasy.core.factory.EasyCacheManager;

/**
 * 
 * CacheAdvice.java
 * 
 * @description 缓存拦截器
 * @author ldm
 * @date 2016年12月20日
 * @detail
 */
@Aspect
public class CacheAdvice {
	private static final Logger logger = LoggerFactory.getLogger(CacheAdvice.class);

	EasyCacheManager easyCacheManager;

	@Pointcut("execution(* *(..))")
	public void cachePointCut() {
	}

	@Before(value = "cachePointCut()")
	public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
		MethodSignature ms = (MethodSignature) joinPoint.getSignature();
		// 存储缓存数据
		Cache annoCache = ms.getMethod().getAnnotation(Cache.class);
		if (annoCache != null) {
			Object proceed = joinPoint.proceed();
			easyCacheManager.putCache(annoCache.key, JSON.toJSONString(proceed));
			return proceed;
		}
		// 可缓存对象
		Cacheable annoCacheable = ms.getMethod().getAnnotation(Cacheable.class);
		if (annoCacheable != null) {
			if (easyCacheManager.hasCache(annoCacheable.key)) {
				return easyCacheManager.getCache(annoCacheable.key);
			} else {
				Object obj = joinPoint.proceed();
				easyCacheManager.putCache(annoCacheable.key, JSON.toJSONString(obj));
				return obj;
			}
		}
		return joinPoint.proceed();
	}
}
