package com.iotsaulo.springbootmongodb.resources;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iotsaulo.springbootmongodb.domain.User;
import com.iotsaulo.springbootmongodb.dto.UserDTO;
import com.iotsaulo.springbootmongodb.services.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserResource {

	@Autowired
	private UserService service;

	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<UserDTO>> findAll() {
		List<User> users = service.findAll();
		List<UserDTO> listDTO = users.stream().map(x -> new UserDTO(x)).collect(Collectors.toList());
		return ResponseEntity.ok().body(listDTO);

	}

	@RequestMapping(value = "{/id}", method = RequestMethod.GET)
	public ResponseEntity<UserDTO> findById(@PathVariable String id) {
		UserDTO dto = new UserDTO(service.findById(id));
		return ResponseEntity.ok().body(dto);
	}

	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody UserDTO obj) {
		User u = service.fromDTO(obj);
		u = service.insert(u);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(u.getId()).toUri();
		return ResponseEntity.created(uri).build();

	}
	
	@RequestMapping(value = "{/id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> delete(String id){
		service.delete(id);
		return ResponseEntity.noContent().build();
		
	}
}
