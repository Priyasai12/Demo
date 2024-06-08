package com.example.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, Long> {
    Optional<Login> findByEmail(String email); 

}
