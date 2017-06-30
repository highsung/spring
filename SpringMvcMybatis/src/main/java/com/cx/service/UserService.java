package com.cx.service;

import java.util.List;

import com.cx.model.User;

public interface UserService {
	int save(User user);
	List<User> findByName(String name);
	int deleteByName(String name);
	int updateByName(String name, String newName);
}
