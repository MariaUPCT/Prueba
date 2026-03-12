package com.example;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "productBean")
@RequestScoped
public class ProductBean implements Serializable {

	private List<Product> products;
	@ManagedProperty(value = "#{productDAO}")
	private ProductDAO productDAO;
	
	public ProductBean() {
		// lazy init
	}

	public ProductBean(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		if (this.products == null) {
			this.products = Arrays.asList(
					new Product(1L, "Silla", 49.99, new Date(), LocalDate.now(), LocalDateTime.now()),
					new Product(2L, "Mesa", 99.99, new Date(), LocalDate.now(), LocalDateTime.now()),
					new Product(3L, "Lampara", 39.99, new Date(), LocalDate.now(), LocalDateTime.now())
			);
		}
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public void init() {
		this.products = this.productDAO.findAll();
	}

	public void setProductDAO(ProductDAO productDAO) {
		this.productDAO = productDAO;
	}
	
}
