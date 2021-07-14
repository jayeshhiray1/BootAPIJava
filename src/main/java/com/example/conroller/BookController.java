package com.example.conroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Book;
import com.example.services.FackServices;

@RestController
public class BookController {

	@Autowired
	private FackServices fackServices;

	@GetMapping("/books")
	public ResponseEntity<List<Book>> getBooks() {
//		Book book = new Book();
//		book.setId(0);
//		book.setTitle("Java Basics");
//		book.setAuther("XYZ");

		List<Book> listOfBooks = this.fackServices.getAllBooks();

		if (listOfBooks.size() <= 0) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(listOfBooks));
	}

	@GetMapping("/books/{id}")
	public ResponseEntity<Book> getBookById(@PathVariable("id") int id) {

		Book boo = this.fackServices.getBookById(id);
		if (boo == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.of(Optional.of(boo));
	}

	@PostMapping("/books")
	public ResponseEntity<String> addBoobks(@RequestBody Book books) {

		try {
			this.fackServices.addBook(books);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("Error thrown"));
		}

		return ResponseEntity.of(Optional.of("Added Book Successfully"));

	}

	@DeleteMapping("/books/{bid}")
	public ResponseEntity<String> deleteBoobks(@PathVariable("bid") int id) {

		try {
			this.fackServices.deleteBook(id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("Error thrown"));
		}

		return ResponseEntity.of(Optional.of("Deleted Book Successfully"));

	}

	@PutMapping("/books/{bid}")
	public ResponseEntity<String> updateBoobks(@RequestBody Book books, @PathVariable("bid") int id) {

		try {
			this.fackServices.updateBook(books, id);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return ResponseEntity.of(Optional.of("Error thrown"));
			
		}

		return ResponseEntity.of(Optional.of("Updated Book Successfully"));

	}

}
