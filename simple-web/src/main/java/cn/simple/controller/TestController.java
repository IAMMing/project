package cn.simple.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.simple.service.ITestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	ITestService testService;

	@RequestMapping("/index")
	@ResponseBody
	public String index() {
		System.out.println(testService.testService());
		return "this is test";
	}

	@RequestMapping("/index2")
	@ResponseBody
	public String index2() {
		return "this is test2";
	}

	@RequestMapping("/second")
	public ModelAndView second() {
		ModelAndView mv = new ModelAndView();

		return mv;
	}
	@RequestMapping(path="/ajax")
	public ModelAndView page()
	{
		ModelAndView mv=new ModelAndView();
		mv.setViewName("test/ajax");
		return mv;
	}
	@RequestMapping("jstl")
	public ModelAndView jstlTest() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("jstl");
		return mv;
	}

	@RequestMapping("var")
	public ModelAndView varTest() {
		ModelAndView mv = new ModelAndView();
		mv.addObject("v", 120);
		mv.addObject("v1", 120);
		mv.addObject("v2", 120);
		mv.addObject("v3", 120);
		mv.addObject("v4", 120);
		mv.addObject("v5", 120);
		mv.addObject("v6", 120);
		mv.addObject("v7", 120);
		mv.addObject("v8", 120);
		mv.addObject("v9", 120);
		mv.addObject("v10", 120);
		mv.addObject("v11", 120);
		mv.addObject("v12", 120);
		mv.addObject("v13", 120);
		mv.addObject("v14", 120);
		mv.addObject("v15", 120);
		mv.setViewName("var");
		return mv;
	}
}
