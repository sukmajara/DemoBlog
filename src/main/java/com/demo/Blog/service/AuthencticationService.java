package com.demo.Blog.service;

import com.demo.Blog.DTO.LoginRequestDTO;
import com.demo.Blog.DTO.RegisterUserDTO;
import com.demo.Blog.DTO.ResponseLoginDTO;
import com.demo.Blog.DTO.ResponseRegisterDTO;

public interface AuthencticationService {
	public ResponseRegisterDTO registerUser(RegisterUserDTO registerUser);

	public ResponseLoginDTO loginUser(LoginRequestDTO loginRequest);

}
