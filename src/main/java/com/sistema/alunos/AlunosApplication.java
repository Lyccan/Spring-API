package com.sistema.alunos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class AlunosApplication {

	Dotenv dotenv = Dotenv.load();



	public static void main(String[] args) {
		SpringApplication.run(AlunosApplication.class, args);
	}

}