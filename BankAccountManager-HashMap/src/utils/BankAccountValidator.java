package utils;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;
import java.io.*;

import core.AccountType;
import core.BankAccount;
import custom_exceptions.BankAccountException;


public class BankAccountValidator {

	static Scanner sc=new Scanner(System.in);
	static double MIN_BALANCE=2000;
	
	//case 1 : adding new account to the HashMap		
	public static void addNewAccount(HashMap<Integer, BankAccount> bankAccount) throws BankAccountException {
		
		System.out.println("Enter account details : Account Number, Name, balance, account type, account date");
		
		BankAccount bnkAct=new BankAccount(sc.nextInt(), sc.next(), sc.nextDouble(), AccountType.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
		
		if(bankAccount.containsKey(bnkAct.getAccountNumber()))
			throw new BankAccountException("Account already exist !!!!");
			
		bankAccount.put(bnkAct.getAccountNumber(), bnkAct);
		System.out.println("Account created successfully!!!");
	}
	
	// method to pre-populate some initial values in map
	public static void populateMap(HashMap<Integer, BankAccount> bankAccount) {
		
		bankAccount.put(123, new BankAccount(123, "john",10000.0,AccountType.SAVINGS,LocalDate.parse("2023-12-12")));
		bankAccount.put(234, new BankAccount(234, "john",910000.0,AccountType.CURRENT,LocalDate.parse("2024-01-01")));
		bankAccount.put(345, new BankAccount(345, "john",110000.0,AccountType.DEMAT,LocalDate.parse("2024-02-12")));
		bankAccount.put(456, new BankAccount(456, "john",80000.0,AccountType.LOAN,LocalDate.parse("2024-01-12")));
		bankAccount.put(567, new BankAccount(567, "john",500.0,AccountType.FD,LocalDate.parse("2024-03-31")));
	}
	
	//case 2 : display all accounts from the HashMap
	public static void displayAccounts(HashMap<Integer, BankAccount> bankAccount) {
		
		// HashMap->collection->stream->forEach
		bankAccount.values().stream().forEach(b -> System.out.println(b)); 
	}
	
	//case 3 : withdraw funds from the account
	public static void withdrawFunds(HashMap<Integer, BankAccount> bankAccount) throws BankAccountException {
		
		System.out.println("Enter account number and amount to withdraw");
		int actNum =sc.nextInt(); 	//123
		double withdrawAmount=sc.nextDouble();	//5000
		
		double currentBalance=bankAccount.get(actNum).getBalance(); //	10000
		
		// validation to check minimum balance
		if(currentBalance<MIN_BALANCE) {
		  throw new BankAccountException("Insufficient funds in your account !!!");
		} else bankAccount.get(actNum).setBalance(currentBalance-withdrawAmount); // 10000-5000
		
		System.out.println("New balance :"+ bankAccount.get(actNum).getBalance());
	}
	
	//case 4 : to transfer funds
	public static void transferFunds(HashMap<Integer, BankAccount> bankAccount) {
		
		int senderAccountNumber; 
		int receiverAccountNumber;
		
		System.out.println("Enter sender and receivers bank account number : ");
		senderAccountNumber=sc.nextInt();
		receiverAccountNumber=sc.nextInt();
		System.out.println("Enter transfer amount : ");
		double transferAmount=sc.nextDouble();
		
		// validation to check minimum balance condition
		if(bankAccount.get(senderAccountNumber).getBalance() > MIN_BALANCE) {
		bankAccount.get(senderAccountNumber).setBalance(bankAccount.get(senderAccountNumber).getBalance()-transferAmount);
		}  else System.out.println("Insufficient balance in senders account");
		
		bankAccount.get(receiverAccountNumber).setBalance(bankAccount.get(receiverAccountNumber).getBalance()+transferAmount);
		
		System.out.println("Transfer successful !!!");
	}
	
	//case 5 : to delete the account from the HashMap
	public static void deleteAccount(HashMap<Integer, BankAccount> bankAccount) {
		
		System.out.println("Enter account number to delete : ");
		int actToRemove=sc.nextInt();
		//functional programming
		//Hasmap->collection->remove
		
		//bankAccount.remove(actToRemove); => this method worked
		
		//using functional programming approach 
		bankAccount.values().removeIf(i->i.getAccountNumber()==actToRemove);
		System.out.println("Account removed !!!"); // this method also worked
		
//		if(bankAccount.containsKey(actToRemove)) {
//			bankAccount.remove(actToRemove);
//			System.out.println("Account removed !!!!");
//		} else System.out.println("Account not found !!!"); //this method also worked
	}
	
	//case 6 : sort accounts by balance in descending order
	public static void sortAccounts(HashMap<Integer, BankAccount> bankAccount) {
		
		//using functional programming approach 
		bankAccount.values()
		.stream()
		.sorted((act1,act2)-> Double.compare(act2.getBalance(), act1.getBalance()))
		.forEach(i-> {
			System.out.println(i.getAccountNumber()+"->"+i.getBalance());
		});
	}
	
	// case 7 : performing serialization of bankAccount HashMap values
	public static void serializeMapVales(HashMap<Integer, BankAccount> bankAccount, String fileName) {
		try(ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(fileName)) ) {
			oos.writeObject(bankAccount);
			System.out.println("Serialization Successful !!!");
		} catch (Exception e) {
			System.out.println("Serialization failed : "+e.getMessage());
		}
	}

	// case 8 : performing deserialization of bankAccount HashMap values
	public static HashMap<Integer, BankAccount> deSerializeMapValues(String fileName) {
		
		HashMap<Integer, BankAccount> deser= new HashMap<Integer, BankAccount>();
		
		try(ObjectInputStream oips=new ObjectInputStream(new FileInputStream(fileName))) {
			deser= (HashMap<Integer, BankAccount>) oips.readObject();
			System.out.println("Deserialization Successful !!!");
		} catch (Exception e) {
			System.out.println("Deserialization failed : "+e.getMessage());
		}
		return deser;
	}

}
