package com.ecommerce.dto;

import javax.validation.constraints.NotBlank;

import org.springframework.stereotype.Component;

@Component
public class ProductData {
	private Long productId;

	@NotBlank(message = "Product Name Should Not be Null")
	private String productName;
	@NotBlank(message = "Product category Should Not be Null")
	private String category;
	private double unitPrice;
	@NotBlank(message = "Product Image Url Should Not be Null")
	private String imageUrl;
	private int stock;

	public ProductData() {
		super();

	}

	public ProductData(Long productId, String productName, String category, double unitPrice, String imageUrl) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.unitPrice = unitPrice;
		this.category = category;
		this.imageUrl = imageUrl;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "ProductData [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", imageUrl=" + imageUrl + "]";
	}

}
