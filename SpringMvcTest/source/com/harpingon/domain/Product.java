package com.harpingon.domain;

import java.io.Serializable;

public class Product implements Serializable {

	/**
	 * 
	 */
	private int id;
	private static final long serialVersionUID = 1L;
	private String description;
	private Integer price;
	private String displayPrice;


	public void setId(int i) {
		id = i;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPrice() {
		Double xprice = (double)price/100;
		this.displayPrice = xprice.toString();		
		return price;
	}
	
	public void setPrice(Integer price) {
		Double xprice = (double)price/100;
		this.displayPrice = xprice.toString();
		this.price = price;
	}

	public String getDisplayPrice() {
		Double xprice = (double)price/100;
		this.displayPrice = xprice.toString();		
		return displayPrice;
	}
	
	public void setDisplayPrice(String displayPrice) {
		Double xprice = (double)price/100;
		this.displayPrice = xprice.toString();
	}
	
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Description: " + description + ";");
		buffer.append("Price: " + price/100);
		return buffer.toString();
	}
}
