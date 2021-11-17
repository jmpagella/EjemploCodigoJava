package com.springboot.app.users.service;

import java.util.List;
import com.springboot.app.users.models.User;

public interface IUserService {

	public List<User> findAll();

	public User findById(Long id);
	
	public User save(User user);
	
	public void deleteById(Long id);
	
}
