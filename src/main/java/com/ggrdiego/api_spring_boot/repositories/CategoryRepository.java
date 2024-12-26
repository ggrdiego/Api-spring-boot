package com.ggrdiego.api_spring_boot.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ggrdiego.api_spring_boot.entities.Category;


public interface CategoryRepository extends JpaRepository<Category, Long> {

}
