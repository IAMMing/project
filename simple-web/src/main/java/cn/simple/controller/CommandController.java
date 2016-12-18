package cn.simple.controller;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.simple.command.param.Command;
import com.simple.command.param.InnerCommand;

import cn.simple.util.Constant;
import cn.simple.util.PathUtil;

@Controller
@RequestMapping("/")
public class CommandController {

	@RequestMapping("/test")
	@ResponseBody
	public String test() {
		// BeanTest
		// bt=(BeanTest)ContextLoader.getCurrentWebApplicationContext().getBean("beanTest");
		// bt.testBean();
		// try {
		// Thread t= new Thread(new Runnable() {
		//
		// public void run() {
		// // TODO Auto-generated method stub
		// while (true) {
		// System.out.println("this is a new thread");
		// try {
		// Thread.sleep(5000);
		// } catch (InterruptedException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// try {
		// throw new Exception("线程内抛出异常");
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// }
		// }
		// });//.start();
		// t.isAlive();
		// } catch (Exception e) {
		// // TODO 是捕捉不到线程内的异常的
		// System.out.println("线程外尝试捕获异常");
		// e.printStackTrace();
		// }
		// Constant.REQUESTPATH.add("test");
		// System.out.println(Constant.REQUESTPATH.size());
		return "111";
	}

	@RequestMapping("/{command}")
	public String nage(@PathVariable("command") int command) {
		System.out.println(command);
		int subComand = command % 10000;
		int superCommand = command - subComand;

		return "forward:/" + superCommand + "/" + subComand;
	}

	@RequestMapping("/")
	public String nop(Command command) {
		// if(command==null||StringUtils.isEmpty(command.getParam())) {
		//
		// return String.format("forward:%s", PathUtil.DEFAULT_PATH);
		// }
		// InnerCommand innerCommand = new InnerCommand(command);

		Constant.REQUESTPATH.add("index");
		System.out.println(Constant.REQUESTPATH.size());
		return "/index";
	}

	@RequestMapping("/auth")
	public String nopaa(Command command) {
		if (command == null || StringUtils.isEmpty(command.getParam())) {
			System.out.println("=====");
			return String.format("forward:%s", PathUtil.DEFAULT_PATH);
		}
		System.out.println(command.getV());
		InnerCommand innerCommand = new InnerCommand(command);
		System.out.println(innerCommand.getAuthString() + "=" + innerCommand.auth());
		return String.format("forward:/%s", innerCommand.getRequestCommand());
	}
}
