package com.chekh.artsiom.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chekh.artsiom.model.BookUser;
import com.chekh.artsiom.repository.BookUserRepository;

@Service
public class BookUserServiceImpl implements BookUserService{

	@Autowired
	private BookUserRepository bookUserRepository;
	
	@Override
	public List<BookUser> getAllBookUser() {
		return bookUserRepository.findAll();
}

	@Override
	public void saveBookUser(BookUser bookUser) {
		this.bookUserRepository.save(bookUser);
		
	}
	
}
