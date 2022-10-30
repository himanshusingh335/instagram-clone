package com.example.appengineers.instagramclone.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.appengineers.instagramclone.model.MyUser;
import com.example.appengineers.instagramclone.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	UserRepository userService;
	
	@GetMapping("/users")
	public List<MyUser> getAllUsers(){
		List<MyUser> users=userService.findAll();
		return users;
	}
	
	@GetMapping("/users/{id}")
	public MyUser getUsersById(@PathVariable Integer id){
		Optional<MyUser> user=userService.findById(id);
		MyUser myUser=user.get();
		return myUser;
	}
	
//	@GetMapping("/users/{gender}")
//	public List<User> getUsersByGender(@PathVariable String gender){
//		List<User> users=userService.findByGender();
//		return users;
//	}
	
	@PostMapping("/users")
	public void addUser(@RequestBody MyUser user){
		userService.save(user);
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteUsersById(@PathVariable Integer id){
		userService.deleteById(id);
	}

}
