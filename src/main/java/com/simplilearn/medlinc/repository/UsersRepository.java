package com.simplilearn.medlinc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.simplilearn.medlinc.entity.Users;

public interface UsersRepository extends JpaRepository<Users, Integer>{

}
