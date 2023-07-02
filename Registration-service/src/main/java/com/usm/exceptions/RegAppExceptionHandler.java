package com.usm.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class RegAppExceptionHandler {
	
	@ExceptionHandler(value=RegAppExcetion.class)
	public ResponseEntity<AppError> handleException(RegAppExcetion regAppException) {
		
		AppError appError = new AppError();
		appError.setErrorCode("Reg404");
		appError.setMsg(regAppException.getMessage());
		
		ResponseEntity<AppError> entity = new ResponseEntity<>(appError, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
	}

}
