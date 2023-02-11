package com.chekh.artsiom.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.chekh.artsiom.model.BookUser;

public interface BookUserRepository extends JpaRepository<BookUser, Long>{

}
