package com.travelManagement.UserService.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.travelManagement.UserService.model.SecurityQuestion;
import com.travelManagement.UserService.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsernameAndPassword(String username, String password);

	boolean existsByUsername(String username);

	boolean existsByEmail(String email);

	User findByEmailAndPassword(String queryVal, String password);
}
