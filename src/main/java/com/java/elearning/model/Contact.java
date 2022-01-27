package com.java.elearning.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "contact")
public class Contact {
	
	@Id
	private long contact_id;
	private long user_id;
	private String name;
	private String email;
	private String phone_no;
	private String message;
	
	Contact() {
		
	}

	public Contact(long contact_id, long user_id, String name, String email, String phone_no, String message) {
		this.contact_id = contact_id;
		this.user_id = user_id;
		this.name = name;
		this.email = email;
		this.phone_no = phone_no;
		this.message = message;
	}

	public long getContact_id() {
		return contact_id;
	}

	public void setContact_id(long contact_id) {
		this.contact_id = contact_id;
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

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
