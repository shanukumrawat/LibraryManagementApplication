package com.skilloVilla.Exception;
import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class MyErrorDetails {
	
	private LocalDateTime timestamp;
	private String message;
	private String details;
	
	public  MyErrorDetails() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public  MyErrorDetails(LocalDateTime timestamp, String message, String details) {
		super();
		this.timestamp = timestamp;
		this.message = message;
		this.details = details;
	}
	
	

}

