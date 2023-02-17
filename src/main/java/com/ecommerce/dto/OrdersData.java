package com.ecommerce.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ecommerce.entity.OrderItem;
import com.ecommerce.entity.Users;

@Component
public class OrdersData {

	private Long orderId;

	@NotNull(message = "User should not be null")
	private Users users;

	@NotNull(message = "Orders item should not be null")
	private List<OrderItem> itemList;

	@NotNull(message = "Date should not be null")
	private Date orderDate;

	private double orderTotal;

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public List<OrderItem> getItemList() {
		return itemList;
	}

	public void setItemList(List<OrderItem> itemList) {
		this.itemList = itemList;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {

		for (OrderItem item : itemList) {
			this.orderTotal += item.getTotalPrice();
		}
		return this.orderTotal;
	}

	public void setOrderTotal(double total) {
		this.orderTotal = total;
	}

	@Override
	public String toString() {
		return "OrdersData [orderId=" + orderId + ", users=" + users + ", itemList=" + itemList + ", orderDate="
				+ orderDate + "]";
	}

}
