package com.utils;

import java.io.FileWriter;
import java.time.LocalDate;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

import com.core.GroceryList;
import com.custom_exceptions.GroceryListException;

public class GroceryListValidator {
	
	static Scanner sc=new Scanner(System.in);
	
	//case 1 : add new task in the list
	public static void addNewItem(HashMap<String, GroceryList> groceryList) throws GroceryListException {
		
		System.out.println("Enter new item details : Item Name, Item price per quantity, Item stock, stock update date ");
		GroceryList listItem=new GroceryList(sc.next(),sc.nextDouble(), sc.nextDouble(),LocalDate.parse(sc.next()));
		
		// validation to check the duplicate item name, negative price and quantity
		if(groceryList.containsKey(listItem.getItemName())) 
			throw new GroceryListException("Duplicate item found : "+listItem.getItemName()+"\n Item not added in the list");
		else if(listItem.getPricePerUnit() < 0)
			throw new GroceryListException("Invalid input : price cannot be negative"+"\n Item not added in the list");
		else if(listItem.getStockQuantity() < 0)
			throw new GroceryListException("invalid input : stock quantity cannot be negative"+"\n Item not added in the list");
		else
			groceryList.put(listItem.getItemName(), listItem);
		
		System.out.println("New item added to list successfully !!!");
	}
	
	// to populate the map initially with some data
	public static void populateMapInitially(HashMap<String, GroceryList> groceryList) {
		
		groceryList.put("bread", new GroceryList("bread", 30, 25, LocalDate.parse("2024-03-12")));
		groceryList.put("biscuits", new GroceryList("biscuits", 50, 80, LocalDate.parse("2024-03-01")));
		groceryList.put("shampoo", new GroceryList("shampoo", 5, 100, LocalDate.parse("2024-01-01")));
		groceryList.put("soaps", new GroceryList("soaps", 30, 40, LocalDate.parse("2023-12-30")));
		groceryList.put("eggs", new GroceryList("eggs", 35, 10, LocalDate.parse("2024-03-28")));
	}
	
	
	//case 2 : update the stock quantity
	public static void updateItemStockQty(HashMap<String, GroceryList> groceryList) {
		
		System.out.println("Enter item name and new quantity : ");
		String itmName=sc.next();
		double newQuantity=sc.nextDouble();
		double prevQty=groceryList.get(itmName).getStockQuantity();
		
		groceryList.get(itmName).setStockQuantity(prevQty+newQuantity);
		groceryList.get(itmName).setStockUpdateTime(LocalDate.now());
		System.out.println("Stock quantity updated successfully !!! \n"+"Item Name : "+itmName+"\nNew Quantity :"+groceryList.get(itmName).getStockQuantity());
	}
	
	//case 3 : display list item details
	public static void displayGroceryListItems(HashMap<String, GroceryList> groceryList) {
		
		// tried to use functional programming approach: HashMap->collection->stream->higher order function to print each item from the list
		groceryList.values().stream().forEach(item->System.out.println(item));
	}
	
	//case 4: remove all empty stock items
	public static void removeStockZeroItems(HashMap<String, GroceryList> groceryList) {
		
		// used functional programming approach
		groceryList.values().removeIf(i->i.getStockQuantity()==0 || i.getStockQuantity()==0.0);
		
		System.out.println("Removed items with 0 stock quantity !!!");
	}
	
	//case 5 : display the items updated in last 3 days
	public static void displayItemsUpdatedInLast3days(HashMap<String, GroceryList> groceryList) {
		
		System.out.println("Displaying items updated in last 3 days");
		LocalDate threeDaysAgo=LocalDate.now().minusDays(3);
		
		// used functional programming approach : HashMap->collection->stream->filter->print item details
		groceryList.values()
		.stream()
		.filter(item->item.getStockUpdateTime().isAfter(threeDaysAgo))
		.forEach(i->{
			System.out.println(" Item Name : "+i.getItemName()
			+"\n Item stock quantity : "+i.getStockQuantity()
			+"\n Item last updated date : "+i.getStockUpdateTime());
		});
	}
	
	//case 6 : sort the list items according to stock quantity in descending order(higher stock qty -> lower stock qty)
	public static void sortListByStockQuantity(HashMap<String, GroceryList> groceryList) {
		
		System.out.println("Sorted List of Items as per Quantity in descending order");
		
		//used functional programming approach : HashMap->collection->stream->sorted->print the items
		groceryList.values()
		.stream()
		.sorted((item1,item2)-> Double.compare(item2.getStockQuantity(), item1.getStockQuantity()))
		.forEach(item->{
			System.out.println(item.getItemName()+" -> "+item.getStockQuantity());
		});
	}
	
	//case 7 : export grocery list to text file
	public static void exportToTextFile(HashMap<String, GroceryList> groceryList) {
		try(FileWriter writer=new FileWriter("D:\\CDAC\\Java_Pract\\GroceryList Manager-HashMap\\io operation output\\grocery_list.txt")) {
			
			writer.write("***** Grocery Items ***** \n");
			for(GroceryList items: groceryList.values()) {
				writer.write("Name : "+items.getItemName()+" | Price : "+items.getPricePerUnit()+" | Quantity : "+items.getStockQuantity()+"\n");
			}
			System.out.println("Grocery List exported to grocery_list.txt file successfully !!!");
		} catch (Exception e) {
			System.out.println("Error exporting grocery list to text file : "+e.getMessage());
		}
	}
}
