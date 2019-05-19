package com.springweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.springweb.model.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {


    public Supplier findBankBysupplierid(String supplierid);
    public void deleteSupplierById(int sid);
    public Supplier findSupplierById(int sid);

}
