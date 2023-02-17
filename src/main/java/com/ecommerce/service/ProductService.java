package com.ecommerce.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.dto.ProductData;
import com.ecommerce.entity.Product;
import com.ecommerce.repository.IProductRepository;

@Service
public class ProductService implements IProductServices {

	private IProductRepository repository;

	@Autowired
	public ProductService(IProductRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public List<ProductData> findAll() {
		List<ProductData> productDataList = new ArrayList<>();
		List<Product> products = repository.findAll();
		products.forEach(product -> {
			productDataList.add(getProductData(product));
		});
		return productDataList;
	}

	@Override
	public ProductData findById(Long id) {
		Optional<Product> product = repository.findById(id);
		if (product.isPresent()) {
			return getProductData(product.get());

		} else {
			return null;
		}

	}

	@Override
	public ProductData create(ProductData data) {

		Product product = getProductEntity(data);

		return getProductData(repository.save(product));
	}

	@Override
	public boolean delete(Long id) {
		Product product = getProductEntity(findById(id));
		if (product != null) {
			repository.deleteById(id);
			return true;
		}

		return false;
	}

	@Override
	public ProductData update(ProductData data) {

		return create(data);
	}

	private Product getProductEntity(ProductData data) {
		Product product = new Product();
		product.setProductId(data.getProductId());
		product.setProductName(data.getProductName());
		product.setUnitPrice(data.getUnitPrice());
		product.setCategory(data.getCategory());
		product.setImageUrl(data.getImageUrl());
		product.setStock(data.getStock());

		return product;
	}

	private ProductData getProductData(Product product) {
		ProductData productData = new ProductData();
		productData.setProductId(product.getProductId());
		productData.setProductName(product.getProductName());
		productData.setUnitPrice(product.getUnitPrice());
		productData.setCategory(product.getCategory());
		productData.setImageUrl(product.getImageUrl());
		productData.setStock(product.getStock());

		return productData;
	}

}
