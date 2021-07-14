package com.example.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.model.Book;
import com.example.repo.BookRepository;

@Service
public class FackServices {

//	private static List<Book> list = new ArrayList<Book>();
//
//	static {
//		list.add(new Book(0, "Java", "Oracle"));
//		list.add(new Book(111, "Python", "ABC"));
//		list.add(new Book(110, "Flink", "Apache"));
//		list.add(new Book(101, "Angular", "Google"));
//		list.add(new Book(112, "Kafka", "Xyz"));
//		list.add(new Book(114, "FullStack", "All"));
//	}

	@Autowired
	private BookRepository bookRepository;

	// get all books
	public List<Book> getAllBooks() {

		return (List<Book>) this.bookRepository.findAll();
	}

	// Get book by Id

	public Book getBookById(int id) {
		Book book = null;
		try {
			// book=list.stream().filter(e -> e.getId() == id).findFirst().get();
			book = this.bookRepository.findById(id);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return book;
	}

	// Add book
	public ResponseEntity<String> addBook(Book book) {

		try {
			// list.add(book);

			this.bookRepository.save(book);

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ResponseEntity.of(Optional.of("Added Book Successfully"));// "";
	}

	// Add book
	public void deleteBook(int id) {

		// list = list.stream().filter(book -> book.getId() !=
		// id).collect(Collectors.toList());

		this.bookRepository.deleteById(id);

	}

	// Add book
	public void updateBook(Book book, int id) {

		// list.add(list.stream().filter(book -> book.getId() != id).findFirst().get());

//		list = list.stream().map(b -> {
//
//			if (b.getId() == book.getId()) {
//				b.setTitle(book.getTitle());
//				b.setAuther(book.getAuther());
//			}
//			return b;
//
//		}).collect(Collectors.toList());
		book.setId(id);
		this.bookRepository.save(book);

	}

}
