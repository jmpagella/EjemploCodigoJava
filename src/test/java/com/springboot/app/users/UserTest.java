package com.springboot.app.users;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.springboot.app.users.models.User;
import com.springboot.app.users.repository.UserRepository;

@DataJpaTest
class UserTest {

	@Autowired
    private UserRepository userRepository;
	
	@Test
	void testAllUsers() {
		List<User> users = (List<User>) userRepository.findAll();
	    assertThat(users).size().isGreaterThan(0);
	}	

	@Test
	void testFindById() {
		Optional<User> user = userRepository.findById(1L);
		assertThat(user).isNotNull();
	}

	@Test
	void testCreate() {
		User savedUser = userRepository.save(new User("junit@junit.com", "Test from", "JUnit"));
	    assertThat(savedUser.getId()).isGreaterThan(0);
	}

	@Test
	void testDelete() {
		Optional<User> user = userRepository.findById(1L);
		userRepository.deleteById(user.get().getId());
		
		Optional<User> userDeleted = userRepository.findById(1L); 
	    assertThat(userDeleted).isEmpty();  
	}

}
