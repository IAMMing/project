package cn.simple.controller;

import org.springframework.stereotype.Component;

@Component("beanTest")
public class BeanTest {
	public void testBean() {
		System.out.println("this is testbean");
	}
}
