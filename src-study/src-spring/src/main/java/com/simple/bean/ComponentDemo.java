package com.simple.bean;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class ComponentDemo {
	Logger log= Logger.getLogger(ComponentDemo.class);
	public String test() {
		String result = "this is ComponentDemo.test";
		log.info(result);
		return result;
	}
}
