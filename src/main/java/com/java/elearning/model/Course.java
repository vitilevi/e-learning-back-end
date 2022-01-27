package com.java.elearning.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "course")
public class Course {
	
	@Id
	private long course_id;
	private String c_name;
	private String c_desp;
	private long c_fees;
	private String c_resource;
	
	Course() {
		
	}

	public Course(long course_id, String c_name, String c_desp, long c_fees, String c_resource) {
		this.course_id = course_id;
		this.c_name = c_name;
		this.c_desp = c_desp;
		this.c_fees = c_fees;
		this.c_resource = c_resource;
	}

	public long getCourse_id() {
		return course_id;
	}

	public void setCourse_id(long course_id) {
		this.course_id = course_id;
	}

	public String getC_name() {
		return c_name;
	}

	public void setC_name(String c_name) {
		this.c_name = c_name;
	}

	public String getC_desp() {
		return c_desp;
	}

	public void setC_desp(String c_desp) {
		this.c_desp = c_desp;
	}

	public long getC_fees() {
		return c_fees;
	}

	public void setC_fees(long c_fees) {
		this.c_fees = c_fees;
	}

	public String getC_resource() {
		return c_resource;
	}

	public void setC_resource(String c_resource) {
		this.c_resource = c_resource;
	}
}
