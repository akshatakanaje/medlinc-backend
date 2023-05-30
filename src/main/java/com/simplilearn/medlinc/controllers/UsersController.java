package com.simplilearn.medlinc.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.simplilearn.medlinc.dto.ResponseDto;
import com.simplilearn.medlinc.entity.Users;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	UsersService usersService;
	
	/**
	 * Get all or search by email.
	 * 
	 * @param email
	 * @return
	 */
	@GetMapping
	public List<Users> getAll(@RequestParam(value="email", required=false) String email){
		if(email!=null && email!= "") {
			return  usersService.findByEmailContaining(email);
		}
		return  usersService.findAll();
	}
	
	/**
	 * Get user by id
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Users> getOne(@PathVariable("id") int id){
		Optional<Users> usersData = usersService.findById(id);
		if(usersData.isPresent()) {
			return usersData;
		}
		throw new NotFoundException("Users data does not exist with id '" + id + "'");
	}
	
	/**
	 * Create user
	 * 
	 * @param usersReq
	 * @return
	 */
	@PostMapping
	public Users save(@RequestBody Users users) {
		boolean exists = usersService.existsByEmail(users.getEmail());
		if(!exists) {
			return usersService.save(users);
		}
		throw new AlreadyExistsException("User data already exist with email '" + users.getEmail() + "'");
	}
	
	
	/**
	 * Update user
	 * 
	 * @param usersReq
	 * @return
	 */
	@PutMapping
	public Users update(@RequestBody Users users) {
		boolean exists = usersService.existsById(users.getUserId());
		if (exists) {
			return usersService.save(users);
		}
		throw new AlreadyExistsException("User data already exist with Id '" + users.getUserId() + "'");
	}

	
	/**
	 * Delete one user by id
	 * 
	 * @param userId
	 * @return
	 */
	@DeleteMapping("/{id}")
	public ResponseDto deleteOne(@PathVariable("id") int id) {
		boolean exists = usersService.existsById(id);
		if (exists) {
			usersService.deleteById(id);
			return new ResponseDto("Success", "User deleted", new Date(), null);
		}
		throw new NotFoundException("User does not exist with id '" + id + "'");
	}

}
