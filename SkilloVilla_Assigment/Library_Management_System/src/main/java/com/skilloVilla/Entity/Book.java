package com.skilloVilla.Entity;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.AssertFalse;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Size;
import javax.validation.groups.Default;

import org.springframework.beans.factory.annotation.Value;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Book {
	
   /*
    * This class is Entity class name as Book 
    * This class automatically create in the data base because of Entity Annotation
    * This class have some column mention below
    * In this class column have validation for entering the data
    * Class have "ManyToOne" relation with the User Entity
    * */
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer bookId;
	
	@Column(length = 100, nullable = false)
	private String bookName;
	
	@Column(length = 100, nullable = false)
	private String bookAuthor;
	
	@Column(length = 500, nullable = false)
	private String bookPublisher;
	
    @Column(length = 2500)
	private String bookDescription;
    
    private LocalDate bookIssueDate;
    
    private LocalDate bookReturnDate;
    
    private boolean isIssued = false;
    
    @ManyToOne
    private User user;
    
   	
}
