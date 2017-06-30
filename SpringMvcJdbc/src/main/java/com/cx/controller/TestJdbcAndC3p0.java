package com.cx.controller;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestJdbcAndC3p0 {
	
	@Autowired
	public JdbcTemplate jt;
	
	@RequestMapping(value="/stu")
	public String getStu(@RequestParam(name="name")String name,@RequestParam(name="age")int age) {
		
		jt.execute("create table if not exists user(name varchar(32), age int)");
		jt.execute("insert into user(name,age) values('"+name+"',"+age+")");
		
		return "forward:/stu/all";
	}
	
	@ResponseBody
	@RequestMapping(value="/stu/all")
	public String getStu1() {
		
		final StringBuilder s = new StringBuilder();
		
		jt.query("select * from user", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet arg0) throws SQLException {
				s.append(arg0.getString(1));
				s.append("---");
				s.append(arg0.getInt(2));
				s.append("<br/>");
			}
		});

		return s.toString();
	}
	
	@ResponseBody
	@RequestMapping(value="/stu/{name}")
	public String getStu2(@PathVariable("name")String name) {
		
		final StringBuilder s = new StringBuilder();
		
		jt.query("select * from user where name='"+name+"'", new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet arg0) throws SQLException {
				// TODO Auto-generated method stub
				while(!arg0.isAfterLast()) {
					s.append(arg0.getString(1));
					s.append("---");
					s.append(arg0.getInt(2));
					s.append("<br/>");
					arg0.next();
				}
			}
		});
		return s.toString();
	}
	
	
	@RequestMapping(value="/stu/delete/{name}")
	public String getStu3(@PathVariable("name")String name) {		
		jt.execute("delete from user where name='"+name+"'");
		
		return "forward:/stu/all";
	}
	
	
	@RequestMapping(value="/stu/update/{name}/{newname}")
	public String getStu3(@PathVariable("name")String name,@PathVariable("newname")String newname) {		
		jt.execute("update user set name='"+newname+"' where name='"+name+"'");
		
		return "forward:/stu/all";
	}
}
