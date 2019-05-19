package com.springweb.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springweb.model.Customer;
import com.springweb.repository.CustomerRepository;


@Service
public class CustomerDAO {
	

	@Autowired
	CustomerRepository customerRepository;
	
	/*to save employee */
	
	public Customer save(Customer emp) {
		return customerRepository.save(emp);
	}
	
	/* search all employee*/
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

	/*get an employee by id*/
	public Customer findone(Long empid) {
		return customerRepository.findOne(empid);
	}
	
	/*delete an employee*/
	
	public void delete (Customer emp) {
		customerRepository.delete(emp);
	}
	
	
	


}
