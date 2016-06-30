package cn.simple.interceptor;

import java.lang.reflect.Method;

import org.apache.commons.lang.ArrayUtils;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.web.bind.annotation.RequestMapping;

@Aspect
public class TestAOP {
	@Pointcut("execution(* cn.simple.controller.TestController.*(..) )")
	public void anyMethod() {
		System.out.println("point cut");
	}

	@Before("anyMethod()")
	public void beforeTest(JoinPoint point) throws DupliException {

		
		throw new DupliException("不能重复提交");
	}

	@After("anyMethod()")
	public void afterTest(JoinPoint jp) {
		System.out.println("this is after");
		Object[] args = jp.getArgs();
		System.out.println(jp.getTarget());

		System.out.println(jp.getSignature().getDeclaringTypeName());
		System.out.println("获取方法名：" + jp.getSignature().getName());

		MethodSignature sign = (MethodSignature) jp.getSignature();
		Method method = sign.getMethod();
		RequestMapping annotation = method.getAnnotation(RequestMapping.class);
		if (annotation == null) {
			System.out.println("annotation is null");
		} else {
			String[] value = annotation.value();
			System.out.println(ArrayUtils.toString(value));
		}
	}
}
