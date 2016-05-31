package org.dubbo.service;

public class DemoService implements IDemoService {

	public String sayHello(String name) {
		String result = "hello " + name;
		System.out.println(result);
		return result;
	}

	public String getInfo() {
		return "this is service";
	}

}
