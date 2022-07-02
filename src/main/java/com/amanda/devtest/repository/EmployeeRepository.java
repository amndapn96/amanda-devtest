package com.amanda.devtest.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.amanda.devtest.model.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	@Query("SELECT e FROM Employee e WHERE e.name LIKE %:name%")
	List<Employee> findByName(@Param("name") String name);
	
	@Query("SELECT e FROM Employee e WHERE e.phone =:phone")
	Employee findByPhone(@Param("phone") String phone);

}
