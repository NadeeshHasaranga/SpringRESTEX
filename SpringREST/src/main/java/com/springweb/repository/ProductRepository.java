package com.springweb.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springweb.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
