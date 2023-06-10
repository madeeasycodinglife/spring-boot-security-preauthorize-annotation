package com.madeeasy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

	@GetMapping("/user")
	@PreAuthorize("hasRole('USER')")
	public String user(){
		return "user";
	}
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String admin(){
		return "admin";
	}
	@GetMapping("/")
	@PreAuthorize("permitAll()")
	public String forAll(){
		return "Welcome to Spring Boot";
	}


}
