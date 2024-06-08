package com.example.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {
	@CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/upload")
    public ResponseEntity<?> uploadEmployee(@RequestParam("name") String name,
                                            @RequestParam("address") String address,
                                            @RequestParam("pincode") String pincode,
                                            @RequestParam("mobileNumber") String mobileNumber,
                                            @RequestParam("file") MultipartFile file) {
                return ResponseEntity.ok("File uploaded successfully");
    }
}
