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

import com.java.elearning.model.Contact;
import com.java.elearning.repository.ContactRepository;

@RestController
@RequestMapping("/contact")
public class ContactController {

	@Autowired
	ContactRepository db;
	
	@GetMapping("")
	public List<Contact> getContacts() {
		return this.db.findAll();
	}
	
	@PostMapping("")
	public void addContact(@RequestBody Contact contact, HttpServletResponse res) {
		this.db.save(contact);
		res.setStatus(201);
	}
	
	@GetMapping("/{id}")
	public Contact getContact(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Contact> contact= this.db.findById(id);
		if(contact.isPresent()) {
			return contact.get();
		}
		res.setStatus(404);
		return null;
	}
	
	@PutMapping("/{id}")
	public void editContact(@PathVariable("id") Long id, @RequestBody Contact receivedContact, HttpServletResponse res) {
		Optional<Contact> contact= this.db.findById(id);
		if (contact.isPresent()) {
			Contact foundContact = contact.get();
			foundContact.setName(receivedContact.getName());
			foundContact.setEmail(receivedContact.getEmail());
			foundContact.setPhone_no(receivedContact.getPhone_no());
			foundContact.setMessage(receivedContact.getMessage());
			this.db.save(foundContact);
		} else {
			res.setStatus(404);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteContact(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Contact> contact= this.db.findById(id);
		if(contact.isPresent()) {
			this.db.deleteById(id);
			res.setStatus(204);
		} else {
			res.setStatus(404);
		}
	}
}
