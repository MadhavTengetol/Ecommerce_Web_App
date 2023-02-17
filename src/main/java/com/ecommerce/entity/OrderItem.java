package com.ecommerce.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "orderitem")
public class OrderItem {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "orderitem_seq")
	@Column(name = "itemid")
	private Long itemId;
	@OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
	private Product product;
	@Column(name = "quantity")
	private int quantity;
	@Transient
	@Column(name = "unitprice")
	private double unitPrice;

	public OrderItem() {
		super();

	}

	public OrderItem(Product product, int quantity) {
		super();
		this.product = product;
		this.quantity = quantity;
	}

	public OrderItem(Long itemId, Product product, int quantity) {
		super();
		this.itemId = itemId;
		this.product = product;
		this.quantity = quantity;
	}

	public Long getItemId() {
		return itemId;
	}

	public void setItemId(Long itemId) {
		this.itemId = itemId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = product.getUnitPrice();
	}

	public double getTotalPrice() {
		return this.quantity * this.unitPrice;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((itemId == null) ? 0 : itemId.hashCode());
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
		OrderItem other = (OrderItem) obj;
		if (itemId == null) {
			if (other.itemId != null)
				return false;
		} else if (!itemId.equals(other.itemId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "OrderItem [itemId=" + itemId + ", product=" + product + ", quantity=" + quantity + ", unitPrice="
				+ unitPrice + "]";
	}

}
