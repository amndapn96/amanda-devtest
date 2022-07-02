package com.amanda.devtest.service;

import java.util.List;

import com.amanda.devtest.model.entity.Employee;

public interface EmployeeService {
	
	List<Employee> findAll();

	Employee findById(Long id);
	
	List<Employee> findByName(String name);
	
	Employee findByPhone(String phone);

	String insertEmp(Employee emp);

	String updateEmp(Long id, Employee emp);

	String deleteById(Long id);

}
