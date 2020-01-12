package com.devg.learning.app.items.service;

import java.util.List;

import com.devg.learning.app.items.model.Item;

public interface ItemService {
	
	List<Item> findAll();	
	Item findById(Long id, Integer quantity);

}
