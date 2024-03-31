package com.custom_exceptions;

@SuppressWarnings("serial")
public class GroceryListException extends Exception {

	public GroceryListException(String message) {
		super(message);
	}
}
