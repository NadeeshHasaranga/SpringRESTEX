package com.springweb.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springweb.dao.CustomerDAO;
import com.springweb.model.Customer;



@RestController
@RequestMapping("/company")
public class CustomerController {
	
	
	@Autowired

	CustomerDAO customerDAO;

	/* to save an employee */

	@PostMapping("/employee")
	public Customer createEmployee(@Valid @RequestBody Customer emp) {
		return customerDAO.save(emp);
	}

	/* get all employees */

	@GetMapping("/employee")
	public List<Customer> getAllEmployees() {
		return customerDAO.findAll();
	}

	/* get employee by empid */

	@GetMapping("/notes/{id}")
	public ResponseEntity<Customer> getEmployeeById(@PathVariable(value = "id") Long empid) {

		Customer emp = customerDAO.findone(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);

	}

	/*
	 * update an employee by empid
	 * 
	 */

	@PutMapping("/employees/{id}")
	public ResponseEntity<Customer> updateEmployee(@PathVariable(value = "id") Long empid,
			@Valid @RequestBody Customer empDetails) {

		Customer emp = customerDAO.findone(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}

		emp.setName(empDetails.getName());
		emp.setPrice(empDetails.getPrice());
		emp.setQuantity(empDetails.getQuantity());
		emp.setCategory(empDetails.getCategory());
		emp.setBrand(empDetails.getBrand());

		Customer updateEmployee = customerDAO.save(emp);
		return ResponseEntity.ok().body(emp);

	}

	/* Delete an employee */
	@DeleteMapping("/notes/{id}")
	public ResponseEntity<Customer> deleteEmployee(@PathVariable(value = "id") Long empid) {
		Customer emp = customerDAO.findone(empid);

		if (emp == null) {
			return ResponseEntity.notFound().build();
		}
		customerDAO.delete(emp);
		return ResponseEntity.ok().build();

	}


}
