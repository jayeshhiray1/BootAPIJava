package com.example.repo;

import org.springframework.data.repository.CrudRepository;

import com.example.model.Book;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public Book findById(int id);

}
