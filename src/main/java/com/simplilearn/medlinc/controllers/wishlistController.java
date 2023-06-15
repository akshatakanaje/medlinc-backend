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
import com.simplilearn.medlinc.enduser.entity.wishlist;
import com.simplilearn.medlinc.exceptions.AlreadyExistsException;
import com.simplilearn.medlinc.exceptions.NotFoundException;
import com.simplilearn.medlinc.service.wishlistService;

@RestController
@RequestMapping("/wishlist")
public class wishlistController {
	
	@Autowired
	wishlistService wishListService;
	
	/**
	 * Get all whishlist.
	 * @param  id
	 * @return
	 */
	@GetMapping
	public List<wishlist> getAll(@RequestParam(value = "userId", required = false) String userId){
		if( userId != null) {
			return  wishListService.findByUserId(Integer.parseInt(userId));
		}
		return wishListService.findAll();
	}
	
	/**
	 * Get whishList by id
	 * @param id
	 * @return
	 */
	@GetMapping("/{wishListId}")
	public Optional<wishlist> getOne(@PathVariable("wishListId") int wishListId){
		Optional<wishlist> wishListData = wishListService.findById(wishListId);
		if(wishListData.isPresent()) {
			return wishListData;
		}
		throw new NotFoundException("WishList does not exist with id '"+ wishListId +"'");
	}
	
	/**
	 * Create whishList.
	 * @param whishList
	 * @return
	 */
	@PostMapping
	public wishlist save(@RequestBody wishlist wishList) {
		boolean exists = wishListService.existsById(wishList.getWishListId());
		if(!exists) {
			return wishListService.save(wishList);
		}
		throw new AlreadyExistsException("WishList is already exist with id'"+ wishList.getWishListId() +"'");
	}
	
	/**
	 * Update whishList.
	 * @param whishList
	 * @return
	 */
	@PutMapping
	public wishlist update(@RequestBody wishlist wishList) {
		boolean exists = wishListService.existsById(wishList.getWishListId());
		if(exists) {
			return wishListService.save(wishList);
		}
		throw new NotFoundException("WishList does not exist with whishListId '"+ wishList.getWishListId() +"'");
	}
	
	/**
	 * Delete one whish by id
	 * @param whishId
	 * @return 
	 */
	@DeleteMapping("/{wishListId}")
	public ResponseDto deleteOne(@PathVariable("wishListId") int wishListId) {
		boolean exists = wishListService.existsById(wishListId);
		if(exists) {
			wishListService.deleteById(wishListId);
			return new ResponseDto("Success","Cart deleted", new Date(), null);
		}
		throw new NotFoundException("WishList does not exist with whishListId '"+ wishListId +"'");
	}
	

}
