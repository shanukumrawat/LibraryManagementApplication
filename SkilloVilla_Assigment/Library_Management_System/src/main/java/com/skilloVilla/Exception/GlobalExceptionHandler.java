package com.skilloVilla.Exception;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	/*
	 * This Global class Handle the exception generate in the Library Management Application 
	 * Handle BookException 
	 * Handle UserNotFoundException
	 * Handle MethodArgumentNotValidException
	 * Handle NoHandlerFoundException
	 * Handle Exception for general exception
	 * */
	
	@ExceptionHandler(BookException.class)
	public ResponseEntity<MyErrorDetails> bookExceptionHandler(BookException be , WebRequest wb){
		
		MyErrorDetails med = new MyErrorDetails();
		
		med.setTimestamp(LocalDateTime.now());
		med.setMessage(be.getMessage());
		med.setDetails(wb.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<MyErrorDetails> userNotFoundException(UserNotFoundException unfe , WebRequest wb){
		
		MyErrorDetails med = new MyErrorDetails();
		
		med.setTimestamp(LocalDateTime.now());
		med.setMessage(unfe.getMessage());
		med.setDetails(wb.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidExceptionException(MethodArgumentNotValidException menfe , WebRequest wb){
		
		Map<String, String>  errorMap = new HashMap<>();
		menfe.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName = ((FieldError)error).getField();
		String message = error.getDefaultMessage();
	    errorMap.put(fieldName, message);
		});
		
		return new ResponseEntity<Map<String,String>>(errorMap, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyErrorDetails> notFoundExceptionHandler(NoHandlerFoundException nfe, WebRequest req ){
		
		MyErrorDetails med = new MyErrorDetails();
		
		med.setTimestamp(LocalDateTime.now());
		med.setMessage(nfe.getMessage());
		med.setDetails(req.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyErrorDetails> exceptionHandler(Exception unfe , WebRequest wb){
		
		MyErrorDetails med = new MyErrorDetails();
		
		med.setTimestamp(LocalDateTime.now());
		med.setMessage(unfe.getMessage());
		med.setDetails(wb.getDescription(false));
		return new ResponseEntity<MyErrorDetails>(med, HttpStatus.BAD_REQUEST);
	}

}
