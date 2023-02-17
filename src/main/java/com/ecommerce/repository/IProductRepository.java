package com.ecommerce.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Product;

@Repository
public interface IProductRepository extends JpaRepository<Product, Long> {

	@Modifying
	@Transactional
	@Query("update Product p set p.stock =?1 where p.productId =?2")
	void updateQuantity(int quantity,Long productId);
}
