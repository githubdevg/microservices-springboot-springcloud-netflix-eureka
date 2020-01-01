package com.devg.learning.app.products.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devg.learning.app.products.dao.ProductDao;
import com.devg.learning.app.products.entity.Product;
import com.devg.learning.app.products.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) productDao.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productDao.findById(id).orElse(null);
	}

}
