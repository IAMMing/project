package cn.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

@Controller
@RequestMapping(path = "/10000")
public class NumController {

	@RequestMapping(path="/1")
	public String numTest() {
		DemoTest demoTest = new DemoTest();
		
		
//		return JSON.toJSONString(demoTest);
		return "forward:/10000/2";
	}

	@RequestMapping(path="/2",produces="application/json;charset=UTF-8")
	@ResponseBody
	public String numTest2()
	{
		DemoTest demoTest = new DemoTest();
		demoTest.setA(100);
		demoTest.setName("测试");
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
