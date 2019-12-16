package com.iotsaulo.springbootmongodb.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iotsaulo.springbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	List<Post> findByTitleContainingIgnoreCase (String text);

}
