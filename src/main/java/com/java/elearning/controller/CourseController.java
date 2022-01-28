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

import com.java.elearning.model.Course;
import com.java.elearning.repository.CourseRepository;

@RestController
@RequestMapping("/course")
public class CourseController {
	
	@Autowired
	CourseRepository db;
	
	@GetMapping("")
	public List<Course> getCourses() {
		return this.db.findAll();
	}
	
	@PostMapping("")
	public void addCourse(@RequestBody Course course, HttpServletResponse res) {
		this.db.save(course);
		res.setStatus(201);
	}

	@GetMapping("/{id}")
	public Course getCourse(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Course> course= this.db.findById(id);
		if(course.isPresent()) {
			return course.get();
		}
		res.setStatus(404);
		return null;
	}
	
	@PutMapping("/{id}")
	public void editCourse(@PathVariable("id") Long id, @RequestBody Course receivedCourse, HttpServletResponse res) {
		Optional<Course> course= this.db.findById(id);
		if (course.isPresent()) {
			Course foundCourse = course.get();
			foundCourse.setC_name(receivedCourse.getC_name());
			foundCourse.setC_desp(receivedCourse.getC_desp());
			foundCourse.setC_fees(receivedCourse.getC_fees());
			foundCourse.setC_resource(receivedCourse.getC_resource());
			this.db.save(foundCourse);
		} else {
			res.setStatus(404);
		}
	}
	
	@DeleteMapping("/{id}")
	public void deleteCourse(@PathVariable("id") Long id, HttpServletResponse res) {
		Optional<Course> course= this.db.findById(id);
		if(course.isPresent()) {
			this.db.deleteById(id);
			res.setStatus(204);
		} else {
			res.setStatus(404);
		}
	}
}
