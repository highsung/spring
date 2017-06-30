package com.cx.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cx.mapping.UserMapper;
import com.cx.model.Book;
import com.cx.model.User;
import com.cx.service.BookService;
import com.cx.service.UserService;

@Controller
public class MyController {
	
	@Autowired  
    private UserMapper userMapper;
	
	@Autowired  
    private UserService userService; 

	@Autowired  
    private BookService bookService; 
	
	@ResponseBody
	@RequestMapping(value="/test")
	public String test() {
		
		User user = new User("xiong12",1112);
		userService.save(user);
		
		return  "test";
	}
	
	
	@ResponseBody
	@RequestMapping(value="/test1")
	public String test1() {
		
		Book book = new Book("hai",1);
		bookService.save(book);
		
		return  "test";
	}
	
	@ResponseBody
	@RequestMapping(value="/test2")
	public String test2() {
		
		List<User> users = userService.findByName("xiong");
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<users.size();i++) {
			sb.append("name:"+users.get(i).getName());
			sb.append("age:"+users.get(i).getAge());
			sb.append("<br/>");
		}
		return sb.toString();
	}
	
	@RequestMapping(value="/test3")
	public String test4() {
		
		userService.updateByName("xiong1123","xiong1123aa");
		return "forward:/test2";
	}
	
	@RequestMapping(value="/test4/{name}")
	public String test4(@PathVariable(value="name")String name) {
		
		userService.deleteByName(name);
		return "forward:/test2";
	}
	
	@ResponseBody
	@RequestMapping(value="/test5/{name}")
	public String test5(@PathVariable(value="name")String name) {
		
		List<User> users=userMapper.selectByName(name);
		StringBuilder sb = new StringBuilder();
		for(int i=0;i<users.size();i++) {
			sb.append("name:"+users.get(i).getName());
			sb.append("age:"+users.get(i).getAge());
			sb.append("<br/>");
		}
		return sb.toString();
	}
}
