package com.spring.data.repository;

import com.spring.data.entity.Cart;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
	 List<Cart> findByUserId(Long userId);
	    void deleteByUserIdAndProductId(Long userId, Long productId);
		void deleteByUserId(Long id);
}
