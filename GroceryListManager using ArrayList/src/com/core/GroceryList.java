/**
 * 
 */
package com.core;

import java.time.LocalDate;
import java.util.Objects;

/**
 * Abhishek Nilekar
 */
public class GroceryList {
	
	//data members or attributes
	private String itemName;
	private double itemPriceperUnit;
	private double qtyStock;
	private LocalDate stockUpdateDnT;
	
	//constructor
	public GroceryList(String itemName, double itemPriceperUnit, double qtyStock, LocalDate stockUpdateDnT) {
		super();
		this.itemName = itemName;
		this.itemPriceperUnit = itemPriceperUnit;
		this.qtyStock = qtyStock;
		this.stockUpdateDnT = stockUpdateDnT;
	}

	//overloading the constructor
	public GroceryList(String itemName2) {
		super();
		this.itemName=itemName2;
	}

	public GroceryList(double qty) {
		super();
		this.qtyStock=qty;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public double getItemPriceperUnit() {
		return itemPriceperUnit;
	}

	public void setItemPriceperUnit(double itemPriceperUnit) {
		this.itemPriceperUnit = itemPriceperUnit;
	}

	public double getQtyStock() {
		return qtyStock;
	}

	public void setQtyStock(double qtyStock) {
		this.qtyStock = qtyStock;
	}

	public LocalDate getStockUpdateDnT() {
		return stockUpdateDnT;
	}

	public void setStockUpdateDnT(LocalDate stockUpdateDnT) {
		this.stockUpdateDnT = stockUpdateDnT;
	}

	// to display all the items in the list
	@Override
	public String toString() {
		return "GroceryList [itemName=" + itemName + ", itemPriceperUnit=" + itemPriceperUnit + ", qtyStock=" + qtyStock
				+ ", stockUpdateDnT=" + stockUpdateDnT + "]";
	}

	// for checking duplicate names
	@Override
	public boolean equals(Object obj) {
	if(obj instanceof GroceryList) {
		GroceryList grcList=(GroceryList)obj;
		return itemName.equals(grcList.itemName);
	}
	return false;
	}
	
}
