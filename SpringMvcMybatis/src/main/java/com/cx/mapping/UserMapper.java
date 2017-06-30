package com.cx.mapping;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.cx.model.User;

public interface UserMapper {
	
	int insert(User user);
	
	List<User> findByName(String name);
	
	int deleteByName(String name);
	
	int updateByName(String name, String newName);
	
	
	@Select("SELECT * FROM user WHERE name = #{name}")
	List<User> selectByName(String name);
	
	/*
    int deleteByPrimaryKey(Long id);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
    */
}
