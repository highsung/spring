package com.cx.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.dao.UserMapper;
import com.cx.entity.User;

/*
 * 自动生成代码文档
 * http://www.jianshu.com/p/e09d2370b796
 * MyBatis文档
 * http://www.mybatis.org/mybatis-3/zh/getting-started.html
 * ***/
@Controller
public class MyController {

	@Autowired 
	UserMapper usermapper;
	
	@ResponseBody
	@RequestMapping("/gen")
	public String gen() {
		
		User u = new User("ZZZ",22);
		usermapper.insert(u);
		return "ok";
	}
}
