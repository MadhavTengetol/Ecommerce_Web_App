package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.UsersData;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Users;
import com.ecommerce.repository.IUserRepository;

@Service
public class UsersService implements IUserServices {

	private IUserRepository repository;

	@Autowired
	public UsersService(IUserRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<UsersData> findAll() {
		List<UsersData> usersDataList = new ArrayList<>();
		List<Users> users = repository.findAll();
		users.forEach(user -> {
			usersDataList.add(getUsersData(user));
		});
		return usersDataList;
	}

	@Override
	public UsersData findById(Long id) {
		Optional<Users> user = repository.findById(id);
		if (user.isPresent()) {
//			throw new EntityNotFoundException("User Not Found with Id: " + id);
			return getUsersData(user.get());
		}
		return null;
	}

	@Override
	public UsersData create(UsersData data) {
		Users user = getUsersEntity(data);
		return getUsersData(repository.save(user));
	}

	@Override
	public boolean delete(final Long id) {
		Users user = getUsersEntity(findById(id));
		if (user != null) {
			repository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public UsersData update(UsersData data) {

		return create(data);
	}

	public UsersData getByEmail(String email) {
		Users user = repository.getByEmail(email);
		return getUsersData(user);
	}

	public UsersData getByUserName(String username) {
		Users user = repository.getByUserName(username);
		return getUsersData(user);
	}

	public boolean existsUsersname(String username) {
		Users user = repository.existsByUserName(username);
		if (user != null)
			return true;
		return false;
	}

//	DTO=>Entity
	private Users getUsersEntity(UsersData data) {
		Users user = new Users();
		user.setUserId(data.getUserId());
		user.setUserName(data.getUserName());
		user.setEmail(data.getEmail());
		user.setPhone(data.getPhone());
		user.setPassword(data.getPassword());

		return user;
	}

//	Entity=>DTO
	private UsersData getUsersData(Users user) {
		UsersData usersData = new UsersData();
		usersData.setUserId(user.getUserId());
		usersData.setUserName(user.getUserName());
		usersData.setEmail(user.getEmail());
		usersData.setPhone(user.getPhone());
		usersData.setPassword(user.getPassword());

		return usersData;
	}

}
