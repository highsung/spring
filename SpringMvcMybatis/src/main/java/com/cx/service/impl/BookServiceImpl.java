package com.cx.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cx.mapping.BookMapper;
import com.cx.mapping.UserMapper;
import com.cx.model.Book;
import com.cx.model.User;
import com.cx.service.BookService;
import com.cx.service.UserService;

@Service
public class BookServiceImpl implements BookService {

	@Autowired
    private BookMapper userMapper;
	
	@Override
	public int save(Book book) {
		// TODO Auto-generated method stub
		userMapper.insert(book);
		return 0;
	}

}
