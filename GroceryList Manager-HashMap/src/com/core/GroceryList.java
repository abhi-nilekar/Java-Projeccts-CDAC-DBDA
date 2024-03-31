package com.core;

import java.time.LocalDate;

public class GroceryList {
	
	private String itemName;
	private double pricePerUnit;
	private double stockQuantity;
	private LocalDate stockUpdateTime;
	
	//constructor
	public GroceryList(String itemName, double pricePerUnit, double stockQuantity, LocalDate stockUpdateTime) {
		super();
		this.itemName = itemName;
		this.pricePerUnit = pricePerUnit;
		this.stockQuantity = stockQuantity;
		this.stockUpdateTime = stockUpdateTime;
	}
	
	//getters and setters for working on atrributes
	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getPricePerUnit() {
		return pricePerUnit;
	}

	public void setPricePerUnit(double pricePerUnit) {
		this.pricePerUnit = pricePerUnit;
	}

	public double getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(double stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public LocalDate getStockUpdateTime() {
		return stockUpdateTime;
	}

	public void setStockUpdateTime(LocalDate stockUpdateTime) {
		this.stockUpdateTime = stockUpdateTime;
	}

	@Override
	public String toString() {
		return "GroceryList [itemName=" + itemName + ", pricePerUnit=" + pricePerUnit + ", stockQuantity="
				+ stockQuantity + ", stockUpdateTime=" + stockUpdateTime + "]";
	}
	
}
