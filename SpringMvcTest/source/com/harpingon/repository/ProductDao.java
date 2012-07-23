package com.harpingon.repository;

import java.util.List;

import com.harpingon.domain.Product;

public interface ProductDao {
	public List<Product> getProductList();

	public void saveProduct(Product prod);
}
