package com.iotsaulo.springbootmongodb.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.iotsaulo.springbootmongodb.domain.User;
import com.iotsaulo.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiate implements CommandLineRunner {
	
	@Autowired
	private UserRepository repoUser;

	@Override
	public void run(String... args) throws Exception {
		
		repoUser.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repoUser.saveAll(Arrays.asList(maria, alex, bob));
	}

}
