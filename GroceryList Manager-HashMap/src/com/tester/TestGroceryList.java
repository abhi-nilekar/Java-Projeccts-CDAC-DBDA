package com.tester;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import com.core.GroceryList;
import com.utils.GroceryListValidator;

public class TestGroceryList {

	public static void main(String[] args) {
		
		// creating a HashMap to store the grocery list items
		HashMap<String, GroceryList> groceryList= new HashMap<String, GroceryList>();
		
		try(Scanner sc=new Scanner(System.in)) {
			
			boolean exit=false;
			
			while(!exit) {
				System.out.println("\n \n ***** GroceryList Manager Menu *****");
				System.out.println("Enter your choice: \n"
						+ "1. Add a new grocery item \n"
						+ "2. Update the quantity of item in stock \n"
						+ "3. Display the list of grocery items (name, prices, quantities) \n"
						+ "4. Remove all empty stock items (quantity==0) \n"
						+ "5. Display all products for which stock updated (quantity changed) in last 3 days. \n"
						+ "6. Sort the items according to stock quantity in descending order \n"
						+ "7. Export the GroceryList in .txt file \n"
						+ "0. Exit");
				
				// populating map initially with some data
				GroceryListValidator.populateMapInitially(groceryList);
				
				try {
					 switch(sc.nextInt()) {
					 
					 case 1:
						 GroceryListValidator.addNewItem(groceryList);
						 break;
					 case 2:
						 GroceryListValidator.updateItemStockQty(groceryList);
						 break;
					 case 3:
						 GroceryListValidator.displayGroceryListItems(groceryList);
						 break;
					 case 4:
						 GroceryListValidator.removeStockZeroItems(groceryList);
						 break;
					 case 5:
						 GroceryListValidator.displayItemsUpdatedInLast3days(groceryList);
						 break;
					 case 6:
						 GroceryListValidator.sortListByStockQuantity(groceryList);
						 break;
					 case 7:
						 GroceryListValidator.exportToTextFile(groceryList);
						 break;
					 case 0:
						 System.out.println("Exiting the program !!!");
						 exit=true;
						 break;
					default:
						throw new IllegalArgumentException("Invalid input : please enter your choice from the given menu only");
					}	
				} catch (Exception e) {
					System.out.println("Error : "+e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println("Error : "+e.getMessage());
		}

	}

}
