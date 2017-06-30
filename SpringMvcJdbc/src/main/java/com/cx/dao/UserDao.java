package com.cx.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cx.model.User;

@Repository
public class UserDao {
	
	@Autowired
	public JdbcTemplate jt;
	
	public User getUser() {
		return null;
	}
}
