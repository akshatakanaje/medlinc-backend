package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.entity.Admins;

public interface AdminsService {

	List<Admins> findByEmailContaining(String email);

	List<Admins> findAll();

	Optional<Admins> findById(int id);

	boolean existsByEmail(String email);

	Admins save(Admins adminsReq);

	boolean existsById(int adminId);

	void deleteById(int id);

	
}
