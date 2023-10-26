package com.deelip_acciojob.bookManager;

import java.util.ArrayList;
import java. util.HashMap;
import java.util.List;
import java. util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class BookController {

	Map<Integer,Book> bookdata = new HashMap<>();
	
	@PostMapping("/add-book")
	public String addBook(@RequestBody Book book) {
		bookdata.put(book.getId(), book);
		return "Book created with id : " + book.getId();
	}
	
	@GetMapping("/get-book")
	public Book getBook( @RequestParam Integer id) {
		return bookdata.get(id);
	}
	
	@GetMapping("/get-all-books")
	public List<Book> getAllBooks() {
		return new ArrayList<>(bookdata.values());
	}
	
	
	@GetMapping("/get-book-by-name/{name}") // /get-book-by-name/harry potter
	public Book getBookByName(@PathVariable String name) {
		for (Map.Entry<Integer, Book> entry : bookdata.entrySet()) {
			if(entry.getValue().getTitle().equals(name)) {
				return entry.getValue();
			}
		}
		
		return null;
	}
	
	
	@PutMapping("/update-book-page/{id}")
	public Book updateBookPages(@PathVariable Integer id, @RequestParam Integer pages) {
		Book book = bookdata.get(id);
		book.setPages(pages);;
		bookdata.put(id, book);
		return book;
		
	}
	
	@PutMapping("/update-book-author")
	public Book updateBookAuthor(@RequestParam Integer id, @RequestParam String author) {
		Book book = bookdata.get(id);
		book.setAuthor(author);
		bookdata.put(id, book);
		return book;
	}
	
	@DeleteMapping("/delete-book/{id}")
	public String deleteBook(@PathVariable Integer id) {
		bookdata.remove(id);
		
		return "book deleted with id :"+ id;
	}
	
	
}
