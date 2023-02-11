package com.chekh.artsiom.service;

import java.util.List;

import com.chekh.artsiom.model.Book;
import com.chekh.artsiom.model.BookUser;

public interface BookUserService {
	
List<BookUser> getAllBookUser();
void saveBookUser(BookUser bookUser);

}
