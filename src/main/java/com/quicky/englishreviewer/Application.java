package com.quicky.englishreviewer;

import com.quicky.englishreviewer.security.model.User;
import com.quicky.englishreviewer.security.repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Date;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(UserRepository users , PasswordEncoder encoder) {
		return args -> {

			users.save(new User("abc", encoder.encode("abc"), "ROLE_USER"));
			users.save(new User("def", encoder.encode("def"), "ROLE_USER,ROLE_ADMIN"));
		};
	}
}
