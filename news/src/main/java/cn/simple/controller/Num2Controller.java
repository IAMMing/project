package cn.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping("/10000")
public class Num2Controller {
	@RequestMapping(path="/3",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String num() {

		DemoTest demoTest = new DemoTest();
		demoTest.setA(33);
		demoTest.setName("测试3");
		return JSON.toJSONString(demoTest);
	}

	class DemoTest {
		private int a = 5;
		private String name = "numtest";

		public int getA() {
			return a;
		}

		public void setA(int a) {
			this.a = a;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

	}
}
