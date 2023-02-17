package com.ecommerce.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "product_seq")
	@Column(name = "productid")
	private Long productId;
	@Column(name = "productname")
	private String productName;
	@Column(name = "category")
	private String category;
	@Column(name = "unitprice")
	private double unitPrice;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "stock")
	private int stock;

	public Product() {
		super();
	}

	public Product(String productName, String category, double unitPrice, String imageUrl, int stock) {
		super();
		this.productName = productName;
		this.category = category;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.stock = stock;
	}

	public Product(Long productId, String productName, String category, double unitPrice, String imageUrl, int stock) {
		super();
		this.productId = productId;
		this.productName = productName;
		this.category = category;
		this.unitPrice = unitPrice;
		this.imageUrl = imageUrl;
		this.stock = stock;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((productId == null) ? 0 : productId.hashCode());
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
		Product other = (Product) obj;
		if (productId == null) {
			if (other.productId != null)
				return false;
		} else if (!productId.equals(other.productId))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", productName=" + productName + ", category=" + category
				+ ", unitPrice=" + unitPrice + ", imageUrl=" + imageUrl + "Stock: "+stock+"]";
	}

}
