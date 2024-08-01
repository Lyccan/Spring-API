package com.sistema.alunos.configuration;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.StandardEnvironment;

@Configuration
public class envConfiguration {
    @Bean
    public Environment environment() {
        Dotenv dotenv = Dotenv.load();
        StandardEnvironment env = new StandardEnvironment();

        dotenv.entries().forEach(entry -> {
            System.setProperty(entry.getKey(), entry.getValue());
        });

        return env;
    }
}
