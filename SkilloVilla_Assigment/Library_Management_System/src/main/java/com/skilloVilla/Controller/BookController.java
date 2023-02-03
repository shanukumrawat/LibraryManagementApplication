package com.skilloVilla.Controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.skilloVilla.Service.BookIssueReturnImpl;

@RestController
public class BookController {
	
	@Autowired
	BookIssueReturnImpl bookIssueReturnImpl;

	/* Issue book API */
	@PostMapping("/bookIssue/{userId}")
	public ResponseEntity<LocalDate> bookIssueControlHandler(
		    @PathVariable("userId") Integer userId,
			@RequestParam String bookName){
		
		LocalDate date = bookIssueReturnImpl.issueBook(bookName, userId);
		
		return new ResponseEntity<LocalDate>(date, HttpStatus.OK);
	}
	
	
	/* Return Book API */
	@PostMapping("/bookReturn/{userId}/{bookId}")
	public ResponseEntity<Integer> bookReturnControlHandler(
			@PathVariable("userId") Integer userId,
			@PathVariable("bookId") Integer bookId){
		
		Integer Response = bookIssueReturnImpl.returnBook( userId, bookId);
		
		return new ResponseEntity<Integer>(Response, HttpStatus.OK);
	}

}
