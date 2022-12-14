package com.cmg.Springboot.advisor;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;

import com.cmg.Springboot.util.ResponseUtil;

@CrossOrigin
@RestControllerAdvice
public class ExceptionHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	 @org.springframework.web.bind.annotation.ExceptionHandler({Exception.class})
	public ResponseUtil exceptionHandler(Exception e) {
		   return new ResponseUtil(500, e.getMessage(), null);
	}
}
