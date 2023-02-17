package com.chekh.artsiom.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "books")
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "book_title")
	@NotEmpty(message = "Book title cannot be empty!")
	private String bookTitle;

	@Column(name = "book_author")
	@NotEmpty(message = "Book author cannot be empty!")
	private String bookAuthor;

	@Column(name = "book_genre")
	@NotEmpty(message = "Book genre cannot be empty!")
	private String bookGenre;

	@Column(name = "book_status")
	private String bookStatus;

	@Column(name = "brief_description")
	@NotEmpty(message = "Book description cannot be empty!")
	@Size(max = 1000)
	private String briefDescription;

	public Book(long id, String bookTitle, String bookAuthor, String bookGenre, String bookStatus,
			String briefDescription) {
		super();
		this.id = id;
		this.bookTitle = bookTitle;
		this.bookAuthor = bookAuthor;
		this.bookGenre = bookGenre;
		this.bookStatus = bookStatus;
		this.briefDescription = briefDescription;
	}

	public Book() {

	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getBookTitle() {
		return bookTitle;
	}

	public void setBookTitle(String bookTitle) {
		this.bookTitle = bookTitle;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getBookGenre() {
		return bookGenre;
	}

	public void setBookGenre(String bookGenre) {
		this.bookGenre = bookGenre;
	}

	public String getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(String bookStatus) {
		this.bookStatus = bookStatus;
	}

	public String getBriefDescription() {
		return briefDescription;
	}

	public void setBriefDescription(String briefDescription) {
		this.briefDescription = briefDescription;
	}

}
