package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Subscription;
import com.example.service.SubscriptionService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/subscriptions")
public class SubscriptionController {
	 @Autowired
	    private SubscriptionService subscriptionService;

	    @PostMapping
	    public ResponseEntity<Subscription> createSubscription(@Valid @RequestBody Subscription subscription) {
	        Subscription createdSubscription = subscriptionService.createSubscription(subscription);
	        return new ResponseEntity<>(createdSubscription, HttpStatus.CREATED);
	    }

	    @GetMapping
	    public ResponseEntity<List<Subscription>> getAllSubscriptions() {
	        List<Subscription> subscriptions = subscriptionService.getAllSubscriptions();
	        return new ResponseEntity<>(subscriptions, HttpStatus.OK);
	    }

	    @GetMapping("/{id}")
	    public ResponseEntity<Subscription> getSubscriptionById(@PathVariable Long id) {
	        Subscription subscription = subscriptionService.getSubscriptionById(id);
	        return new ResponseEntity<>(subscription, HttpStatus.OK);
	    }

	    @PutMapping("/{id}")
	    public ResponseEntity<Subscription> updateSubscription(@PathVariable Long id, @Valid @RequestBody Subscription subscription) {
	        Subscription updatedSubscription = subscriptionService.updateSubscription(id, subscription);
	        return new ResponseEntity<>(updatedSubscription, HttpStatus.OK);
	    }

	    @DeleteMapping("/{id}")
	    public ResponseEntity<Void> deleteSubscription(@PathVariable Long id) {
	        subscriptionService.deleteSubscription(id);
	        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	    }
	}


