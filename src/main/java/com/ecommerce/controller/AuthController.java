package com.ecommerce.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.auth.TokenAuthentication;
import com.ecommerce.dto.UserLoginRequest;
import com.ecommerce.dto.UserLoginResponse;
import com.ecommerce.dto.UsersData;
import com.ecommerce.service.UsersService;
import com.ecommerce.utils.UserNotFoundException;

@RestController
@RequestMapping("/auth")
public class AuthController {

	private TokenAuthentication tokenAuthentication;
	private UsersService usersService;
	private BCryptPasswordEncoder passwordEncoder;

	@Autowired
	private AuthController(TokenAuthentication tokenAuthentication, UsersService usersService,
			BCryptPasswordEncoder passwordEncoder) {
		super();
		this.tokenAuthentication = tokenAuthentication;
		this.usersService = usersService;
		this.passwordEncoder = passwordEncoder;
	}

	@PostMapping({ "/login", "/signin" })
	public ResponseEntity<UserLoginResponse> authorizeUser(@Valid @RequestBody UserLoginRequest data)
			throws UserNotFoundException {
		String email = data.getEmail();

		UserLoginResponse user = getUserLoginResponse(usersService.getByEmail(email));
		if (passwordEncoder.matches(data.getPassword(), user.getPassword())) {
			final String token = tokenAuthentication.createToken(user);
			user.setToken(token);
			return ResponseEntity.ok(user);
		}

		else
			throw new UserNotFoundException("Password is wrong");
	}

	@PostMapping({ "/register", "/signup" })
	public ResponseEntity<UsersData> registerUser(@Valid @RequestBody UsersData data) {
		if (usersService.existsUsersname(data.getUserName())) {
			throw new RuntimeException("Username Already Exists");
		} else {
			data.setPassword(passwordEncoder.encode(data.getPassword()));
			UsersData registeredUser = usersService.create(data);
			return ResponseEntity.ok(registeredUser);
		}
	}

	@PutMapping("/changepass/{id}")
	public ResponseEntity<UsersData> changePassword(@PathVariable Long id, @RequestBody UsersData data) {
		data.setUserId(id);
		UsersData updatedUser = usersService.create(data);
		return ResponseEntity.ok(updatedUser);
	}

	private UserLoginResponse getUserLoginResponse(UsersData data) {
		UserLoginResponse response = new UserLoginResponse();

		response.setUserId(data.getUserId());
		response.setUserName(data.getUserName());
		response.setEmail(data.getEmail());
		response.setPhone(data.getPhone());
		response.setPassword(data.getPassword());

		return response;
	}

}
