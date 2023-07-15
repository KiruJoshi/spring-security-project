package com.example.springsecurity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SpringSecurity1Application  {


	
	public static void main(String[] args) {
		SpringApplication.run(SpringSecurity1Application.class, args);
		System.out.println("Programe started...");
	}

}
