package com.ecommerce.entity;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "orders")
public class Orders {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orders_seq")
	@Column(name = "orderid")
	private Long orderId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Users users;
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<OrderItem> itemList;
	@Temporal(TemporalType.DATE)
	@Column(name = "orderdate")
	private Date orderDate;

	public Orders() {
		super();

	}

	public Orders(Users users, List<OrderItem> itemList, Date orderDate) {
		super();
		this.users = users;
		this.itemList = itemList;
		this.orderDate = orderDate;
	}

	public Orders(Long orderId, Users users, List<OrderItem> itemList, Date orderDate) {
		super();
		this.orderId = orderId;
		this.users = users;
		this.itemList = itemList;
		this.orderDate = orderDate;
	}

	public double getOrderTotal() {
		double orderTotal = 0;
		for (OrderItem item : itemList) {
			orderTotal += item.getTotalPrice();
		}
		return orderTotal;
	}

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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((orderId == null) ? 0 : orderId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (orderId == null) {
			if (other.orderId != null)
				return false;
		} else if (!orderId.equals(other.orderId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [orderId=" + orderId + ", users=" + users + ", itemList=" + itemList + ", orderDate=" + orderDate
				+ "]";
	}

}
