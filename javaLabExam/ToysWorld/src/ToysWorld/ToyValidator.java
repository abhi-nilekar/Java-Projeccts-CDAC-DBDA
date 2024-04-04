package ToysWorld;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

public class ToyValidator {

	static Scanner sc=new Scanner(System.in);
	
	//case 1: adding a new toy
	public static void addNewToy(HashMap<String,PetsToy> petToy) throws PetToyException {
		
		System.out.println("Enter new toy details : Name, brand, target species, material, stock quantity, price");
		
		PetsToy newToy=new PetsToy(sc.next(), sc.next(), sc.next(), sc.next(), sc.nextDouble(), LocalDate.now(), LocalDate.now(), sc.nextDouble());
		
		
		//validating => 1) duplicate items 2) negative stock quantity 3) negative stock price
		if(petToy.containsKey(newToy.getToyId()))
			throw new PetToyException("Toy already present !!!");
		else if(newToy.getStockQuantity()<0)
			throw new PetToyException("Stock quantity cannot be less than 0");
		else if(newToy.getPrice()<0)
			throw new PetToyException("Toy price cannot be less than 0/cannot be negative");
		else petToy.put(newToy.getToyId(), newToy);
		
		System.out.println("New toy added successfully !!!");
		
	}
	
	//case 2: updating the stock
	public static void updateStock(HashMap<String, PetsToy> petToy) {
		
		System.out.println("Enter toy id and name :");
		String toyId=sc.next();
		String toyName=sc.next();
		System.out.println("Enter new stock quantity : ");
		double newStockQuantity=sc.nextDouble();
		
		double previousStockQuantity=petToy.get(toyId).getStockQuantity(); //fetching the previous stock quantity of the toy
		double newUpdatedStockQuantity = previousStockQuantity+newStockQuantity;  //calculating the new stock quantity
		
		//setting the new stock updated quantity
		petToy.get(toyId).setStockQuantity(newUpdatedStockQuantity);    
		System.out.println("Stock quantity updated for the toy : "+ petToy.get(toyId).getName());
		System.out.println("New Stock quantity : " + petToy.get(toyId).getStockQuantity());
		
		//updating the stock update date as one operation is performed here
		petToy.get(toyId).setStockUpdateDate(LocalDate.now());
	}

	//case 3 : setting the discount of 15% on toys which are 1 year old 
	public static void setDiscount(HashMap<String, PetsToy> petToy) {
		
		//creating variable to find 1 year old product
		LocalDate oneYearOld=LocalDate.now().minusYears(1);
		
		petToy.values()
		.stream()
		.filter(i->i.getStockUpdateDate().isBefore(oneYearOld))
		.forEach(t->{
			t.setDiscounts(t.getPrice()*0.15); //setting default 0.0 discount to 15% discount
			System.out.println("Discount applied successfully");
			t.setPrice(t.getPrice()-t.getDiscounts()); //setting discounted price
			System.out.println("New discounted price : "+t.getPrice());
		});
		
	}

	//case 4: removing the toys which are never sold since it listed in last 12 months
	public static void removeOldToy(HashMap<String, PetsToy> petToy) {
		
		//creating a variable to find last 1 year
		LocalDate oneYearOld=LocalDate.now().minusMonths(12);
		
		//removing the item which never sold once listed in last 12 months
		petToy.values().removeIf(i->i.getStockUpdateDate().isBefore(oneYearOld));
		System.out.println("Toy removed !!!");
		
	}

	//prepolulating some values to test case 3 and 4
	public static void populateMap(HashMap<String, PetsToy> petToy) {
		
		petToy.put("id1", new PetsToy("toy1", "brand1", "dog", "cotton", 50, LocalDate.parse("2023-01-01"), LocalDate.parse("2023-01-01"), 100)); //hardcoding stock list and update date to test 3rd case
		petToy.put("id2", new PetsToy("toy2", "brand2", "cat", "rubber", 80, LocalDate.parse("2023-02-02"), LocalDate.parse("2023-02-02"), 149)); //hardcoding stock list and update date to test 4th case
	}

}
