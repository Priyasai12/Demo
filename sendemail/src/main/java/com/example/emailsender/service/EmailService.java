package com.example.emailsender.service;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import com.example.emailsender.model.EmailSubscriber;
import com.example.emailsender.repository.EmailSubscriberRepository;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;

//@Service
//public class EmailService {
//	@Autowired
//    private JavaMailSender javaMailSender;
//	@Autowired
//	private EmailSubscriberRepository emailrepo;
//
////    public void sendEmail(String recipient, String subject, String body) {
////        SimpleMailMessage message = new SimpleMailMessage();
////        message.setTo(recipient);
////        message.setSubject(subject);
////        message.setText(body);
////        javaMailSender.send(message);
////    }
//	public void sendEmails(String subject, String message) {
//        List<EmailSubscriber> subscribers = emailrepo.findAll();
//
//        for (EmailSubscriber subscriber : subscribers) {
//            MimeMessage mimeMessage = javaMailSender.createMimeMessage();
//            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, "utf-8");
//
//            try {
//                helper.setTo(subscriber.getEmail());
//                helper.setSubject(subject);
//                helper.setText(message, true); // Use true to enable HTML content
//                javaMailSender.send(mimeMessage);
//            } catch (MessagingException e) {
//                e.printStackTrace();
//                // Handle exception as needed
//            }
//        }
//	}
//}
@Service
public class EmailService {
	@Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(String to, String subject, String text) {
        MimeMessage message = emailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(text, true);  // Set to true for HTML content

            emailSender.send(message);
        } catch (MessagingException e) {
            e.printStackTrace();
            // Handle the exception appropriately in a real application
        }
    }
}
        
        
    

