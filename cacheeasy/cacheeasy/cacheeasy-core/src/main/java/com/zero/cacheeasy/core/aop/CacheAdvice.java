package com.zero.cacheeasy.core.aop;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
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

	/**
	 * 解析缓存的key
	 * 
	 * @return
	 */
	private String analyzeCacheKey(Object[] methodArgs, String setKey) {
		if (StringUtils.isEmpty(setKey)) {
			return null;
		}
		// 只解析包含有变量值的参数
		if (setKey.contains("{") && setKey.contains("}")) {
			String varKey = StringUtils.substringBetween(setKey, "{", "}");
			// 验证从参数中取变量
			if (varKey.startsWith("args")) {
				// 取参数索引
				String varIndex = StringUtils.substringBetween(varKey, "[", "]");
				if (Integer.parseInt(varIndex) < methodArgs.length - 1) {
					// 获取指定参数
					Object arg = methodArgs[Integer.parseInt(varIndex)];
					if (varKey.indexOf(".") > -1) {

						try {
							// 获取属性值
							String simpleProperty = BeanUtils.getSimpleProperty(arg, varKey.split("\\.")[0]);
							return setKey.replace("{" + varKey + "}", simpleProperty);
						} catch (Exception e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						return setKey;
					} else {
						return setKey.replace("{" + varKey + "}", String.valueOf(arg));
					}
				} else {
					return setKey;
				}
			} else {
				return setKey;
			}
		} else {
			return setKey;
		}
	}

	public static void main(String[] args) {
		System.out.println(StringUtils.substringBetween("sfaf{13246}sdfsdf", "{", "}"));
	}
}
