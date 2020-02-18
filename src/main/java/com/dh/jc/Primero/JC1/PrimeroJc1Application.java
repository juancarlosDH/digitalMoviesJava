package com.dh.jc.Primero.JC1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("repository")
public class PrimeroJc1Application {

	public static void main(String[] args) {
		SpringApplication.run(PrimeroJc1Application.class, args);
	}

}
