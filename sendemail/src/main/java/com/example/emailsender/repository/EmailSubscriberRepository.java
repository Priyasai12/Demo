package com.example.emailsender.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.emailsender.model.EmailSubscriber;

public interface EmailSubscriberRepository extends JpaRepository<EmailSubscriber, Long> {

}
