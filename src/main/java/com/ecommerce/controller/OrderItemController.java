package com.ecommerce.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.dto.OrderItemData;
import com.ecommerce.service.OrderItemService;
import com.ecommerce.utils.OrderItemNotFoundException;

@RestController
@RequestMapping("/orderitems")
public class OrderItemController {

	private OrderItemService service;

	@Autowired
	public OrderItemController(OrderItemService service) {
		super();
		this.service = service;
	}

	@PostMapping()
	@ResponseStatus(code = HttpStatus.CREATED)
	public OrderItemData create(@RequestBody OrderItemData data) {
		return service.create(data);
	}

	@GetMapping()
	public List<OrderItemData> getAll() {
		List<OrderItemData> itemList = service.findAll();
		return itemList;
	}

	@GetMapping("/{id}")
	public OrderItemData getById(@PathVariable Long id) throws OrderItemNotFoundException {
		OrderItemData item = service.findById(id);
		if (item == null)
			throw new OrderItemNotFoundException("Order Item not found for id : " + id);
		return item;
	}

	@PutMapping()
	public OrderItemData updateOrderItem(@RequestBody OrderItemData data) {
		return service.create(data);
	}

	@DeleteMapping("{id}")
	public boolean deleteItem(@PathVariable Long id) {
		return service.delete(id);
	}
}
