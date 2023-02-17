package com.ecommerce.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.ecommerce.entity.Users;

@Repository
public interface IUserRepository extends JpaRepository<Users, Long> {

//	@Transactional
//	@Modifying
//	@Query("update Users set username =?2, email =?3,phone=?4 where userid =?1")
//	void findAndUpdate(int id,String username,String email,String phone);

	@Transactional
	@Query("Select u from Users u where u.email =?1")
	Users getByEmail(String email);

	@Transactional
	@Query("Select u from Users u where u.userName =?1")
	Users getByUserName(String username);
	
	@Transactional
	@Query("Select u from Users u where u.userName =?1")
	Users existsByUserName(String username);

}
