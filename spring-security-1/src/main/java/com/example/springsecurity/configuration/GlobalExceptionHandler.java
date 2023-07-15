package com.example.springsecurity.configuration;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<Object> handleIdNotFoundMethod(AccessDeniedException ex) {
		Map<String, Object> body = new LinkedHashMap<>();
		body.put("timestamp", new Date());
		String errors = "You have not permission to handle the request";
		body.put("status", HttpStatus.BAD_REQUEST.value());
		body.put("message", errors);
		body.put("error", HttpStatus.BAD_REQUEST.getReasonPhrase());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).contentType(MediaType.APPLICATION_JSON).body(body);
	}

}