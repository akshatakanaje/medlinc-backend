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

import com.simplilearn.medlinc.dto.LoginReqDto;
import com.simplilearn.medlinc.dto.ResponseDto;
import com.simplilearn.medlinc.entity.Admins;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.AdminsService;

@RestController
@RequestMapping("/admins")
public class AdminsController {
	
	@Autowired
	AdminsService adminsService;
	
	/**
	 * Get all or search by email.
	 * @param email
	 * @return
	 */
	@GetMapping
	public List<Admins> getAll(@RequestParam(value="email", required=false) String email){
		if(email!=null) {
			return adminsService.findByEmailContaining(email);
		}
	return adminsService.findAll();		
	}
	
	
	/**
	 * Get admin user by id
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	public Optional<Admins> getOne(@PathVariable("id") int id){
		Optional<Admins> adminData = adminsService.findById(id);
		if(adminData.isPresent()) {
			return adminData;
		}
		throw new NotFoundException("Admin user does not exists with id "+id+"'");
	}
	
	
	/**
	 * Create admin user.
	 * @param adminsReq
	 * @return
	 */
	@PostMapping
	public Admins save(@RequestBody Admins adminsReq) {
		boolean exists = adminsService.existsByEmail(adminsReq.getEmail());
		if (!exists) {
			return adminsService.save(adminsReq);
		}
		throw new AlreadyExistsException("Admin user already exist with email '"+adminsReq.getEmail() +"'");
	}
	
	
	/**
	 * Update Admins
	 * @param Admins
	 * @return
	 */
	@PutMapping
	public Admins udpate(@RequestBody Admins admins) {
		boolean exists = adminsService.existsById(admins.getAdminId());
		if (exists) {
			return adminsService.save(admins);
		}
		throw new NotFoundException("Admin user does not exist with id '"+ admins.getAdminId() +"'");
	}
	
	
	/**
	 * Delete one product by id
	 * @param Id
	 * @return 
	 */
	@DeleteMapping("/{id}")
	public ResponseDto deleteOne(@PathVariable("id") int id) {
		boolean eixts = adminsService.existsById(id);
		if (eixts) {
			adminsService.deleteById(id);
			return new ResponseDto("Success","Admin user deleted", new Date(), null);
		}
		throw new NotFoundException("Admin user does not exist with id '"+ id +"'");
	}
	
	/*
	 * Validate Login for admin user
	 * @param adminReq
	 * @return
	 */
	@PostMapping("/login")
	public ResponseDto save(@RequestBody LoginReqDto loginReqDto) {
		boolean exists = adminsService.existsByEmail(loginReqDto.getEmail());
		if(exists) {
			boolean match = adminsService.login(loginReqDto);
			if(match) {
				return new ResponseDto("Success","Admin login successfull", new Date(), loginReqDto.getEmail()); 
			}else {
				throw new NotFoundException("Invalid password, password mismatch error.");
			}
		}
		throw new NotFoundException("Admin user does not exist with email'"+ loginReqDto.getEmail() +"'");
		}

}
