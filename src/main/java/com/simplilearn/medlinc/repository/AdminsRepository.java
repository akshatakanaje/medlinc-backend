package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplilearn.medlinc.entity.Admins;

@Repository
public interface AdminsRepository extends JpaRepository<Admins, Integer>{

	List<Admins> findByEmailContaining(String email);

	boolean existsByEmail(String email);

}
