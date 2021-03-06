package cn.simple.datasource;

import java.lang.reflect.Method;

import org.springframework.aop.AfterReturningAdvice;
import org.springframework.aop.ThrowsAdvice;

public class DataSourceAfterAdvice implements AfterReturningAdvice, ThrowsAdvice {

	public void afterReturning(Object returnValue, Method method, Object[] args, Object target) throws Throwable {
		DataSourceHolder.clearTargetDataSource();
	}
	
	public void afterThrowing(Exception ex) {
		DataSourceHolder.clearTargetDataSource();
	}

}
