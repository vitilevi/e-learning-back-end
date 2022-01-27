package com.java.elearning.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	private long f_id;
	private long user_id;
	private String name;
	private String email;
	private String feedback;
	
	Feedback() {
		
	}

	public Feedback(long f_id, long user_id, String name, String email, String feedback) {
		this.f_id = f_id;
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.feedback = feedback;
	}

	public long getF_id() {
		return f_id;
	}

	public void setF_id(long f_id) {
		this.f_id = f_id;
	}

	public long getUser_id() {
		return user_id;
	}

	public void setUser_id(long user_id) {
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFeedback() {
		return feedback;
	}

	public void setFeedback(String feedback) {
		this.feedback = feedback;
	}
}
