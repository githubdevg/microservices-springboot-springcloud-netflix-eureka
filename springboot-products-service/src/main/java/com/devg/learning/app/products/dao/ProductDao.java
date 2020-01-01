package com.devg.learning.app.products.dao;

import org.springframework.data.repository.CrudRepository;

import com.devg.learning.app.products.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}
