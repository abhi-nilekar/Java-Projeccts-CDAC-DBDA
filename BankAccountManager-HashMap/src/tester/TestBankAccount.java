package tester;

import java.util.HashMap;
import java.util.Scanner;

import core.BankAccount;
import utils.BankAccountValidator;

public class TestBankAccount {

	public static void main(String[] args) {
	
		//declaring HashMap to store the values
		HashMap<Integer, BankAccount> bankAccount= new HashMap<>();
		boolean exit=false;

		// pre-populating map values in some initial data
		BankAccountValidator.populateMap(bankAccount);
		
		try(Scanner sc=new Scanner(System.in)) {
			while(!exit) {
				
				System.out.println("Enter your choice \n"
						+ "1. Create new Bank account \n"
						+ "2. Display all bank accounts \n"
						+ "3. Withdraw funds \n"
						+ "4. Transfer funds \n"
						+ "5. Delete account \n"
						+ "6. Sort accounts according to balance \n"
						+ "7. Perform Serialization of map values\n"
						+ "8. Perform Deserialization map values \n");
				
				try {
					
					switch (sc.nextInt()) {
					case 1: 
						BankAccountValidator.addNewAccount(bankAccount);	
						break;
					
					case 2:
						BankAccountValidator.displayAccounts(bankAccount);
						break;
					
					case 3:
						BankAccountValidator.withdrawFunds(bankAccount);
						break;
					
					case 4:
						BankAccountValidator.transferFunds(bankAccount);	
						break;
					
					case 5:
						BankAccountValidator.deleteAccount(bankAccount);
						break;
					case 6:
						BankAccountValidator.sortAccounts(bankAccount);
						break;
					case 7 :
						BankAccountValidator.serializeMapVales(bankAccount, "bankAccounts.ser");
						break;
					case 8:
						HashMap<Integer, BankAccount> deserializedBankAccounts=BankAccountValidator.deSerializeMapValues("bankAccounts.ser");
						deserializedBankAccounts.values().stream().forEach(i->System.out.println(i));
						break;
					
					default:
						throw new IllegalArgumentException("Unexpected value: ");
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
