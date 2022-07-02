package com.amanda.devtest.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanda.devtest.model.entity.Employee;
import com.amanda.devtest.repository.EmployeeRepository;
import com.amanda.devtest.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	public EmployeeServiceImpl(EmployeeRepository empRepository) {
		this.empRepository = empRepository;
	}

	@Override
	public Employee findById(Long id) {
		Optional<Employee> e = empRepository.findById(id);
		if (e.isEmpty()) {
			return null;
		}
		return e.get();
	}

	@Override
	public List<Employee> findAll() {
		List<Employee> employees = new ArrayList<>();
		empRepository.findAll().forEach(employees::add);
		return employees;
	}

	@Override
	public String insertEmp(Employee emp) {
		if (empRepository.save(emp) == null) {
			return "Data cannot be saved";
		}

		return "Data has been saved successfully";
	}

	@Override
	public String updateEmp(Long id, Employee emp) {
		Optional<Employee> e = empRepository.findById(id);
		if (e.isEmpty()) {
			return "Data not Found!";
		} else {
			Employee newEmp = e.get();
			newEmp.setName(emp.getName());
			newEmp.setPhone(emp.getPhone());
			return "Data has been updated successfully!";
		}
	}

	@Override
	public String deleteById(Long id) {
		Optional<Employee> e = empRepository.findById(id);
		if (e.isEmpty()) {
			return "Data not Found!";
		} else {
			empRepository.delete(e.get());
			return "Data was deleted!";
		}
	}

	@Override
	public List<Employee> findByName(String name) {
		List<Employee> e = empRepository.findByName(name);
		if (e.isEmpty()) {
			return null;
		}
		return e;
	}

	@Override
	public Employee findByPhone(String phone) {
		Employee e = empRepository.findByPhone(phone);
		if (e == null) {
			return null;
		}
		return e;
	}

}
