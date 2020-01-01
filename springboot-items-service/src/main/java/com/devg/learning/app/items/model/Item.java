package com.devg.learning.app.items.model;

public class Item {

	private Product product;
	private Integer quantity;

	public Item() {
		super();
	}

	public Item(Product product, Integer total) {
		super();
		this.product = product;
		this.quantity = total;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	public Double getTotal() {
		return product.getPrice() * this.getQuantity().doubleValue();
	}

}
