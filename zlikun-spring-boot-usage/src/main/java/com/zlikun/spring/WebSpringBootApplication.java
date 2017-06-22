package com.zlikun.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class WebSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringBootApplication.class, args);
	}

	@RequestMapping("/")
	public Object index() {

		return "spring boot web service ." ;

	}

}
