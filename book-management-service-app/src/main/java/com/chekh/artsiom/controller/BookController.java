package com.chekh.artsiom.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.chekh.artsiom.model.Book;
import com.chekh.artsiom.service.BookService;

@Controller
public class BookController {

	@Autowired
	private BookService bookService;

	// display list of book
	@GetMapping("/")
	public String viewHomePageString(Model model) {

		model.addAttribute("listBooks", bookService.getAllBook());

		return "index";
	}

	@GetMapping("/showNewBookForm")
	public String showNewBookForm(Model model) {

		Book book = new Book();

		model.addAttribute("book", book);

		return "new_book";
	}

	@PostMapping("/saveBook/{id}")
	public String saveBook(@PathVariable(value = "id") long id, @Valid @ModelAttribute("book") Book book,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "new_book";
		} else {
			// save book to database
			bookService.saveBook(book);
			return "redirect:/";
		}

	}

	@GetMapping("/deleteBook/{id}")
	public String deleteBook(@PathVariable(value = "id") long id) {

		// call delete book method
		this.bookService.deleteBookById(id);

		return "redirect:/";
	}

	@GetMapping("/showFormForUpdate/{id}")
	public String showFormForUpdate(@PathVariable(value = "id") long id, Model model) {

		// get book from the service
		Book book = bookService.getBookById(id);

		// set book as a model attribute to pre-populate the form
		model.addAttribute("book", book);

		return "update_book";
	}

	// display more info of book
	@GetMapping("/moreInfo/{id}")
	public String viewMoreInfoPageString(@PathVariable(value = "id") long id, Model model) {
		// get book from the service
		Book book = bookService.getBookById(id);

		model.addAttribute("book", book);

		return "more_info";
	}

	// showFormForDescriptionUpdate
	@GetMapping("/showFormForDescriptionUpdate/{id}")
	public String showFormForDescriptionUpdate(@PathVariable(value = "id") long id, Model model) {

		// get book from the service
		Book book = bookService.getBookById(id);

		// set book as a model attribute to pre-populate the form
		model.addAttribute("book", book);

		return "update_book_description";

	}

	@PostMapping("/saveBookDescription/{id}")
	public String saveBookDescription(@PathVariable(value = "id") long id, @Valid @ModelAttribute("book") Book book,
			BindingResult bindingResult) {

		if (bindingResult.hasErrors()) {
			return "update_book_description";
		} else {
			// save book description to database
			bookService.saveBook(book);
			return "redirect:/moreInfo/{id}";
		}

	}

}
