package com.devg.learning.app.products.service;

import java.util.List;

import com.devg.learning.app.products.entity.Product;

public interface ProductService {
	
	List<Product> findAll();
	
	Product findById(Long id);

}
