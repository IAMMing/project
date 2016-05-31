package cn.simple.interceptor;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.MethodBeforeAdvice;

public class TestAop2 implements MethodBeforeAdvice,AfterReturningAdvice {

	public void before(Method arg0, Object[] arg1, Object arg2) throws Throwable {

		System.out.println("before advice");
	}

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		// TODO Auto-generated method stub
		
	}

}
