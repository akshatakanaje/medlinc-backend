package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.entity.Admins;
import com.simplilearn.medlinc.repository.AdminsRepository;
import com.simplilearn.medlinc.service.AdminsService;

@Service
public class AdminsServiceImp implements AdminsService{

	@Autowired
	AdminsRepository adminsRepository;
	
	@Override
	public List<Admins> findByEmailContaining(String email) {
		return adminsRepository.findByEmailContaining(email);
	}

	@Override
	public List<Admins> findAll() {
		return adminsRepository.findAll();
	}

	@Override
	public Optional<Admins> findById(int id) {
		return adminsRepository.findById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		return adminsRepository.existsByEmail(email);
	}

	@Override
	public Admins save(Admins adminsReq) {
		return adminsRepository.save(adminsReq);
	}

	@Override
	public boolean existsById(int adminId) {
		return adminsRepository.existsById(adminId);
	}

	@Override
	public void deleteById(int id) {
		adminsRepository.deleteById(id);	
		
	}

}
