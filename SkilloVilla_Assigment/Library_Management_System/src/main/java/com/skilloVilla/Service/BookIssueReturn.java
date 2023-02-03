package com.skilloVilla.Service;

import java.time.LocalDate;

public interface BookIssueReturn {
	
	public LocalDate issueBook(String bookName , Integer userId);
	
	public Integer returnBook( Integer userId ,Integer bookId);
	

}
