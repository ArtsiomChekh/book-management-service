package com.chekh.artsiom.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.chekh.artsiom.model.Book;
import com.chekh.artsiom.model.BookUser;
import com.chekh.artsiom.service.BookUserService;

@Controller
public class BookUserController {

	@Autowired
	private BookUserService bookUserService;

	// display list of user
	@GetMapping("/moreInfo")
	public String viewMoreInfoPageString(Model model) {
		model.addAttribute("listBookUsers", bookUserService.getAllBookUser());
		return "more_info";

	}
	
	@GetMapping("/showNewBookUserForm")
	public String showNewBookForm(Model model) {
		BookUser bookUser = new BookUser();
		model.addAttribute("bookUser", bookUser);
		return "new_book_user";
	}
	
	 @PostMapping("/saveBookUser")
	 public String saveBookUser(@ModelAttribute("bookUser") BookUser bookUser) {
	     // save user to database
	     bookUserService.saveBookUser(bookUser);
	     return "redirect:/moreInfo";
	 }

}
