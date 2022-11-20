package com.example.pailab5;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication()
@EnableJpaRepositories
public class PaiLab5Application {

	public static void main(String[] args) {
		SpringApplication.run(PaiLab5Application.class, args);
	}
}
