package org.dubbo.client;

import org.dubbo.service.IDemoService;
import org.dubbo.service.IDemoTest;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
				new String[] { "spring/spring-client.xml" });
		context.start();

		IDemoService demoService = (IDemoService) context.getBean("demoService"); // 获取远程服务代理
		String hello = demoService.sayHello("world"); // 执行远程方法

		System.out.println(hello); // 显示调用结果

		IDemoTest demoTest = (IDemoTest) context.getBean("demotest");
		String name = demoTest.getName();
		System.out.println(name);
	}
}
