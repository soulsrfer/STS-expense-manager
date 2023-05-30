package com.ominMD.incomeService.excaptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ominMD.incomeService.responses.ApiResponse;

@RestControllerAdvice
public class GlobalExcaptionHendler {
	
	@ExceptionHandler(ResourceNotFoundExcaption.class)
	public ResponseEntity<ApiResponse> LorderResourceNotFoundExcaption(ResourceNotFoundExcaption ex){
		String message=ex.getMessage();
	    ApiResponse response=ApiResponse.builder().msg(message).success(true).status(HttpStatus.NOT_FOUND).build();
	    return new ResponseEntity<ApiResponse>(response,HttpStatus.NOT_FOUND);
	}

}
