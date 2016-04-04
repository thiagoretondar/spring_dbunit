package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.test.context.web.WebAppConfiguration;

@SpringBootApplication
@WebAppConfiguration
public class SpringDbunitApplicationTest {

	public static void main(String[] args) {
		SpringApplication.run(SpringDbunitApplicationTest.class, args);
	}
}
