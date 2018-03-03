package com.ecommerce.sw2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class Sw2Application {

	@RequestMapping("/home")
	public String HelloWorld()
	{
		return "Hello World";
	}

	@RequestMapping("/home/{num1}/{num2}")
	public int sum(@PathVariable int num1 , @PathVariable int num2)
	{
		return num1 + num2;
	}

	public static void main(String[] args) {
		SpringApplication.run(Sw2Application.class, args);
	}
}

