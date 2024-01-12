package com.rohini.institute.management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rohini.institute.management.model.User;


public interface UserRepository extends JpaRepository<User, String> {
	public User findByUsername(String username);

}
