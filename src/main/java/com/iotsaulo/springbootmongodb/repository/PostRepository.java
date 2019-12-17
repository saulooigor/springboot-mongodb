package com.iotsaulo.springbootmongodb.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.iotsaulo.springbootmongodb.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

	@Query("{'title': { $regex: ?0, $options: 'i' }}")
	List<Post> findByTitle(String text);

	List<Post> findByTitleContainingIgnoreCase(String text);

	@Query("{ $and: [ { 'data': {$gte: ?1} }, { 'data': { $lte: ?2} } , { $or: [ { 'title': { $regex: ?0, $options: 'i' } }, { 'body': { $regex: ?0, $options: 'i' } }, { 'comments.text': { $regex: ?0, $options: 'i' } } ] } ] }")
	List<Post> fullSearch(String text, Date minDate, Date maxDate);

}
