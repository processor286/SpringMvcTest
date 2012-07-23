package com.harpingon.service;

import java.util.List;

import com.harpingon.domain.Product;
import com.harpingon.repository.ProductDao;

public class SimpleProductManager implements ProductManager {

	/**
	 *  
	 */
	private static final long serialVersionUID = 1L;
	// private List<Product> products;
	private ProductDao productDao;

	public List<Product> getProducts() {
		// return products;
		return productDao.getProductList();
	}

	public void increasePrice(int percentage) {
		List<Product> products = productDao.getProductList();
		if (products != null) {
			for (Product product : products) {
				double newPrice = product.getPrice().doubleValue()
						* (100 + percentage) / 100;
				product.setPrice(newPrice);
			}
		}
	}

	public void setProductDao(ProductDao productDao) {
		this.productDao = productDao;
	}

}
