package com.springboot.app.users.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.springboot.app.users.models.User;
import com.springboot.app.users.repository.UserRepository;

@Service
public class UserService implements IUserService {

	@Autowired
    private UserRepository userRepository;

	@Transactional(readOnly = true)
    public List<User> findAll() {
		return (List<User>) userRepository.findAll();
    }

	@Transactional(readOnly = true)
	public User findById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Transactional
	public User save(User user) {
		return userRepository.save(user);
	}
	
	@Transactional
    public void deleteById(Long userId) {
        userRepository.deleteById(userId);
    }
    
}
