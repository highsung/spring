package com.cx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.cx.model.Student;

@Controller
@RequestMapping("/first")
public class FirstController {

	@RequestMapping("/hellospring/{id}")
	public String hello(@PathVariable("id") String id) {
		System.out.println("hello spring mvc");
		System.out.println("id:"+id);
		return "success1";
	}
	
	@RequestMapping("/hellospring")
	@ResponseBody
	public String getParams(@RequestParam(value="userName")String userName) {
		return "usrName:"+userName;
	}
	
	@RequestMapping(value="/hellospring1",method=RequestMethod.POST)
	@ResponseBody
	public String getParams1(Student stu) {
		return "usrName:"+stu.getName()+",age:"+stu.getAge();
	}
	
	@RequestMapping("/success.do")
	public String success() {
		System.out.println("hello spring mvc success");
		return "success1";
	}
	
	@RequestMapping("/modeview")
	public ModelAndView modeview() {
			
		ModelAndView mv = new ModelAndView();
		mv.setViewName("user");
		mv.addObject("name","maommoa");
		mv.addObject("age",11);
		mv.addObject("user", new Student("白石老人",100));
		System.out.println("mv");
		return mv;
	}
	
	@RequestMapping("/content")
	@ResponseBody
	public String content() {
		String hello="<h1>h1</h1>";
		hello += "<form action='hellospring1' method=post><input type='text' name='name'>";
		hello += "<form><input type='text' name='age'>";
		hello += "<input type='submit' value='提交'/></form>";
		return hello;
	}

}
