package com.devg.learning.app.items.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devg.learning.app.items.model.Item;
import com.devg.learning.app.items.model.Product;
import com.devg.learning.app.items.service.ItemService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RefreshScope
public class ItemController {

//	@Autowired
//	@Qualifier("itemsServiceRestClientImpl")
//	private ItemsService itemService;
	
	@Autowired
	@Qualifier("itemsServiceFeignImpl")
	private ItemService itemService;

	@Autowired
	private Environment env;
	
	@Value("${config.description}")
	private String environmentDescription;
	
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
	
	@GetMapping("/config")
	public ResponseEntity<?> getConfiguration() {
		Map<String, Object> response = new HashMap<>();
		response.put("environmentDescription", environmentDescription);
		
		if(env.getActiveProfiles().length>0 && env.getActiveProfiles()[0].equals("dev")) {
			String devToken = env.getProperty("config.dev.authentication.token", "Default");
			response.put("devToken", devToken);
		}
		
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
}
