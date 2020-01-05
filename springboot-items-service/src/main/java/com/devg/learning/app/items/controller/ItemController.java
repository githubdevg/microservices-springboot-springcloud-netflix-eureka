package com.devg.learning.app.items.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.devg.learning.app.items.model.Item;
import com.devg.learning.app.items.service.ItemsService;

@RestController
public class ItemController {

	@Autowired
	private ItemsService itemService;
	
	
	@GetMapping("/list")
	public List<Item> listItems() {
		return itemService.findAll();
	}
	
	@GetMapping("/product/{id}/quantity/{quantity}")
	public Item getProduct(@PathVariable Long id, @PathVariable Integer quantity) {
		return itemService.findById(id, quantity);
	}
	
}