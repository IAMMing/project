package com.simple.controller;

import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.simple.command.param.Command;
import com.simple.command.param.InnerCommand;

/**
 * 基础controller直接解析客户端最原始的请求命令
 * 
 * @author ldm
 * @Date 2016年7月4日
 */
@Controller
@RequestMapping("/")
public class CommandController {
	/**
	 * 解析对象参数的控制器
	 * </p>
	 * 这个控制器一般是总的api入口
	 * 
	 * @author ldm
	 * @Date 2016年7月4日
	 * @param command
	 * @return
	 */
	@RequestMapping("/")
	public String command(Command command, RedirectAttributes attr,Model model) {
		if (command == null || StringUtils.isEmpty(command.getParam())) {
			System.out.println("=====");
			return String.format("forward:/%s", "index");
		}
		InnerCommand innerCommand = new InnerCommand(command);
		String authResult = innerCommand.auth();
		if (authResult == null) {
			// 验证失败
			return "{b:'验证失败'}";
		} else {
			String requestParam = innerCommand.getRequestParam();
			String jsonString = requestParam.substring(1, requestParam.length() - 1);
			System.out.println(jsonString);
			JSONObject jsonObj = JSON.parseObject(jsonString);

			// attr.addAllAttributes(jsonObj.entrySet());
			for (Entry<String, Object> e : jsonObj.entrySet()) {
				System.out.println(e.getKey() + "=" + e.getValue());
				attr.addFlashAttribute(e.getKey(), e.getValue());
				model.addAttribute(e.getKey(), e.getValue());
				
			}

		}
		return String.format("forward:/%s", innerCommand.getRequestCommand());
	}

	/**
	 * 解析命令的控制器
	 * </p>
	 * 这个action是由{@link com.simple.controller.CommandController.command }
	 * 对象参数中解析出来的命令跳转过来
	 * 
	 * @author ldm
	 * @Date 2016年7月4日
	 * @param command
	 * @return
	 */
	@RequestMapping("/{command}")
	public String nage(@PathVariable("command") int command, @ModelAttribute("paaa") String a,Command cmd) {
		System.out.println(command);
		int subComand = command % 10000;
		int superCommand = command - subComand;
		System.out.println(a);
		
		if(cmd!=null)
		{
			System.out.println(cmd.getParam());
		}
		else
		{
			System.out.println("-----------------");
		}
		
		return "forward:/" + superCommand + "/" + subComand;
	}

	/**
	 * 默认访问页面
	 * </p>
	 * 此页面不需要验证身份
	 * 
	 * @author ldm
	 * @Date 2016年7月4日
	 * @return
	 */
	@RequestMapping("/index")
	public String index() {
		return "/index";
	}

}
