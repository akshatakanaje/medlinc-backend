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
import com.simplilearn.medlinc.enduser.entity.Carts;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.CartsService;

@RestController
@RequestMapping("/carts")
public class CartsController {
	
	@Autowired
	CartsService cartsService;
	
	/**
	 * Get all carts.
	 * @param  id
	 * @return
	 */
	@GetMapping
	public List<Carts> getAll(@RequestParam(value="userId", required=false) String userId){
		if(userId != null) {
			return cartsService.findByUserId(Integer.parseInt(userId));
		}
		return cartsService.findAll();
	}
	
	/**
	 * Get cart by id
	 * @param id
	 * @return
	 */
	@GetMapping("/{cartId}")
	public Optional<Carts> getOne(@PathVariable("CartId") int CartId){
		Optional<Carts> cartData = cartsService.findById(CartId);
		if(cartData.isPresent()) {
			return cartData;
		}
		throw new NotFoundException("Cart does not exist with id '"+ CartId +"'");
	}
	
	/**
	 * Create Carts.
	 * @param carts
	 * @return
	 */
	@PostMapping
	public Carts save(@RequestBody Carts carts) {
		boolean exists = cartsService.existsById(carts.getCartId());
		if(!exists) {
			return cartsService.save(carts);
		}
		throw new AlreadyExistsException("Cart is already exist with id'"+ carts.getCartId() +"'");
	}
	
	/**
	 * Update carts
	 * @param carts
	 * @return
	 */
	@PutMapping
	public Carts update(@RequestBody Carts carts) {
		boolean exists = cartsService.existsById(carts.getCartId());
		if(exists) {
			return cartsService.save(carts);
		}
		throw new NotFoundException("Carts does not exist with cartId '"+ carts.getCartId() +"'");
	}
	
	
	/**
	 * Delete one cart by id
	 * @param cartId
	 * @return Optional<Carts>
	 */
	@DeleteMapping("/{cartId}")
	public ResponseDto delete(@PathVariable ("cartId") int cartId) {
		boolean exists = cartsService.existsById(cartId);
		if(exists) {
			cartsService.deleteById(cartId);
			return new ResponseDto("Success","Cart deleted", new Date(), null);
		}
		throw new NotFoundException("Carts does not exist with cartId '"+ cartId +"'");
	}
}
