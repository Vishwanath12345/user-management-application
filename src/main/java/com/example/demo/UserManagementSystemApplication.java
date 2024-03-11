package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;

@SpringBootApplication
public class UserManagementSystemApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(UserManagementSystemApplication.class, args);
	}
	
	@Autowired
	private UserRepository userRepository;

	@Override
	public void run(String... args) throws Exception {
//		User user1 = new User("Virat" ,"kohali" ,"vir@gmail.com");
//		userRepository.save(user1);
		
	}

}
