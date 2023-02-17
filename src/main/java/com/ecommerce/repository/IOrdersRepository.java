package com.ecommerce.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Orders;
import com.ecommerce.entity.Users;

@Repository
public interface IOrdersRepository extends JpaRepository<Orders, Long> {


	@Transactional
	@Query("select o from Orders o where o.users = ?1")
	List<Orders> getOrderByUserId(Users user);
}
