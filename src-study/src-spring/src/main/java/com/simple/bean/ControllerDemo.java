package com.simple.bean;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;

@Controller
public class ControllerDemo {
	Logger log = Logger.getLogger(this.getClass());
	public String test()
	{
		String result = "ControllerDemo.test";
		log.info(result);
		return result;
	}
}
