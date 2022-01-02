package com.cs393.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(version = "1.0",
				   title = "Stack Overflow API",
				   description = "All Administration Operations" ))
public class Cs393Application {
	public static void main(String[] args) {
		SpringApplication.run(Cs393Application.class, args);
	}
}
