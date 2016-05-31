package cn.simple.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.simple.annotation.AvoidDuplicateSubmission;

@Controller
@RequestMapping("/form")
public class FormController {

	@AvoidDuplicateSubmission(saveToken = true)
	@RequestMapping("/reg")
	public ModelAndView reg() {
		System.out.println("this is reg");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/form");
		return mv;
	}

	@AvoidDuplicateSubmission(removeToken = true)
	@RequestMapping("/save")
	public ModelAndView save() {
		System.out.println("here is save");
		ModelAndView mv = new ModelAndView();
		mv.setViewName("/save");
		return mv;
	}
}
