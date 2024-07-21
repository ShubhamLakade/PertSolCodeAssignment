package com.pertsol.exception;

import java.time.format.DateTimeParseException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class CommonCommentsExceptionJHandler {

	@ExceptionHandler(value={CustomException.class})
	public ResponseEntity<Object> handleCustomeException(CustomException custException)
	{
		CommentsException commentsException = new CommentsException(custException.getMessage(), custException.getCause(), HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(commentsException,HttpStatus.NOT_FOUND);
	}
	
    @ExceptionHandler(DateTimeParseException.class)
    public ResponseEntity<Object> handleDateTimeException(DateTimeParseException ex) {
    	CommentsException commentsException = new CommentsException(
                "Invalid date format. Date format should be yyyy-mm-dd",
                ex.getCause(),
                HttpStatus.BAD_REQUEST
        );
        return new ResponseEntity<>(commentsException,HttpStatus.NOT_FOUND);
    }
}
