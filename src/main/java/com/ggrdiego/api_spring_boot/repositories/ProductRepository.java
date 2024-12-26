package com.ggrdiego.api_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggrdiego.api_spring_boot.entities.Product;


public interface ProductRepository extends JpaRepository<Product, Long> {

}
