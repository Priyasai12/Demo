package com.example.emailsender.controller;



import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.emailsender.model.EmailSubscriber;
import com.example.emailsender.repository.EmailSubscriberRepository;
import com.example.emailsender.service.EmailService;

@Controller
public class EmailController {
	@Autowired
    private EmailSubscriberRepository emailRecipientRepository;

    @Autowired
    private EmailService emailService;

    @Autowired
    private TaskScheduler taskScheduler;

    @GetMapping("/")
    public String getEmailSchedulerPage(Model model) {
        List<EmailSubscriber> emails = emailRecipientRepository.findAll();
        model.addAttribute("emails", emails);
        model.addAttribute("emailRequest", new EmailRequest());
        return "email-scheduler"; // Return the HTML page with the combined functionality
    }

    @PostMapping("/schedule-email")
    public String scheduleEmail(@ModelAttribute EmailRequest emailRequest, Model model) {
        LocalDateTime scheduledTime = LocalDateTime.parse(emailRequest.getEmailTime(), DateTimeFormatter.ISO_LOCAL_DATE_TIME);

        List<EmailSubscriber> emails = emailRecipientRepository.findAll();

        for (EmailSubscriber email : emails) {
            taskScheduler.schedule(() -> {
                emailService.sendSimpleMessage(email.getEmail(), "Scheduled Email", emailRequest.getMessage());
            }, scheduledTime.atZone(ZoneId.systemDefault()).toInstant());
        }

        model.addAttribute("successMessage", "Email Sended successfully!");
        model.addAttribute("emailRequest", new EmailRequest());
        return "email-scheduler";
    }

    // Class to map form data
    public static class EmailRequest {
        private String emailTime;
        private String message;

        // Getters and setters
        public String getEmailTime() {
            return emailTime;
        }

        public void setEmailTime(String emailTime) {
            this.emailTime = emailTime;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
}
