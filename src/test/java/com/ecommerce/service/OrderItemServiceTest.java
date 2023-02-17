package com.ecommerce.service;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.ecommerce.dto.OrderItemData;
import com.ecommerce.entity.Product;

@ExtendWith(MockitoExtension.class)
public class OrderItemServiceTest {

	private OrderItemService service;

	private OrderItemData item;
	private List<OrderItemData> itemList = new ArrayList<>();;

	@BeforeEach()
	public void beforeEach() {
		item = Mockito.mock(OrderItemData.class);
		service = Mockito.mock(OrderItemService.class);
		item.setProduct(new Product(100L, "Mobile", "Electronics", 9999.0, "ImageUrl",100));
		item.setQuantity(9);
		item.setUnitPrice(9999.0);
		itemList = service.findAll();

	}

	@Disabled
	@Test
	public void findAll_WhenCalled_ReturnsNotNull() {
		when(service.findAll()).thenReturn(itemList);
		Assertions.assertEquals(itemList, service.findAll());
	}

//	@Disabled
	@Test
	public void findById_WhenCalled_ReturnsNotNull() {
		when(service.findById(502L)).thenReturn(item);
		Assertions.assertEquals(item, service.findById(502L));
	}

//	@Disabled
	@Test
	public void create_WhenCalled_ReturnsNotNull() {
		item.setProduct(new Product(100L, "Mobile", "Electronics", 9999.0, "Image_Url",100));
		item.setQuantity(9);
		item.setUnitPrice(9999.0);
		when(service.create(item)).thenReturn(item);
		Assertions.assertEquals(item, service.create(item));
	}

	@Disabled
	@Test
	public void update_WhenCalled_ReturnsNotNull() {
		item.setItemId(400L);
		item.setProduct(new Product(100L, "Mobile", "Electronics", 9999.0, "Image_Url",100));
		item.setQuantity(9);
		item.setUnitPrice(9999.0);
		when(service.update(item)).thenReturn(item);
		Assertions.assertEquals(item, service.update(item));
	}

	@Disabled
	@Test
	public void delete_WhenCalled_ReturnsTrue() {
		when(service.delete(400L)).thenReturn(true);
		Assertions.assertTrue(service.delete(400L));
	}

	@AfterEach()
	public void afterEach() {
		service = null;
		item = null;

	}

}
