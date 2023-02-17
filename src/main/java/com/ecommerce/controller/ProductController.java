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

import com.ecommerce.dto.ProductData;
import com.ecommerce.security.Authorize;
import com.ecommerce.service.ProductService;
import com.ecommerce.utils.ProductNotFoundException;

@RestController
@RequestMapping("/products")
public class ProductController {

	private ProductService service;

	@Autowired
	public ProductController(ProductService service) {
		super();
		this.service = service;

	}

	@PostMapping
	public ResponseEntity<ProductData> createProduct(@Valid @RequestBody ProductData data) {
		ProductData product = service.create(data);
		return new ResponseEntity<>(product, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<ProductData>> getProducts() {
		return ResponseEntity.ok(service.findAll());

	}

	@GetMapping("/{id}")
	public ResponseEntity<ProductData> getProductById(@PathVariable Long id) throws ProductNotFoundException {
		ProductData data = service.findById(id);
		if (data == null)
			throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found With id : " + id);
		return ResponseEntity.ok(data);
	}

	@PutMapping
	public ResponseEntity<ProductData> updateProduct(@Valid @RequestBody ProductData data) {
		return ResponseEntity.ok(service.update(data));
	}

	@DeleteMapping("/{id}")
	@Authorize
	public ResponseEntity<String> deleteProduct(@PathVariable Long id) throws ProductNotFoundException {

		boolean result = service.delete(id);
		if (!result)
			throw new ProductNotFoundException(HttpStatus.NOT_FOUND, "Product Not Found with id : " + id);
		return new ResponseEntity<>("Product Deleted With Id : " + id, HttpStatus.OK);
	}

}
