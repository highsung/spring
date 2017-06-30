package com.cx.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.mapping.UserMapper;
import com.cx.model.User;
import com.cx.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
    private UserMapper userMapper;
	
	@Override
	public int save(User user) {
		// TODO Auto-generated method stub
		userMapper.insert(user);
		return 0;
	}

	@Override
	public List<User> findByName(String name) {
		// TODO Auto-generated method stub
		return userMapper.findByName(name);
	}

	@Override
	public int deleteByName(String name) {
		// TODO Auto-generated method stub
		userMapper.deleteByName(name);
		return 0;
	}

	@Override
	public int updateByName(String name, String newName) {
		// TODO Auto-generated method stub
		userMapper.updateByName(name, newName);
		return 0;
	}

}
