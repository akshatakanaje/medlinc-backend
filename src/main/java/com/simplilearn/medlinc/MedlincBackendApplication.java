package com.simplilearn.medlinc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
@ComponentScan("com.simplilearn.medlinc")
public class MedlincBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedlincBackendApplication.class, args);
	}

}
