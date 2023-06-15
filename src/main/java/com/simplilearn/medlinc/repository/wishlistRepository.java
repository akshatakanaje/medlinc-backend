package com.simplilearn.medlinc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.simplilearn.medlinc.enduser.entity.wishlist;

@Repository
public interface wishlistRepository extends JpaRepository<wishlist, Integer>{

	List<wishlist> findByUserId(int userId);

}
