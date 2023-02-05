package com.donshell.testes.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donshell.testes.course.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
