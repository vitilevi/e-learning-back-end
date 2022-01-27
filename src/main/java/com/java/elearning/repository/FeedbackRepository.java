package com.java.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.elearning.model.Feedback;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {

}
