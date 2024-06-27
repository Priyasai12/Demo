package com.spring.data.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.data.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{
}
