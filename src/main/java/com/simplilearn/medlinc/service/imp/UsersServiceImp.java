package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.entity.Users;
import com.simplilearn.medlinc.repository.UsersRepository;
import com.simplilearn.medlinc.service.UsersService;

@Service
public class UsersServiceImp implements UsersService{

	@Autowired
    UsersRepository usersRepository;
	
	
	@Override
	public List<Users> findByEmailContaining(String email) {
		return usersRepository.findByEmailContaining(email);
	}

	@Override
	public List<Users> findAll() {
		return usersRepository.findAll();
	}

	@Override
	public Optional<Users> findById(int id) {
		return usersRepository.findById(id);
	}

	@Override
	public boolean existsByEmail(String email) {
		return usersRepository.existsByEmail(email);
	}

	@Override
	public Users save(Users users) {
		return usersRepository.save(users);
	}

	@Override
	public boolean existsById(int userId) {
		return usersRepository.existsById(userId);
	}

	@Override
	public void deleteById(int id) {
		usersRepository.deleteById(id);
		
	}

}