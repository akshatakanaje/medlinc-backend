package com.simplilearn.medlinc.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.simplilearn.medlinc.enduser.entity.wishlist;
import com.simplilearn.medlinc.repository.wishlistRepository;
import com.simplilearn.medlinc.service.wishlistService;

@Service
public class wishlistServiceImp implements wishlistService{
	
	@Autowired
	wishlistRepository wishlistRepository;

	@Override
	public List<wishlist> findByUserId(int userId) {
		return wishlistRepository.findByUserId(userId); 
	}

	@Override
	public List<wishlist> findAll() {
		return  wishlistRepository.findAll();
	}

	@Override
	public Optional<wishlist> findById(int wishListId) {
		return  wishlistRepository.findById(wishListId);
	}

	@Override
	public boolean existsById(int wishListId) {
		return  wishlistRepository.existsById(wishListId);
	}

	@Override
	public wishlist save(wishlist wishList) {
		return  wishlistRepository.save(wishList);
	}

	@Override
	public void deleteById(int wishListId) {
		wishlistRepository.deleteById(wishListId);
		
	}

}
