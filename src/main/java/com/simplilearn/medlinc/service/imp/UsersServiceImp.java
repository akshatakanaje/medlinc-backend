package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.dto.LoginReqDto;
import com.simplilearn.medlinc.entity.Users;
import com.simplilearn.medlinc.repository.UsersRepository;
import com.simplilearn.medlinc.service.UsersService;

@Service
public class UsersServiceImp implements UsersService{

	@Autowired
    UsersRepository usersRepository;
	
	BCryptPasswordEncoder passwordEncoder;
	
	
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
	public Users save(Users usersReq) {
		passwordEncoder = new BCryptPasswordEncoder();
		String encodedPassword = passwordEncoder.encode(usersReq.getPassword());
		usersReq.setPassword(encodedPassword);
		return usersRepository.save(usersReq);
	}

	@Override
	public boolean existsById(int userId) {
		return usersRepository.existsById(userId);
	}

	@Override
	public void deleteById(int id) {
		usersRepository.deleteById(id);
		
	}

	@Override
	public boolean login(LoginReqDto loginReqDto) {
		passwordEncoder = new BCryptPasswordEncoder();
		Users user  = usersRepository.findByEmail(loginReqDto.getEmail());
		return passwordEncoder.matches(loginReqDto.getPassword(), user.getPassword());
	}

	@Override
	public Users findByEmail(String email) {
		return usersRepository.findByEmail(email);
	}

}
