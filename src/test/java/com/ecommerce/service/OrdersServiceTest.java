package com.ecommerce.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Date;
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

import com.ecommerce.dto.OrdersData;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Product;
import com.ecommerce.entity.Users;

@ExtendWith(MockitoExtension.class)
public class OrdersServiceTest {

	private OrdersService service;
	private OrdersData order;
	List<OrderItem> items = new ArrayList<>();
	List<OrdersData> ordersList = new ArrayList<>();

	@BeforeEach
	public void setup() {
		service = Mockito.mock(OrdersService.class);
		order = Mockito.mock(OrdersData.class);
		OrderItem item = new OrderItem(new Product(103L, "Watch", "Wearable", 2999.0, "Image_Url",100), 2);
		items.add(item);
		order.setUsers(new Users(201L, "MadhavTengetol", "Madhav@gmail.com", "987654321","Passwod"));
		order.setItemList(items);
		order.setOrderDate(new Date());
		ordersList = service.findAll();
	}

	@DisplayName("Create Order Test")
	@Test
	public void givenObject_whenCreateCalled_thenReturnsNotNull() {
		when(service.create(order)).thenReturn(order);
		Assertions.assertEquals(order, service.create(order));
	}

	@DisplayName("Find All Test")
	@Test
	public void testFindAll() {
		when(service.findAll()).thenReturn(ordersList);
		Assertions.assertEquals(ordersList, service.findAll());
	}

	@DisplayName("Find By Id Test")
	@Test
	public void testFindById() {
		when(service.findById(500L)).thenReturn(order);
		Assertions.assertEquals(order, service.findById(500L));
	}

	@Disabled
	@DisplayName("Update Orders Test")
	@Test
	public void testUpdateProduct() {
		OrderItem item = new OrderItem(new Product(104L, "Mobile", "Electronics", 9999.0, "Image_Url",100), 1);
		items.add(item);
		order.setUsers(new Users(201L, "MadhavTengetol", "Madhav@gmail.com", "987654321","Password"));
		order.setItemList(items);
		order.setOrderDate(new Date());
		when(service.update(order)).thenReturn(order);
		Assertions.assertEquals(order, service.update(order));
	}

	@DisplayName("Delete Order Test")
	@Test
	public void testDeleteProduct() {

		when(service.delete(107L)).thenReturn(true);
		Assertions.assertTrue(service.delete(107L));
	}

	@AfterEach()
	public void afterEach() {
		order = null;
		service = null;
	}

}
