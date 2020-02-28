package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserContact;
import com.example.demo.model.Users;
import com.example.demo.repo.UserContactRepository;
import com.example.demo.repo.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserContactRepository userContactRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/")
	public String home()
	{
		return "hello";
	}
	
	@GetMapping("/findAll")
	public List<Users> getUsers()
	{
		return userRepository.findAll();
	}
	
	@PostMapping("/addUser")
	public List<Users> addUser(@RequestBody Users users)
	{
//		Users u = users;
//		UserContact contact = users.getUserContact();
//		contact.setUsers(u);
//		userContactRepository.save(contact);
//		userRepository.save(u);
		userRepository.save(users);
		userContactRepository.save(users.getUserContact());
		return userRepository.findAll();
	}
	
	@GetMapping("/findUser/{name}")
	public List<Users> findUser(@PathVariable final String name)
	{	
		return userRepository.findAllUsers(name);	
	}
}
