package com.springboot.app.users.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.app.users.models.User;
import com.springboot.app.users.service.IUserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {
	
	@Autowired
	private IUserService userService;
	
	@GetMapping("")
	public List<User> allUsers(){
		return userService.findAll();
	}
	
	@GetMapping("/{id}")
	public User findById(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@PostMapping("")
	public User create(@RequestBody User user) {
		return userService.save(user);
	}
	
	@DeleteMapping("/{id}")
	public void delete(@PathVariable Long id) {
		userService.deleteById(id);
	}
	
}
