package com.example.controller;

import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.entity.Login;
import com.example.service.LoginService;

@RestController
@RequestMapping("/api/student")
@CrossOrigin(origins = "http://localhost:3000")
public class LoginController {
	
	@Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<?> loginStudent(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");
        
        if (email == null || password == null) {
            return ResponseEntity.badRequest().body("Email or password is missing.");
        }

        Optional<Login> optionalLogin = loginService.findByEmail(email);
        if (optionalLogin.isPresent()) {
            Login login = optionalLogin.get();
            if (login.getPassword().equals(password)) {
                // Password matches, login successful
                return ResponseEntity.ok("Login Successful!");
            } else {
                // Password doesn't match, login failed
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Incorrect password.");
            }
        } else {
            // User not found, login failed
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("User not found.");
        }
    }
}
