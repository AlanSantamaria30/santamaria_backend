package com.example.santamaria.santamaria_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@EntityScan(basePackages = "com.example.santamaria.santamaria_backend.Entity")
@SpringBootApplication
public class SantamariaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(SantamariaBackendApplication.class, args);
	}

}
