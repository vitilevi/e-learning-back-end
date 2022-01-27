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

import com.java.elearning.model.Admin;
import com.java.elearning.repository.AdminRepository;

@RestController
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminRepository db;
	
	@GetMapping("")
	public List<Admin> getAdmins() {
		return this.db.findAll();
	}
	
	@PostMapping("")
	public void addAdmin(@RequestBody Admin admin, HttpServletResponse res) {
		this.db.save(admin);
		res.setStatus(201);
	}
	
	@GetMapping("/{id}")
	public Admin getAdmin(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Admin> admin= this.db.findById(id);
		if(admin.isPresent()) {
			return admin.get();
		}
		res.setStatus(404);
		return null;
	}
	
	@PutMapping("/{id}")
	public void editAdmin(@PathVariable("id") Long id, @RequestBody Admin receivedAdmin, HttpServletResponse res) {
		Optional<Admin> admin= this.db.findById(id);
		if (admin.isPresent()) {
			Admin foundAdmin = admin.get();
			foundAdmin.setName(receivedAdmin.getName());
			foundAdmin.setEmail(receivedAdmin.getEmail());
			foundAdmin.setPassword(receivedAdmin.getPassword());
			this.db.save(foundAdmin);
		} else {
			res.setStatus(404);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteAdmin(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Admin> admin = this.db.findById(id);
		if(admin.isPresent()) {
			this.db.deleteById(id);
			res.setStatus(204);
		} else {
			res.setStatus(404);
		}
	}

}
