package com.mm.pas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mm.pas.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	User findByUserIdAndPassword(String userId, String password);
	
	

}
