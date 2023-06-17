package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medlinc.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

	List<Users> findByEmailContaining(String email);

	boolean existsByEmail(String email);

	Users findByEmail(String email);

}
