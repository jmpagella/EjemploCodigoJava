package com.springboot.app.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.springboot.app.users.models.User;

public interface UserRepository extends CrudRepository<User, Long>{
	
}
