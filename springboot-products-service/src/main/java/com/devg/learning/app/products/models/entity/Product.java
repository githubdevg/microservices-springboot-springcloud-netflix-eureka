package com.devg.learning.app.products.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="produtct")
public class Product implements Serializable{
	
	private static final long serialVersionUID = 1285454306356845809L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private Double price;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	private Date createdAt;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return name;
	}
	public void setNombre(String nombre) {
		this.name = nombre;
	}
	public Double getPrecio() {
		return price;
	}
	public void setPrecio(Double precio) {
		this.price = precio;
	}
	public Date getCreateAt() {
		return createdAt;
	}
	public void setCreateAt(Date createAt) {
		this.createdAt = createAt;
	}

}
