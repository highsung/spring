package com.cx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController2 {

	@ResponseBody
	@RequestMapping(value="/stu/aa")
	public String getStu() {
		return  "student2";
	}
}
