package com.ecommerce.service;

import java.util.List;

import com.ecommerce.dto.UsersData;

public interface IService<T> {
	List<T> findAll();

	T findById(final Long id);

	T create(T t);

	boolean delete(final Long id);

	T update(T t);

}