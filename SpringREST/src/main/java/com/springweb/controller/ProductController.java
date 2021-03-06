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

import com.springweb.dao.ProductDAO;
import com.springweb.model.Product;


@RestController
@RequestMapping("/company")
public class ProductController {
	
	
@Autowired

ProductDAO productDAO;


/*to save an employee */

@PostMapping("/employee")
public Product createEmployee(@Valid @RequestBody Product emp)
{
	return productDAO.save(emp);
}


/*get all employees */

@GetMapping("/employee")
public List <Product> getAllEmployees(){
	return productDAO.findAll();
}

/*get employee by empid */

@GetMapping("/notes/{id}")
public ResponseEntity<Product> getEmployeeById(@PathVariable(value ="id")Long empid){

	
		Product emp = productDAO.findone(empid);
		
		if(emp==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok().body(emp);
			
}


/*update an employee by empid
 
 */


@PutMapping("/employees/{id}")
public ResponseEntity<Product> updateEmployee(@PathVariable(value ="id") Long empid,@Valid @RequestBody Product empDetails){


	Product emp = productDAO.findone(empid);
	
	if(emp==null) {
		return ResponseEntity.notFound().build();
	}
	
	emp.setName(empDetails.getName());
	emp.setPrice(empDetails.getPrice());
	emp.setQuantity(empDetails.getQuantity());
	emp.setCategory(empDetails.getCategory());
	emp.setBrand(empDetails.getBrand());
	
	Product updateEmployee = productDAO.save(emp);
	return ResponseEntity.ok().body(emp);


}

/*Delete an employee*/
@DeleteMapping("/notes/{id}")
public ResponseEntity<Product> deleteEmployee(@PathVariable(value="id")Long empid) {
Product emp = productDAO.findone(empid);
	
	if(emp==null) {
		return ResponseEntity.notFound().build();
	}
	 productDAO.delete(emp);
	 return ResponseEntity.ok().build();


}


}
