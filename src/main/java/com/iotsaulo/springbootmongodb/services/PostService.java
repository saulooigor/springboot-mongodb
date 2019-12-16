package com.iotsaulo.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotsaulo.springbootmongodb.domain.Post;
import com.iotsaulo.springbootmongodb.repository.PostRepository;
import com.iotsaulo.springbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class PostService {

	@Autowired
	private PostRepository repository;

	public Post findById(String id) {
		Optional<Post> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public List<Post> findByTitle (String text){
		return repository.findByTitleContainingIgnoreCase(text);
	}

}
