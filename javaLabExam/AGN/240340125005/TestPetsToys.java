package ToysWorld;

import java.util.HashMap;
import java.util.Scanner;

public class TestPetsToys {

	public static void main(String[] args) {
		
		//declaring a HashMap to store the toys
		HashMap<String, PetsToy> petsToy= new HashMap<String, PetsToy>();
		boolean exit=false;
		
		try(Scanner sc=new Scanner(System.in)) {
			
			//prepopulating some values to test case 3 and 4 => because the user added toy will have listing and update as as now()
			ToyValidator.populateMap(petsToy);
			
			while(!exit) {
				
				System.out.println("*** ToysWorld Menu *** \n");
				System.out.println("Enter your choice \n"
						+ "1. Add new Toy \n"
						+ "2. Update stock of a toy \n"
						+ "3. Set 15% discount on 1 year old toys \n"
						+ "4. Remove toys which are never sold in last 12 months \n"
						+ "5. Exit \n"
						+ "6. Display all toys details"); //adding this case just to test the code
				try {
					switch (sc.nextInt()) {
					case 1:
						ToyValidator.addNewToy(petsToy);
						break;
					case 2: 
						ToyValidator.updateStock(petsToy);
						break;
					case 3: 
						ToyValidator.setDiscount(petsToy);
						break;
					case 4: 
						ToyValidator.removeOldToy(petsToy);
						break;
					case 5: 
						System.out.println("Exiting the program !!!");
						exit=true;
						break;
					case 6: //display all => adding this case just to test the code
						petsToy.values().stream().forEach(i->System.out.println(i));
						break;
					default:
						break;
					}
					
				} catch (Exception e) {
					System.out.println("Error : "+e.getMessage());
				}
			}
			
		} catch (Exception e) {
			System.out.println("Error : "+ e.getMessage());
		} 

	}

}
