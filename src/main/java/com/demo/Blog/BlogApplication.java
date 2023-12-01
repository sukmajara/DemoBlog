package com.demo.Blog;

import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.Blog.domain.User;
import com.demo.Blog.domain.Role;
import com.demo.Blog.repository.RoleRepository;
import com.demo.Blog.repository.UserRepository;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	
	@Bean
	CommandLineRunner run(RoleRepository roleRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
		return args->{
			if(roleRepository.findByAuthority("ADMIN").isPresent()) {
				return;
			}
			
			Role adminrole = roleRepository.save(new Role("ADMIN"));
			roleRepository.save(new Role("USER"));
			
			Set<Role> roles = new HashSet<>();
			roles.add(adminrole);
			
			User admin = new User(1, "admin", passwordEncoder.encode("admin"), roles);
			userRepository.save(admin);
		};
	}

}
