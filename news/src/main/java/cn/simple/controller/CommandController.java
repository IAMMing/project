package cn.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class CommandController {

	@RequestMapping("/test")
	@ResponseBody
	public String test()
	{
		return "111";
	}
	@RequestMapping("/{command}")
	public String nage(@PathVariable("command")int command)
	{
		System.out.println(command);
		int subComand = command%10000;
		int superCommand=command-subComand;
		
		return "forward:/"+superCommand+"/"+subComand;
	}
}
