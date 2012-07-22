package com.harpingon.service;

import java.io.Serializable;
import com.harpingon.domain.Product;
import java.util.List;

public interface ProductManager extends Serializable {

	public void increasePrice(int percentage);
    
    public List<Product> getProducts();

}
