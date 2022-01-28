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

import com.java.elearning.model.Feedback;
import com.java.elearning.repository.FeedbackRepository;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

	@Autowired
	FeedbackRepository db;
	
	@GetMapping("")
	public List<Feedback> getFeedbacks() {
		return this.db.findAll();
	}
	
	@PostMapping("")
	public void addFeedback(@RequestBody Feedback feedback, HttpServletResponse res) {
		this.db.save(feedback);
		res.setStatus(201);
	}
	
	@GetMapping("/{id}")
	public Feedback getFeedback(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Feedback> feedback= this.db.findById(id);
		if(feedback.isPresent()) {
			return feedback.get();
		}
		res.setStatus(404);
		return null;
	}
	
	@PutMapping("/{id}")
	public void editFeedback(@PathVariable("id") Long id, @RequestBody Feedback receivedFeedback, HttpServletResponse res) {
		Optional<Feedback> feedback= this.db.findById(id);
		if (feedback.isPresent()) {
			Feedback foundFeedback = feedback.get();
			foundFeedback.setName(receivedFeedback.getName());
			foundFeedback.setEmail(receivedFeedback.getEmail());
			foundFeedback.setFeedback(receivedFeedback.getFeedback());
			this.db.save(foundFeedback);
		} else {
			res.setStatus(404);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteFeedback(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Feedback> feedback= this.db.findById(id);
		if(feedback.isPresent()) {
			this.db.deleteById(id);
			res.setStatus(204);
		} else {
			res.setStatus(404);
		}
	}
}
