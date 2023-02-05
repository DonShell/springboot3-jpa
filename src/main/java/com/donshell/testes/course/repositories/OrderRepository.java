package com.donshell.testes.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donshell.testes.course.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
