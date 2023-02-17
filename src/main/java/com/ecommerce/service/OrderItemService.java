package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.OrderItemData;
import com.ecommerce.entity.OrderItem;
import com.ecommerce.repository.IOrderItemRepository;

@Service
public class OrderItemService implements IOrderItemServices {

	private IOrderItemRepository repository;

	@Autowired
	public OrderItemService(IOrderItemRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<OrderItemData> findAll() {
		List<OrderItemData> dataList = new ArrayList<>();
		List<OrderItem> itemList = repository.findAll();
		itemList.forEach(item -> {
			dataList.add(getItemData(item));
		});
		return dataList;
	}

	@Override
	public OrderItemData findById(Long id) {
		Optional<OrderItem> item = repository.findById(id);
		if (item.isPresent()) {
			return getItemData(item.get());
//		}else {
//			throw new EntityNotFoundException("OrderItem not found for Id :"+id);
//		}
		}
		return null;

	}

	@Override
	public OrderItemData create(OrderItemData data) {
		OrderItem item = getItemEntity(data);

		return getItemData(repository.save(item));
	}

	@Override
	public boolean delete(Long id) {
		boolean result = findAll().remove(findById(id));
		repository.deleteById(id);
		return result;

	}

	@Override
	public OrderItemData update(OrderItemData data) {

		return create(data);
	}

	private OrderItem getItemEntity(OrderItemData data) {
		OrderItem item = new OrderItem(data.getItemId(), data.getProduct(), data.getQuantity());
		return item;
	}

	private OrderItemData getItemData(OrderItem item) {
		OrderItemData itemData = new OrderItemData(item.getItemId(), item.getProduct(), item.getQuantity());
		return itemData;
	}

}
