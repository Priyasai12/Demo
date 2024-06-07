package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Plan;
import com.example.repository.PlanRepository;

@Service
public class PlanService {
	@Autowired
    private PlanRepository planRepository;

    public Plan createPlan(Plan plan) {
        return planRepository.save(plan);
    }

    public List<Plan> getAllPlans() {
        return planRepository.findAll();
    }

    public Plan getPlanById(Long id) {
        Optional<Plan> optionalPlan = planRepository.findById(id);
        return optionalPlan.orElse(null);
    }

    public Plan updatePlan(Long id, Plan plan) {
        if (!planRepository.existsById(id)) {
            return null;
        }
        plan.setId(id);
        return planRepository.save(plan);
    }

    public void deletePlan(Long id) {
        planRepository.deleteById(id);
    }

}
