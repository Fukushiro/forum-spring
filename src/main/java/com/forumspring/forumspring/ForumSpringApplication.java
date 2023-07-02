package com.forumspring.forumspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ForumSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(ForumSpringApplication.class, args);
	}

	@GetMapping
	public String HelloWorld() {
		return "Hello world";
	}

}
