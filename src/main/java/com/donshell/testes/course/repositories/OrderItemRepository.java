package com.donshell.testes.course.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.donshell.testes.course.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
