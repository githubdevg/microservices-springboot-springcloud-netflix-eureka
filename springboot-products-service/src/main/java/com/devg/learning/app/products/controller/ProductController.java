package com.devg.learning.app.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devg.learning.app.products.entity.Product;
import com.devg.learning.app.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private ProductService productoService;
	
	
	@GetMapping("/list")
	public List<Product> listProducts() {
		
		return productoService.findAll();
		
	}
	
	@GetMapping("/product/{id}")
	public Product getProduct(@PathVariable Long id) {
		return productoService.findById(id);
	}
	
	
}
