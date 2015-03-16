package com.senyume.integration.controller;

import com.senyume.integration.domain.Book;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jigish Patel
 */

@RestController
@RequestMapping("/bookstore-rest-api")
public class BooksController {

	@RequestMapping(value = "/books", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
	public ResponseMessage read(@RequestHeader(value = "api-tracking-id", required = false) String id){
		
        List<Book> bookList = new ArrayList<Book>();
        Book book1 = new Book();
        book1.setName("The Jungle Book");
        book1.setAuthor("Rudyard Kipling");
        bookList.add(book1);

        Book book2 = new Book();
        book2.setName("Lord of the Rings");
        book2.setAuthor("J. R. R. Tolkien");
        bookList.add(book2);

        Book book3 = new Book();
        book3.setName("Harry Potter and the Philosopher's Stone");
        book3.setAuthor("J. K. Rowling");
        bookList.add(book3);
		
        return new ResponseMessage(id,bookList);
		
	}

	private class ResponseMessage {
		String id;
		List<Book> bookList;
		
		ResponseMessage(String id, List<Book> bookList){
			this.id = id;
			this.bookList = bookList;
			
		}

		public String getId() {
			return id;
		}

		public void setId(String id) {
			this.id = id;
		}

		public List<Book> getBookList() {
			return bookList;
		}

		public void setBookList(List<Book> bookList) {
			this.bookList = bookList;
		}
	}
}
