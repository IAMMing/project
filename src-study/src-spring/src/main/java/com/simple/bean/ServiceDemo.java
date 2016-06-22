package com.simple.bean;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
@Service
public class ServiceDemo {
	Logger logger = Logger.getLogger(this.getClass());

	public String test() {
		String result = "ServiceDemo.test()";
		logger.info(result);
		return result;
	}
}
