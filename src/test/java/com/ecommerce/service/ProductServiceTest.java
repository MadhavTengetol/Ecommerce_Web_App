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

import com.ecommerce.dto.ProductData;

@ExtendWith(MockitoExtension.class)
public class ProductServiceTest {

	private ProductService service;
	private ProductData productData;
	private List<ProductData> dataList;

	@BeforeEach()
	public void setup() {
		service = Mockito.mock(ProductService.class);
		productData = Mockito.mock(ProductData.class);
		productData.setProductId(107L);
		productData.setProductName("Product 1");
		productData.setUnitPrice(2999.0);
		productData.setCategory("Electronic");
		productData.setImageUrl("Image_Link");
		

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
		when(service.findById(107L)).thenReturn(productData);
		Assertions.assertEquals(productData, service.findById(107L));
	}

	@Disabled
	@DisplayName("Create Product Test")
	@Test
	public void testCreateProduct() {
		productData.setProductId(null);
		productData.setProductName("Product 7");
		productData.setUnitPrice(299.0);
		when(service.create(productData)).thenReturn(productData);
		Assertions.assertEquals(productData.getProductName(), service.create(productData).getProductName());
	}

	@Disabled
	@DisplayName("Update Product Test")
	@Test
	public void testUpdateProduct() {
		productData.setProductId(107L);
		productData.setProductName("Product 1");
		productData.setUnitPrice(29999.0);
		when(service.update(productData)).thenReturn(productData);
		Assertions.assertEquals(productData.getUnitPrice(), service.update(productData).getUnitPrice());
	}

	@DisplayName("Delete Product Test")
	@Test
	public void testDeleteProduct() {

		when(service.delete(107L)).thenReturn(true);
		Assertions.assertTrue(service.delete(107L));
	}

	@AfterEach
	public void afterEach() {
		service = null;
		productData = null;
	}

}
