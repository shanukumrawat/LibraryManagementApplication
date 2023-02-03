package com.skilloVilla.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.skilloVilla.Entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
	
	/* This Repository use access to data base with Book entity
	 * By with the help of this we fetch the data from the data base of Book entity
	 * this repository is stablish connection between the database database and entity(Book Class)
	 *  */

    /* This method find the book present in the library by with the help book name and return Optional<Book> */
	@Query
	public Optional<Book> findByBookName(String bookName);  
	
}
