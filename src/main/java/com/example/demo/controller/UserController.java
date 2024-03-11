package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;

@Controller
public class UserController {
	 private UserService userService;

	public UserController(UserService userService) {
		super();
		this.userService = userService;
	} 
	
	@GetMapping("/users")
	public String listUsers(Model model) {
		model.addAttribute("users" , userService.getAllUsers());
		return "users";
	}
	
	@GetMapping("/users/new")
	public String createUserForm(Model model) {
		User user = new User();
		model.addAttribute("user" ,user);
		return "create_user";
		
	}
	
	@PostMapping("/users")
	public String saveUser(@ModelAttribute("user") User user) {
		userService.saveUser(user);
		return "redirect:/users";
		
	}
	@GetMapping("/users/edit/{id}")
	 public String editUserForm(@PathVariable Long id , Model model) {
		model.addAttribute("user" ,userService.getUserById(id));
		return "edit_user";
		
	}
	
	@PostMapping("/users/{id}")
	public String updateUser(@PathVariable Long id ,
			@ModelAttribute("user") User user ,Model model) {
		
		//get user from database by id
		User existingUser = userService.getUserById(id);
		existingUser.setId(id);
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		//save the updated user object
		
		userService.updateUser(existingUser);	
		return "redirect:/users";
		
	}
	
	//handler method for deleting user
	@GetMapping("/users/{id}")
	public String deteleUser(@PathVariable Long id) {
		userService.deleteUserById(id);
		return "redirect:/users";
		
	}

}
