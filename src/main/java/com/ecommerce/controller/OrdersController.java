package com.ecommerce.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
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
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.auth.TokenAuthentication;
import com.ecommerce.dto.OrdersData;
import com.ecommerce.dto.UsersData;
import com.ecommerce.security.Authorize;
import com.ecommerce.service.OrdersService;
import com.ecommerce.utils.OrderNotFoundException;
import com.ecommerce.utils.UserNotFoundException;

@RestController
@RequestMapping("/orders")
public class OrdersController {

	private OrdersService service;
	private TokenAuthentication auth;

	@Autowired
	public OrdersController(OrdersService service, TokenAuthentication auth) {
		super();
		this.service = service;
		this.auth = auth;
	}

	@PostMapping
	@Authorize
	public ResponseEntity<OrdersData> createOrder(@Valid @RequestBody OrdersData data) {
		return new ResponseEntity<>(service.create(data), HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<List<OrdersData>> getOrders() {
		List<OrdersData> ordersList = service.findAll();
		return ResponseEntity.ok(ordersList);
	}

	@GetMapping("/{id}")
	public ResponseEntity<OrdersData> getById(@PathVariable Long id) throws OrderNotFoundException {
		OrdersData data = service.findById(id);
		if (data == null)
			throw new OrderNotFoundException(HttpStatus.NOT_FOUND, "Order Not Found For id: " + id);
		return ResponseEntity.ok(data);
	}

	@GetMapping("/user/{id}")
	@Authorize
	public ResponseEntity<List<OrdersData>> getOrderByUserId(HttpServletRequest request) throws OrderNotFoundException {
		List<OrdersData> data = new ArrayList<>();
		Long userid = (Long) request.getAttribute("userid");
		data = service.findByUserId(userid);

		if (data == null)
			throw new OrderNotFoundException(HttpStatus.INTERNAL_SERVER_ERROR, "Order Not Found For id: " + userid);
		return ResponseEntity.ok(data);
	}

	@PutMapping
	public ResponseEntity<OrdersData> updateOrder(@RequestBody OrdersData data) {
		return ResponseEntity.ok(service.update(data));
	}

	@DeleteMapping("/{id}")
	@Authorize
	public ResponseEntity<String> deleteOrder(@PathVariable Long id) {
		boolean result = service.delete(id);

		if (result)
			return ResponseEntity.ok("Order Removed");
		else
			return new ResponseEntity<>("Order Not Found", HttpStatus.NOT_FOUND);
	}

}
