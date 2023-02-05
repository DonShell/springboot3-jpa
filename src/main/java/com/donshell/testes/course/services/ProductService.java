package com.donshell.testes.course.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.donshell.testes.course.entities.Product;
import com.donshell.testes.course.repositories.ProductRepository;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	
	
	public List<Product> findAll()
	{
		return repository.findAll();
	}
	public Product findByID(Long id)
	{
		Optional <Product> obj = repository.findById(id);
		return obj.get();
	}
}
