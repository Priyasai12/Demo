package com.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Subscription;
import com.example.repository.SubscriptionRepository;

@Service
public class SubscriptionService {
	@Autowired
    private SubscriptionRepository subscriptionRepository;

    public Subscription createSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    public List<Subscription> getAllSubscriptions() {
        return subscriptionRepository.findAll();
    }

    public Subscription getSubscriptionById(Long id) {
        Optional<Subscription> optionalSubscription = subscriptionRepository.findById(id);
        return optionalSubscription.orElse(null);
    }

    public Subscription updateSubscription(Long id, Subscription subscription) {
        if (!subscriptionRepository.existsById(id)) {
            return null;
        }
        subscription.setId(id);
        return subscriptionRepository.save(subscription);
    }

    public void deleteSubscription(Long id) {
        subscriptionRepository.deleteById(id);
    }
}
