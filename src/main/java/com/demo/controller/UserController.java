package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RestController;


import com.demo.model.User;
import com.demo.service.IUserService;


@CrossOrigin
@RestController
public class UserController {
	@Autowired
	private IUserService uservice;
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getallUsers(){
		List<User> ulist=uservice.getUsers();
		return ResponseEntity.ok(ulist);
		
	}
	
	@GetMapping("/users/{userId}")
	public ResponseEntity<User> getById(@PathVariable int userId){
		User u=uservice.getUserById(userId);
		if (u!=null)
			return ResponseEntity.ok(u);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@PostMapping("/users/{userId}")
	public ResponseEntity<String> insertUser(@RequestBody User user){
		uservice.addnewUser(user);
		return ResponseEntity.ok("data added successfully");
		
	}
	@PutMapping("/users/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User user){
		uservice.updateUserById(user);
		return ResponseEntity.ok("data updated successfully");
		
	}
	@DeleteMapping("/users/{userId}")
	public ResponseEntity<String> removeById(@PathVariable int userId){
		uservice.RemoveById(userId);
		return ResponseEntity.ok("data deleted successfully");
		
	}

}
	
	/* 
	/get all products
	@GetMapping("/user")
	public ResponseEntity<List<User>> showUsers() {
		return ResponseEntity.ok(userService.getAllUsersServices());
	}
	
	//get product by id
	@GetMapping("/user/{pid}")
	public ResponseEntity<User> getUserById(@PathVariable int uid){
		User user = userService.getByIdServices(uid);
		if(user!=null)
			return ResponseEntity.ok(user);
		else
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
		
		
	//add product
	@PostMapping("/user/{uid}")
	public ResponseEntity<String> addNewUser(@RequestBody User user){
		userService.addNewUserServices(user);
		return ResponseEntity.ok("User Added Successfully");
	}
		
	//edit product
	@PutMapping("/user/{uid}")
	public ResponseEntity<String> editUser(@RequestBody User user){
		userService.updateUserServices(user);
		return ResponseEntity.ok("User Updated Successfully");
	}
		
	//delete product
	@DeleteMapping("/user/{uid}")
	public ResponseEntity<String> deleteUser(@PathVariable int uid){
		userService.deleteUserByIdServices(uid);
		return ResponseEntity.ok("User Deleted Successfully");
	} 
	*/
