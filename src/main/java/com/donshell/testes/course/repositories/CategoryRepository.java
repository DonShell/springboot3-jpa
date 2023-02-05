package com.donshell.testes.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donshell.testes.course.entities.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
