package com.aibou.security;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableMethodSecurity
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}
