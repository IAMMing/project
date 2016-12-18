package cn.simple.interceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class AspectTest {

	@Pointcut(value = "execution(* cn.simple..*.*(..))")
	public void pointCut() {
		System.out.println("this is point cut");
	}

	@Around("pointCut()")
	public Object aroundTest(ProceedingJoinPoint jp) throws Throwable {
		Object target = jp.getTarget();
		System.out.println("==" + target.getClass().getName());
		return jp.proceed();
	}
}
