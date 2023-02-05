package com.donshell.testes.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donshell.testes.course.entities.Order;
import com.donshell.testes.course.repositories.OrderRepository;

@Service
public class OrderService {

	@Autowired
	private OrderRepository repository;
	
	
	public List<Order> findAll()
	{
		return repository.findAll();
	}
	public Order findByID(Long id)
	{
		Optional <Order> obj = repository.findById(id);
		return obj.get();
	}

}
