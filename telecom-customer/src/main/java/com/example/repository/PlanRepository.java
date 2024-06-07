package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.model.Plan;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {

}
