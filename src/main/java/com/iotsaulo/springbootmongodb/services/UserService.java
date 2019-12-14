package com.iotsaulo.springbootmongodb.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iotsaulo.springbootmongodb.domain.User;
import com.iotsaulo.springbootmongodb.dto.UserDTO;
import com.iotsaulo.springbootmongodb.repository.UserRepository;
import com.iotsaulo.springbootmongodb.services.exceptions.ObjectNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	public User findById(String id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
	}
	
	public User insert(User obj) {
		return repository.insert(obj);
	}
	
	public User fromDTO (UserDTO dto) {
		User user = new User(dto.getId(), dto.getName(), dto.getEmail());
		return user;
	}

}
