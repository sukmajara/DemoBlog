package com.demo.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.demo.Blog.DTO.ResponseGetAllDTO;
import com.demo.Blog.DTO.ResponseGetDetailDTO;
import com.demo.Blog.service.BlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blog/user")
@CrossOrigin("*")
@Validated
public class UserController {

	@Autowired
	BlogService blogservice;
	
	@GetMapping("/get-all/{offset}/{record}")
	public ResponseEntity<ResponseGetAllDTO> getAll(@PathVariable("offset")int offset, @PathVariable("record")int record){
		return blogservice.getAll(offset, record); 
	}
	@GetMapping("/get-detail/{blogId}")
	public ResponseEntity<ResponseGetDetailDTO> getDetail(@PathVariable("blogId") @Valid  int blogId){
		return blogservice.getDetail(blogId); 
	}
}
