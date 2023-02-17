package com.ecommerce.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.OrderItem;

@Repository
public interface IOrderItemRepository extends JpaRepository<OrderItem, Long>{

}
