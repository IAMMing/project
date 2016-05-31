package org.dubbo.service;

public class DemoTestImpl implements IDemoTest {

	public String getName() {

		String name = "this is demo test";
		System.out.println(name);
		return name;
	}

}
