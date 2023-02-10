package com.chekh.artsiom.service;

import java.util.List;

import com.chekh.artsiom.model.Book;


public interface BookService {
	List<Book> getAllBook();
	void saveBook(Book book);
	void deleteBookById(long id);
	Book getBookById(long id);
}
