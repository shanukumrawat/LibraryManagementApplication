package com.skilloVilla.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skilloVilla.Entity.Book;
import com.skilloVilla.Entity.User;
import com.skilloVilla.Exception.BookException;
import com.skilloVilla.Exception.UserNotFoundException;
import com.skilloVilla.Repository.BookRepository;
import com.skilloVilla.Repository.UserRepository;

@Service
public class BookIssueReturnImpl implements BookIssueReturn {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BookRepository bookRepository;
	
	
	/*
	 * This Method issue the book for library if book present in the library and return dueDate of Book 
	 * Assume due date 10 after the issue date of book
	 * This Method generate exception if User not exist with their userID
	 * This Method generate exception if book not available in library with Book Name
	 * This Methode generate exception if book already issued
	 * This Method generate exception id number of books per user is more than 5.
	 * */
	
	@Override
	public LocalDate issueBook(String bookName, Integer userId) {
		
		userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not present with this User ID "+ userId));
		
		bookRepository.findByBookName(bookName).orElseThrow(()-> new BookException("Book not found with this book name "+ bookName));
		
		User user = userRepository.findById(userId).get();
		
		List<Book> booklist =  user.getBookList();
		
		if(booklist.size()<=5) {
			Book book = bookRepository.findByBookName(bookName).get();
			
			if(book.isIssued()==true) {
				throw new BookException("Book already issue please issue other book");
			}
			
			book.setIssued(true);
			book.setBookIssueDate(LocalDate.now());
			book.setBookReturnDate(LocalDate.now().plusDays(10));
			book.setUser(user);
			user.getBookList().add(book);	
			bookRepository.save(book);
			userRepository.save(user);
		}
		else
		{
		  throw new BookException("Number of Book issued by User is more than 5");
		}		
		return LocalDate.now().plusDays(10);
	}

	
	/*
	 * This Method Return the book of User if User return book after due date this method generate fine 
	 * This Method generate fine according to number of days more than the due date of book
	 * This Method generate exception if User not exist with their userID
	 * This Method generate exception if book not available in library with Book Id not present in User Account
	 * */

	@Override
	public Integer returnBook(Integer userId, Integer bookId) {
		
		Integer fineAmount = 0;
		Integer fine = 10;
		
		userRepository.findById(userId).orElseThrow(()-> new UserNotFoundException("User not present with this User ID "+ userId));
		bookRepository.findById(bookId).orElseThrow(()-> new BookException("Book not found with this book ID "+ bookId));
		
		User user = userRepository.findById(userId).get();
		List<Book> bookList =  user.getBookList();
		Book bookReturn = bookRepository.findById(bookId).get();
		Iterator<Book> iterator = bookList.iterator();
		
		boolean flag = false;
		
		while(iterator.hasNext()) {
		
            Book bookItr = iterator.next(); 
			
			if(bookReturn.getBookId() == bookItr.getBookId()) {
				flag = true;
				LocalDate todayDate = LocalDate.now();
				LocalDate returnDate = bookReturn.getBookReturnDate();
				Period period = Period.between(returnDate, todayDate);
				Integer days = period.getDays();
				if(days>0) {
					fineAmount = period.getDays()*fine;
				}
				break;
			}
		}
		if(flag) {
			bookList.remove(bookReturn);
			userRepository.save(user);
			bookReturn.setBookReturnDate(null);
			bookReturn.setBookIssueDate(null);
			bookReturn.setUser(null);
			bookReturn.setIssued(false);
			bookRepository.save(bookReturn);
		}
		else
		{
		  throw	new BookException("Book Not Found in User Account");
		}
		
		return fineAmount;
	}	
}
