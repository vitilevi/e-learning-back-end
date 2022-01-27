package com.java.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.elearning.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Long> {

}
