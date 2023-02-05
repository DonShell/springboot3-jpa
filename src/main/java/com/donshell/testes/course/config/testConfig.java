package com.donshell.testes.course.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.donshell.testes.course.entities.User;
import com.donshell.testes.course.repositories.UserRepository;

@Configuration
@Profile("test")
public class testConfig implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("testeee");

		User u = new User(null,"Maria","maria@gmail.com","992349140","12345");
		User u2 = new User(null,"Alex","alexa@gmail.com","995643540","1256365");
		
		userRepository.saveAll(Arrays.asList(u,u2));
	}
}
