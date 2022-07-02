package com.amanda.devtest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanda.devtest.model.entity.Employee;
import com.amanda.devtest.service.impl.EmployeeServiceImpl;

@RestController
@RequestMapping("api/devtest")
@CrossOrigin("*")
public class EmployeeController {

	@Autowired
	private EmployeeServiceImpl empService;

    public EmployeeController(EmployeeServiceImpl empService) {
        this.empService = empService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> findAllEmployees() {
        List<Employee> employees = empService.findAll();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping({"/{id}"})
    public ResponseEntity<Employee> findEmployeeById(@PathVariable("id") Long id) {
    	Employee e = empService.findById(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
    
   @PostMapping
    public ResponseEntity<String> saveEmployee(@RequestBody Employee emp) {
       	String response = empService.insertEmp(emp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PutMapping({"/{id}"})
    public ResponseEntity<String> updateEmployee(@PathVariable("id") Long id, @RequestBody Employee emp) {
        String response = empService.updateEmp(id, emp);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id) {
        String response = empService.deleteById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
    
    @GetMapping({"/name/{name}"})
    public ResponseEntity<List<Employee>> findEmployeeByName(@PathVariable("name") String name) {
    	List<Employee> e = empService.findByName(name);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }
    
    @GetMapping({"/phone/{phone}"})
    public ResponseEntity<Employee> findEmployeeByPhone(@PathVariable("phone") String phone) {
    	Employee e = empService.findByPhone(phone);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

}
