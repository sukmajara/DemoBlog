package com.demo.Blog.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.demo.Blog.DTO.ResponseErrorDTO;

@ControllerAdvice
public class TypeMismatchException {
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseErrorDTO> handleMethodArgumentTypeMismatch(MethodArgumentTypeMismatchException ex) {
        return new ResponseEntity<ResponseErrorDTO>(new ResponseErrorDTO(HttpStatus.BAD_REQUEST.toString().substring(0,3),"input " +ex.getValue().toString() + " is not valid") ,HttpStatus.BAD_REQUEST);
    }
}
