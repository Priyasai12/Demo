package com.example.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.example.entity.Employee;
import com.example.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository employeeRepository;
	
	public Employee saveEmployee(String name, String address, int pincode,Long mobileNumber,MultipartFile file)throws IOException{
		Employee employee=new Employee();
		employee.setName(name);
		employee.setAddress(address);
		employee.setPincode(pincode);
		employee.setMobilenumber(mobileNumber);
		employee.setPdfDocument(file.getBytes());
		return employeeRepository.save(employee);
	}

}
