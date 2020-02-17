package com.devg.learning.app.products.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devg.learning.app.products.entity.Product;
import com.devg.learning.app.products.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	private Environment env;

	@Autowired
	private ProductService productService;
	
	@Value("${server.port}")
	private Integer port;

	@GetMapping("/products")
	public List<Product> listProducts() {
		return productService.findAll().stream().map(product -> {
			//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
			product.setPort(port);
			return product;
		}).collect(Collectors.toList());

	}

	@GetMapping("/products/{id}")
	public Product getProduct(@PathVariable Long id) {
		Product product = productService.findById(id);
		//product.setPort(Integer.parseInt(env.getProperty("local.server.port")));
		
		try {
			Thread.sleep(2000L);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		product.setPort(port);
		return product;
	}

}
