package com.simplilearn.medlinc.service;

import java.util.List;
import java.util.Optional;

import com.simplilearn.medlinc.enduser.entity.wishlist;

public interface wishlistService {

	List<wishlist> findByUserId(int userId);

	List<wishlist> findAll();

	Optional<wishlist> findById(int wishListId);

	boolean existsById(int wishListId);

	wishlist save(wishlist wishList);

	void deleteById(int wishListId);

}
