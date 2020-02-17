package com.devg.learning.app.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devg.learning.app.items.model.Item;
import com.devg.learning.app.items.model.Product;
import com.devg.learning.app.items.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
public class ItemController {

//	@Autowired
//	@Qualifier("itemsServiceRestClientImpl")
//	private ItemsService itemService;
	
	@Autowired
	@Qualifier("itemsServiceFeignImpl")
	private ItemService itemService;
	
	
	@GetMapping("/items")
	public List<Item> listItems() {
		return itemService.findAll();
	}
	
	
	@HystrixCommand(fallbackMethod = "getDefaultProduct")
	@GetMapping("/items/{id}/quantity/{quantity}")
	public Item getProduct(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
	}
	
	
	public Item getDefaultProduct(Long id, Integer quantity) {
		Item item = new Item();
		Product product = new Product();		
		product.setId(id);;
		product.setName("Default");
		product.setPrice(0.0);
		product.setPort(0);
		item.setProduct(product);
		item.setQuantity(0);
		
		return item;
	}
}
