package com.validator;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.core.GroceryList;
import com.custom_exceptions.GroceryItemException;

public class GroceryItemValidator {
	
	public static GroceryList validateInputs(String itemName, double itemPriceperUnit, double qtyStock, String stockUpdateDnT, ArrayList<GroceryList> groceryList) throws GroceryItemException {
		
		checkDuplicateItems(itemName, groceryList);
		
		//UpdateItemQuantity(itemName, qtyStock, groceryList);
		
		
		return new GroceryList(itemName, itemPriceperUnit, qtyStock,LocalDate.parse(stockUpdateDnT));
	}
	
	//populate the list with some initial data
//	public static void populateGroceryList(ArrayList glist) {
//		glist.add("milk", 10, 100, LocalDate.parse("2023-12-12"));
//		glist.
//	}
	
	// to make sure we have unique items in the list
	public static void checkDuplicateItems(String itemName, ArrayList<GroceryList> grocryList) throws GroceryItemException {
		GroceryList grcList=new GroceryList(itemName);
		if(grocryList.contains(grcList)) {
			throw new GroceryItemException("Item already exist in the list !!!");
		}
		else System.out.println("New Grocery item added to the list successfully !!!");
	}
	
	// for case 2 : update the item in grocery list
	public static void UpdateItemQuantity(String itemName,double updatedQty, ArrayList<GroceryList> grList) {
		GroceryList glist=new GroceryList(itemName);
		for(GroceryList glist1: grList ) {
			if(glist1.equals(glist)) {
				//double currQty=glist.getQtyStock();
				glist1.setQtyStock(glist1.getQtyStock()+updatedQty);
				glist1.setStockUpdateDnT(LocalDate.now());
				System.out.println("Item updated successfully !!!");
				System.out.println("New quantity of item : " + itemName + " = "+glist1.getQtyStock());
			}
		}
	}
	
	//case 4 : remove items with 0 stock
	public static void removeEmptyStock(List<GroceryList> glist) {
		for(GroceryList grcList1: glist) {
			if(grcList1.getQtyStock()==0.0) {
				glist.remove(grcList1);
				System.out.println("Item removed successfully !!!");
			} else System.out.println("Item not removed !!!");
		}
	}

	
	//for case 5 : to check and print the items updated in last 3 days
	public static void checkUpdatedDate(List<GroceryList> glist){
		LocalDate todaysDate=LocalDate.now();
		for(GroceryList grclist: glist) {
			LocalDate lastUpdatedDate=grclist.getStockUpdateDnT();
			long daysBetween=ChronoUnit.DAYS.between(lastUpdatedDate, todaysDate);
			if(daysBetween <= 3)
				System.out.println(grclist);
		}
	}
}
