package com.ecommerce.service;

import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.dto.UsersData;

@ExtendWith(MockitoExtension.class)
public class UsersServiceTest {

	private UsersService service;

	private UsersData user;
	private List<UsersData> dataList;

	@BeforeEach()
	public void beforeEach() {
		service = Mockito.mock(UsersService.class);
		user = Mockito.mock(UsersData.class);
		user.setUserName("User1");
		user.setEmail("test@gmail.com");
		user.setPhone("9876543210");
		user.setPassword("password");
		dataList = service.findAll();
	}

	@DisplayName("Find All Test")
	@Test
	public void testFindAll() {
		when(service.findAll()).thenReturn(dataList);
		Assertions.assertEquals(dataList, service.findAll());
	}

	@DisplayName("Find By Id Test")
	@Test
	public void testFindById() {
		when(service.findById(107L)).thenReturn(user);
		Assertions.assertEquals(user, service.findById(107L));
	}

	@Disabled
	@DisplayName("Create User Test")
	@Test
	public void testCreateUser() {
		user.setUserId(null);
		user.setUserName("MadhavTengetol");
		user.setEmail("tengetolmadhav@gmail.com");
		when(service.create(user)).thenReturn(user);
		Assertions.assertEquals(user, service.create(user));
	}

	@Disabled
	@DisplayName("Update User Test")
	@Test
	public void testUpdateUser() {
		user.setUserId(107L);
		user.setUserName("MadhavTengetol");
		user.setEmail("tengetolmadhav@gmail.com");
		when(service.update(user)).thenReturn(user);
		Assertions.assertEquals(user, service.update(user));
	}

	@DisplayName("Delete User Test")
	@Test
	public void testDeleteUser() {

		when(service.delete(107L)).thenReturn(true);
		Assertions.assertTrue(service.delete(107L));
	}

	@AfterEach()
	public void afterEach() {
		service = null;
		user = null;
	}
}
