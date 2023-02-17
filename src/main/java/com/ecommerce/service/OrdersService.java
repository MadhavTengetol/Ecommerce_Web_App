package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrdersData;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Users;
import com.ecommerce.repository.IOrdersRepository;
import com.ecommerce.repository.IProductRepository;
import com.ecommerce.repository.IUserRepository;

@Service
public class OrdersService implements IOrdersService {

	private IOrdersRepository repository;
	private IProductRepository productRepository;
	private IUserRepository userRepository;

	@Autowired
	public OrdersService(IOrdersRepository repository, IProductRepository productRepository,
			IUserRepository userRepository) {
		super();
		this.repository = repository;
		this.productRepository = productRepository;
		this.userRepository = userRepository;
	}

	@Override
	public List<OrdersData> findAll() {
		List<OrdersData> orderData = new ArrayList<>();
		List<Orders> orderList = repository.findAll();
		orderList.forEach(order -> {
			orderData.add(getOrdersData(order));
		});

		return orderData;
	}

	@Override
	public OrdersData findById(Long id) {
		Optional<Orders> order = repository.findById(id);
		if (order.isPresent()) {
			return getOrdersData(order.get());

		} else {
			return null;
		}
	}

	@Override
	public OrdersData create(OrdersData data) {
		Orders order = getOrdersEntity(data);
		OrdersData createdOrder = getOrdersData(repository.save(order));
		List<OrderItem> items = data.getItemList();
		for (OrderItem item : items) {
			int inStock = productRepository.findById(item.getProduct().getProductId()).get().getStock();
			inStock -= item.getQuantity();
			productRepository.updateQuantity(inStock, item.getProduct().getProductId());
		}
		return createdOrder;
	}

	@Override
	public boolean delete(Long id) {
		Orders order = getOrdersEntity(findById(id));
		if (order != null) {
			repository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public OrdersData update(OrdersData data) {
		OrdersData order = findById(data.getOrderId());
		List<OrderItem> items = order.getItemList();
		for (int i = 0; i < data.getItemList().size(); i++) {
			if (order.getItemList().get(i).getQuantity() > data.getItemList().get(i).getQuantity()) {
				int inStock = productRepository.findById(order.getItemList().get(i).getProduct().getProductId()).get()
						.getStock();
				inStock += order.getItemList().get(i).getQuantity();
				productRepository.updateQuantity(inStock, data.getItemList().get(i).getProduct().getProductId());
			} else {
				int inStock = productRepository.findById(order.getItemList().get(i).getProduct().getProductId()).get()
						.getStock();
				inStock -= order.getItemList().get(i).getQuantity();
				productRepository.updateQuantity(inStock, data.getItemList().get(i).getProduct().getProductId());
			}

		}
		return create(data);
	}

	public List<OrdersData> findByUserId(Long id) {
		Users user = userRepository.findById(id).get();
		List<Orders> order = repository.getOrderByUserId(user);
		List<OrdersData> userOrders = new ArrayList<>();
		order.forEach(o -> {
			userOrders.add(getOrdersData(o));
		});
		return userOrders;
	}

	private Orders getOrdersEntity(OrdersData data) {
		Orders order = new Orders();
		order.setOrderId(data.getOrderId());
		order.setUsers(data.getUsers());
		order.setItemList(data.getItemList());
		order.setOrderDate(data.getOrderDate());

		return order;
	}

//	Entity=>DTO
	private OrdersData getOrdersData(Orders order) {
		OrdersData data = new OrdersData();
		data.setOrderId(order.getOrderId());
		data.setUsers(order.getUsers());
		data.setItemList(order.getItemList());
		data.setOrderDate(order.getOrderDate());
		return data;
	}

}
