package com.java.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.elearning.model.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
