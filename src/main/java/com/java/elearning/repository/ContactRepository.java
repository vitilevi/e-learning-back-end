package com.java.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.java.elearning.model.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
