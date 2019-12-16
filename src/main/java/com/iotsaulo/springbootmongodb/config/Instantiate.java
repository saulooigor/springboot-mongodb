package com.iotsaulo.springbootmongodb.config;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.TimeZone;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.iotsaulo.springbootmongodb.domain.Post;
import com.iotsaulo.springbootmongodb.domain.User;
import com.iotsaulo.springbootmongodb.dto.AuthorDTO;
import com.iotsaulo.springbootmongodb.repository.PostRepository;
import com.iotsaulo.springbootmongodb.repository.UserRepository;

@Configuration
public class Instantiate implements CommandLineRunner {
	
	@Autowired
	private UserRepository repoUser;
	
	@Autowired
	private PostRepository repoPost;

	@Override
	public void run(String... args) throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		sdf.setTimeZone(TimeZone.getTimeZone("GMT"));
		repoUser.deleteAll();
		repoPost.deleteAll();
		
		User maria = new User(null, "Maria Brown", "maria@gmail.com");
		User alex = new User(null, "Alex Green", "alex@gmail.com");
		User bob = new User(null, "Bob Grey", "bob@gmail.com");
		
		repoUser.saveAll(Arrays.asList(maria, alex, bob));
		
		Post post1 = new Post(null, sdf.parse("21/03/2018"), "Partiu Viagem", "Vou viajar para São Paulo! Abraços!", new AuthorDTO(maria));
		Post post2 = new Post(null, sdf.parse("23/03/2018"), "Bom dia", "Acordei feliz hoje!", new AuthorDTO(maria));
		
		repoPost.saveAll(Arrays.asList(post1, post2));
	}

}
