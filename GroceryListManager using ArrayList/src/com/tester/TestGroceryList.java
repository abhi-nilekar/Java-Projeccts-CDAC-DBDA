package com.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.core.GroceryList;
import com.validator.GroceryItemValidator;

public class TestGroceryList {

	public static void main(String[] args) {

		List<GroceryList> groceryList = new ArrayList<>();
		boolean exit = false;
		try (Scanner sc = new Scanner(System.in)) {
			while (!exit) {
				try {
					System.out.println("Enter your choice : \n" + "1. Add new item to the list : \n"
							+ "2. Update grocery item stock : \n" + "3. Display grocery items and their details : \n"
							+ "4. Remove all empty stock items(Having quantity zero) : \n"
							+ "5. Display all products with stock updated in last 3 days. : \n" + "0. Exit : \n");

					// switch case to perform actions as per user input
					switch (sc.nextInt()) {
					case 1: {
						System.out.println("Enter item details : name, price per unit, quantity and last update time");
						GroceryList additem = GroceryItemValidator.validateInputs(sc.next(), sc.nextDouble(),
								sc.nextDouble(), sc.next(), (ArrayList<GroceryList>) groceryList);
						groceryList.add(additem);
						break;
					}
					case 2: {
						System.out.println("Enter the item name and updated stock : ");
						GroceryItemValidator.UpdateItemQuantity(sc.next(), sc.nextDouble(), (ArrayList<GroceryList>) groceryList);
						break;
					}
					case 3: {
						System.out.println("All grocery items : ");
						for (GroceryList glist : groceryList) {
							System.out.println(glist);
						}
						break;
					}
					case 4: {
						//System.out.println("Removing following empty stock items : ");
						GroceryItemValidator.removeEmptyStock(groceryList);
						break;
					}
					case 5: {
						System.out.println("Displaying all products updated in last 3 days : ");
						GroceryItemValidator.checkUpdatedDate(groceryList);
						break;
					}
					case 6: {
						break;
					}
					case 0:
						exit=true;
						System.out.println("Exiting the program bye !!!");
						break;
					}
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
