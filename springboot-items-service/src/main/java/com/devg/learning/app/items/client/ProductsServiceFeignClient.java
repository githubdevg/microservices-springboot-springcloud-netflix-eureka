package com.devg.learning.app.items.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.devg.learning.app.items.model.Product;


//@FeignClient(name = "products-service", url = "localhost:8001")
@FeignClient(name = "products-service")
public interface ProductsServiceFeignClient {
	
	
	@GetMapping("/api/products")
	public List<Product> listProducts();
		
	@GetMapping("/api/products/{id}")
	public Product getProduct(@PathVariable Long id);
	

}
