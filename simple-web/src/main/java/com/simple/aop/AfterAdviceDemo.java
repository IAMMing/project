package com.simple.aop;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;

public class AfterAdviceDemo implements AfterReturningAdvice{

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {

		System.out.println(returnValue);
		System.out.println(method.getName());
		System.out.println(args.length);
		System.out.println(target);
	}

}
