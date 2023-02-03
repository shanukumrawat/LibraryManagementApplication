package com.skilloVilla.Entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Email;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User {
	
	/*
	    * This class is Entity class name as User 
	    * This class automatically create in the data base because of Entity Annotation
	    * This class have some column mention below
	    * In this class column have validation for entering the data
	    * Class have "OneToMany" relation with the Book Entity
	    * */
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer userId;

	@Column(length = 100, nullable = false)
	private String userName;
	
	@Column(length = 100, nullable = false)
	private String userAddress;
	
	@Size(max = 10,min = 10, message = "Phone should be 10 Digit")
	@Pattern(regexp = "^[6-9][0-9]*$" , message = "Please Enter Valid Mobile Number")
	private String userContact;
	
	@Email(message = "Enter Correct Email Format")
	private String userEmail;
	
	@JsonIgnore
	@OneToMany(mappedBy = "user" )
	private List<Book> bookList = new ArrayList<>();
}
