package com.java.elearning.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.java.elearning.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
