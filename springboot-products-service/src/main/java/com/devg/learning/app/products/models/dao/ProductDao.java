package com.devg.learning.app.products.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.devg.learning.app.products.models.entity.Product;

public interface ProductDao extends CrudRepository<Product, Long> {

}
