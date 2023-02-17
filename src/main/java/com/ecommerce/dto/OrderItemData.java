package com.ecommerce.dto;

import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Component;

import com.ecommerce.entity.Product;

@Component
public class OrderItemData {
	private Long itemId;

	private Product product;
	@NotNull(message = "Quantity should not be null")
	private int quantity;
	@NotNull(message = "Price should not be null")
	private double unitPrice;

	public OrderItemData() {
		super();
	}

	public OrderItemData(Long itemId, Product product, int quantity) {
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
		this.unitPrice = unitPrice;
	}
}
