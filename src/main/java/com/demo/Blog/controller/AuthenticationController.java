package com.demo.Blog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.Blog.DTO.LoginRequestDTO;
import com.demo.Blog.DTO.RegisterUserDTO;
import com.demo.Blog.DTO.ResponseLoginDTO;
import com.demo.Blog.DTO.ResponseRegisterDTO;
import com.demo.Blog.serviceImpl.AuthenticationServiceImpl;

@RestController
@RequestMapping("/auth")
@CrossOrigin("*")
public class AuthenticationController {

	@Autowired
	private AuthenticationServiceImpl authenticationService;

	@PostMapping("/register")
	public ResponseRegisterDTO registerUser(@RequestBody RegisterUserDTO registerUser) {
		return authenticationService.registerUser(registerUser);
	}
	@PostMapping("/login")
	public ResponseLoginDTO loginUser(@RequestBody LoginRequestDTO loginRequest) {
		return authenticationService.loginUser(loginRequest);
	}
	
}
