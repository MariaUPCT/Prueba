package com.example;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "productBean")
@RequestScoped
public class ProductBean implements Serializable {

	private List<Product> products;

	public ProductBean() {
		// lazy init
	}

	public ProductBean(List<Product> products) {
		this.products = products;
	}

	public List<Product> getProducts() {
		if (this.products == null) {
			this.products = Arrays.asList(
					new Product(1L, "Silla", 49.99),
					new Product(2L, "Mesa", 79.99),
					new Product(3L, "Lampara", 49.99)
			);
		}
		return this.products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
}
