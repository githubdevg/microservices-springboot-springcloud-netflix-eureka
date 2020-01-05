package com.devg.learning.app.items.service.impl;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.devg.learning.app.items.model.Item;
import com.devg.learning.app.items.model.Product;
import com.devg.learning.app.items.service.ItemsService;

@Service
public class ItemServiceImpl implements ItemsService {

	@Autowired
	private RestTemplate productsRestClient;

	@Override
	public List<Item> findAll() {
		List<Product> productList = Arrays
				.asList(productsRestClient.getForObject("http://localhost:8001/list", Product[].class));
		return productList.stream().map(product -> new Item(product, 1)).collect(Collectors.toList());
	}

	@Override
	public Item findById(Long id, Integer quantity) {
		Map<String, String> pathVariables = new HashMap<>();
		pathVariables.put("id", id.toString());
		Product product = productsRestClient.getForObject("http://localhost:8001/product/{id}", Product.class,
				pathVariables);
		return new Item(product, quantity);
	}

}
