package com.zero.cache.map;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.aspectj.lang.ProceedingJoinPoint;
import org.springframework.stereotype.Component;

@Component
public class TestAdvice {
	static ConcurrentMap<String, String> map = new ConcurrentHashMap<>();

	public Object around(ProceedingJoinPoint jp) throws Throwable {
		Class[] interfaces = jp.getSignature().getDeclaringType().getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1.getName());
		}
		String qualifiedMethodName = jp.getSignature().getDeclaringTypeName() + "." + jp.getSignature().getName();
		if (map.containsKey(qualifiedMethodName)) {
			return map.get(qualifiedMethodName);
		} else {
			Object proceed = jp.proceed();
			map.put(qualifiedMethodName, proceed.toString());
			return proceed;
		}

	}
}
