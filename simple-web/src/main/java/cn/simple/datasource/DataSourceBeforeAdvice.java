package cn.simple.datasource;

import java.lang.reflect.Method;

import org.springframework.aop.MethodBeforeAdvice;

import cn.simple.annotation.CurrentDataSource;

public class DataSourceBeforeAdvice implements MethodBeforeAdvice {

	public void before(Method method, Object[] args, Object target) throws Throwable {
		CurrentDataSource cds = null;
		cds = target.getClass().getAnnotation(CurrentDataSource.class);
		if (cds == null) {
			cds = method.getAnnotation(CurrentDataSource.class);
		}
		if (cds != null) {
			DataSourceHolder.setTargetDataSource(cds.name());
			System.out.println("before advice==========================" + cds.name());
		}
	}

}
