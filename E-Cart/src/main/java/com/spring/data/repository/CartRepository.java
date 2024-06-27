package com.spring.data.repository;

import com.spring.data.entity.Cart;


import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
