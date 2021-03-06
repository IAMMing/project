package cn.simple.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import cn.simple.annotation.CurrentDataSource;
import cn.simple.constant.DataSource;
import cn.simple.dao.MyDemoDao;
import cn.simple.dao.MyTestDao;
import cn.simple.domain.MyTest;
import cn.simple.service.DemoDaoService;
import cn.simple.service.TestDaoService;

@Controller
@RequestMapping("/mytest")
public class MyTestController {
	@Autowired
	private TestDaoService testDaoService;

	@Autowired
	private DemoDaoService demoDaoService;

	@Autowired
	private MyTestDao myTestDao;

	@Autowired
	private MyDemoDao myDemoDao;

	@RequestMapping("/list")
	public ModelAndView myTestList() {
		ModelAndView mv = new ModelAndView();
		List<MyTest> search = myTestDao.search();
		for (MyTest myTest : search) {

			System.out.println(myTest.toString());
		}
		mv.addObject("result", search);
		mv.setViewName("test/list");
		List<String> lstStr;
		return mv;
	}

	@RequestMapping("/ftl")
	public String ftlList(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("list", myTestDao.search());
		return "index";
	}

	@RequestMapping("/ftldemo")
	@CurrentDataSource(name = DataSource.DEMO_DATASOURCE)
	public String ftlDemo(@ModelAttribute("model") ModelMap model) {
		model.addAttribute("list", demoDaoService.search());
		return "demo";
	}

}
