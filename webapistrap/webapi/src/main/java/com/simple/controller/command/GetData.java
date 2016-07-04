package com.simple.controller.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 获取数据示例
 * 
 * @author ldm
 * @Date 2016年7月4日
 */
@Controller
@RequestMapping(path = "/10000")
public class GetData {
	@RequestMapping(path="/1", produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String getItem(@ModelAttribute("paaa") String a,HttpServletRequest request,HttpServletResponse response) {
		System.out.println(a);
		System.out.println(request.getParameter("paaa"));
		System.out.println(request.getAttribute("paaa"));
		return "111";
	}
}
