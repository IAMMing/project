package cn.simple.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.command.param.Command;
import com.simple.command.param.InnerCommand;

import cn.simple.util.PathUtil;

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
	@RequestMapping("/")
	public String nop(Command command)
	{
//		if(command==null||StringUtils.isEmpty(command.getParam()))		{
//			
//			return String.format("forward:%s", PathUtil.DEFAULT_PATH);
//		}
//		InnerCommand innerCommand = new InnerCommand(command);
		return "/index";
	}
	@RequestMapping("/auth")
	public String nopaa(Command command)
	{
		if(command==null||StringUtils.isEmpty(command.getParam()))		{
			System.out.println("=====");
			return String.format("forward:%s", PathUtil.DEFAULT_PATH);
		}
		System.out.println(command.getV());
		InnerCommand innerCommand = new InnerCommand(command);
		System.out.println(innerCommand.getAuthString()+"="+innerCommand.auth());
		return String.format( "forward:/%s",innerCommand.getRequestCommand());
	}
}
