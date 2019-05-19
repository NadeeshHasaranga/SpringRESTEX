package com.springweb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.springweb.dao.SupplierDAO;
import com.springweb.model.Supplier;

import java.util.List;

@RestController
public class SupplierController {

    @Autowired
    private Supplier SupplierDAO;

    @GetMapping(value = "/utils/supplier", params = "supplier_id")
    public ResponseEntity<Supplier> getSupplierBySuppier(@RequestParam(name = "s_id") String sid) {
        return new ResponseEntity<>(SupplierDAO.getSupplerById(sid), HttpStatus.OK);
    }

    @GetMapping("/utils/suppliersd")
    public ResponseEntity<List<Supplier>> getAllSupplier() {
        return new ResponseEntity<>(SupplierDAO.getAllSupplier(), HttpStatus.OK);
    }

    @PostMapping("utils/supplier")
    public ResponseEntity<Supplier> createSupplier(@RequestBody Supplier supplier) {
        return new ResponseEntity<>(SupplierDAO.createSupplier(supplier), HttpStatus.OK);
    }

    @PutMapping("/utils/supplier/{sid}")
    public ResponseEntity<Supplier> updateSupplier(@PathVariable int sid, @RequestBody Supplier sid) {
    	
        return new ResponseEntity<Supplier>(SupplierDAO.updateSupplier(sid, SupplierDAO), HttpStatus.OK);
    }

    @DeleteMapping("utils/supplier/{sid}")
    public ResponseEntity deleteSupplier(@PathVariable int sid) {
    	Supplier sid = SupplierDAO.findone(sid);
    	
    	if(sid==null) {
    		return ResponseEntity.notFound().build();
    	}
    	 SupplierDAO.delete(sid);
    	 return ResponseEntity.ok().build();


    }
}
