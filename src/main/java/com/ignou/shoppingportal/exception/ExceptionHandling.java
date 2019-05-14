package com.ignou.shoppingportal.exception;

import javax.persistence.NoResultException;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class ExceptionHandling  extends RuntimeException{
	
	
	private static final long serialVersionUID = 1L;
	
	
   @ExceptionHandler(NoHandlerFoundException.class)
   
	public void handlerNoHandlerFoundException(NoHandlerFoundException ex)
   {
	   System.out.println("THIS PAGE YOU ARE LOOKING FOR NOT AVAILABLE"); 
   }
   
   @ExceptionHandler(NullPointerException.class)
   public void handleDatatNotFoundException (NullPointerException ex)
   {
	   System.out.println("THESE ARE NOT A VALID ID TRY ANOTHER"); 
   }
   @ExceptionHandler(NoResultException.class)
   public void LoginException (NoResultException ex)
   {
	   System.out.println("INVALID USERNAME AND PASSWORD TRY ANOTHER"); 
   }
   
  
}
