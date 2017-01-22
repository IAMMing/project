package org.noclass.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("first")
public class FirstController {

	@RequestMapping("text")
	@ResponseBody
	public String text() {
		return "i am ming";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}
}
