package com.demo.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Blog.DTO.CreateRequestDTO;
import com.demo.Blog.DTO.DeleteRequestDTO;
import com.demo.Blog.DTO.ResponseCreateDTO;
import com.demo.Blog.DTO.ResponseDeleteDTO;
import com.demo.Blog.DTO.ResponseUpdateDTO;
import com.demo.Blog.DTO.UpdateRequestDTO;
import com.demo.Blog.service.BlogService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/blog/admin")
@CrossOrigin("*")
public class AdminController {
	@Autowired
	BlogService blogservice;

	@PostMapping("/create")
	public ResponseEntity<ResponseCreateDTO> createBlog(@RequestBody @Valid CreateRequestDTO cdto) {
		return blogservice.createBlog(cdto);
	}

	@PatchMapping("/update")
	public ResponseEntity<ResponseUpdateDTO> createBlog(@RequestBody @Valid UpdateRequestDTO udto) {
		return blogservice.updateBlog(udto);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseDeleteDTO> deleteBlog(@RequestBody @Valid DeleteRequestDTO ddto) {
		return blogservice.deleteBlog(ddto);
	}
}
