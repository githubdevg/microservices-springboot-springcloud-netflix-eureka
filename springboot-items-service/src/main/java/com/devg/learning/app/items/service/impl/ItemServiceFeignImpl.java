package com.devg.learning.app.items.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import com.devg.learning.app.items.client.ProductsServiceFeignClient;
import com.devg.learning.app.items.model.Item;
import com.devg.learning.app.items.service.ItemService;


@Service("itemsServiceFeignImpl")
@Primary
public class ItemServiceFeignImpl implements ItemService{
	
	@Autowired
	private ProductsServiceFeignClient productsFeignClient;

	@Override
	public List<Item> findAll() {
		return productsFeignClient.listProducts().stream().map(p -> new Item(p, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		return new Item(productsFeignClient.getProduct(id), quantity);
	}

}
