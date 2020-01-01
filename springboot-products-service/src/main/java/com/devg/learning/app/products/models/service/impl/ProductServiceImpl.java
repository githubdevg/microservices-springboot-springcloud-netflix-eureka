package com.devg.learning.app.products.models.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devg.learning.app.products.models.dao.ProductDao;
import com.devg.learning.app.products.models.entity.Product;
import com.devg.learning.app.products.models.service.ProductService;


@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productoDao;
	
	@Override
	public List<Product> findAll() {
		return (List<Product>) productoDao.findAll();
	}

	@Override
	public Product findById(Long id) {
		return productoDao.findById(id).orElse(null);
	}

}
