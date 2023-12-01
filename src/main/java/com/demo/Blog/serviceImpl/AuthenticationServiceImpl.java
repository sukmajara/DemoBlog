package com.demo.Blog.serviceImpl;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.Blog.DTO.LoginRequestDTO;
import com.demo.Blog.DTO.RegisterUserDTO;
import com.demo.Blog.DTO.ResponseLoginDTO;
import com.demo.Blog.DTO.ResponseRegisterDTO;
import com.demo.Blog.domain.Role;
import com.demo.Blog.domain.User;
import com.demo.Blog.repository.RoleRepository;
import com.demo.Blog.repository.UserRepository;
import com.demo.Blog.service.AuthencticationService;

@Service
@Transactional
public class AuthenticationServiceImpl implements AuthencticationService{

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private RoleRepository roleRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Autowired
	private AuthenticationManager authManager;

	@Autowired
	private TokenService tokenService;

	public ResponseRegisterDTO registerUser(RegisterUserDTO userRegister) {
		String encodedPassword = passwordEncoder.encode(userRegister.getPassword());
		try {
			
		Role userRole = roleRepository.findByAuthority("USER").get();

		Set<Role> authorities = new HashSet<>();
		authorities.add(userRole);
		userRepository.save(new User(0, userRegister.getUsername(), encodedPassword, authorities));

		return new ResponseRegisterDTO("Success Create User "+ userRegister.getUsername());
		} catch (Exception e) {
			return new ResponseRegisterDTO("Error Create User ("+ e.getMessage()+")" );
		}
	}

	public ResponseLoginDTO loginUser(LoginRequestDTO loginRequest) {
		try {
			Authentication auth = authManager.authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
			String token = tokenService.generateJwt(auth);
			return new ResponseLoginDTO(loginRequest.getUsername(), token);
		} catch (AuthenticationException e) {
			return new ResponseLoginDTO(null, "");
		}
	}

	

}
