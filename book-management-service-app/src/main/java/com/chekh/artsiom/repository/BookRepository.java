package com.chekh.artsiom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chekh.artsiom.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
