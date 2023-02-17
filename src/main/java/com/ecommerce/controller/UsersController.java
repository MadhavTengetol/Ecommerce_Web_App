package com.ecommerce.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.UsersData;
import com.ecommerce.service.UsersService;
import com.ecommerce.utils.UserNotFoundException;

@RestController
@RequestMapping("/users")

public class UsersController {

	private UsersService service;

	@Autowired
	public UsersController(UsersService service) {
		super();
		this.service = service;
	}

	@PostMapping
	public ResponseEntity<UsersData> createUser(@Valid @RequestBody UsersData data) {
		return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<UsersData>> getUsers() {
		return ResponseEntity.ok(service.findAll());
	}

	@GetMapping("/{id}")
	public ResponseEntity<UsersData> getUserById(@PathVariable Long id) throws UserNotFoundException {
		UsersData user = service.findById(id);
		if (user == null)
			throw new UserNotFoundException("User Not Found With id: " + id);
		return ResponseEntity.ok(user);
	}

	@GetMapping("/email/{email}")
	public ResponseEntity<UsersData> getUserByEmail(@PathVariable String email) throws UserNotFoundException {
		UsersData user = service.getByEmail(email);
		if (user == null)
			throw new UserNotFoundException("User Not Found With email: " + email);
		return ResponseEntity.ok(user);
	}

	@PutMapping
	public ResponseEntity<UsersData> updateUser(@Valid @RequestBody UsersData data) {
		return ResponseEntity.ok(service.update(data));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteUser(@PathVariable Long id) {
		boolean result = service.delete(id);
		if (result)
			return ResponseEntity.ok("User Deleted with id : " + id);
		else
			return new ResponseEntity<>("User Not Found ", HttpStatus.NOT_FOUND);
	}

}
