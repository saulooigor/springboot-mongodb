package com.iotsaulo.springbootmongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iotsaulo.springbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
