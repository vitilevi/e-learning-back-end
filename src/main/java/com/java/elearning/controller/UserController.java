package com.java.elearning.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java.elearning.model.User;
import com.java.elearning.repository.UserRepository;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository db;

	
	@GetMapping("")
	public List<User> getUsers() {
		return this.db.findAll();
	}
	
	@PostMapping("")
	public void addUser(@RequestBody User user, HttpServletResponse res) {
		res.setStatus(201);
		this.db.save(user);
	}
	
	@GetMapping("/{id}")
	public User getUser(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<User> user = this.db.findById(id);
		if(user.isPresent()) {
			return user.get();
		}
		res.setStatus(404);
		return null;
	}
	
	@PutMapping("/{id}")
	public void editUser(@PathVariable("id") Long id, @RequestBody User receivedUser, HttpServletResponse res) {
		Optional<User> user = this.db.findById(id);
		if (user.isPresent()) {
			User foundUser = user.get();
			foundUser.setName(receivedUser.getName());
			foundUser.setPhone_no(receivedUser.getPhone_no());
			foundUser.setEmail(receivedUser.getEmail());
			foundUser.setAddress(receivedUser.getAddress());
			foundUser.setReg_date(receivedUser.getReg_date());
			foundUser.setPassword(receivedUser.getPassword());
			foundUser.setUpload_photo(receivedUser.getUpload_photo());
			this.db.save(foundUser);
		} else {
			res.setStatus(404);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<User> user = this.db.findById(id);
		if(user.isPresent()) {
			this.db.deleteById(id);
			res.setStatus(204);
		} else {
			res.setStatus(404);
		}
	}
}
