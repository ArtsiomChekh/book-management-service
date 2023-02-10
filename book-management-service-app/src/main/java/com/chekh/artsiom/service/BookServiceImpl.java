package com.chekh.artsiom.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.chekh.artsiom.model.Book;
import com.chekh.artsiom.repository.BookRepository;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookRepository bookRepository;

	@Override
	public List<Book> getAllBook() {
		return bookRepository.findAll();
	}

	@Override
	public void saveBook(Book book) {
		this.bookRepository.save(book);
		
	}

	@Override
	public void deleteBookById(long id) {
		this.bookRepository.deleteById(id);
	}

	@Override
	public Book getBookById(long id) {
		Optional<Book> optional = bookRepository.findById(id);
		Book book = null;
		if(optional.isPresent()) {
			book = optional.get();
		} else {
			  throw new RuntimeException(" Book not found for id :: " + id);
		}
		return book;
	}

}
