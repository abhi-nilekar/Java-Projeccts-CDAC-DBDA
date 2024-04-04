package ToysWorld;

import java.time.LocalDate;
import java.util.UUID;

public class PetsToy {

	
	private String toyId;
	private String name;
	private String brand;
	private String targetSpecies;
	private String material;
	private double stockQuantity;
	private LocalDate stockListingDate;
	private LocalDate stockUpdateDate;
	private double price;
	private double discounts;
	
	//constructors 
	public PetsToy(String name, String brand, String targetSpecies, String material, double stockQuantity,
			LocalDate stockListingDate, LocalDate stockUpdateDate, double price) {
		super();
		this.toyId = UUID.randomUUID().toString().substring(0, 5); //generates unique id for each new toy
		this.name = name;
		this.brand = brand;
		this.targetSpecies = targetSpecies;
		this.material = material;
		this.stockQuantity = stockQuantity;
		this.stockListingDate = stockListingDate;
		this.stockUpdateDate = stockUpdateDate;
		this.price = price;
		this.discounts = 0.0; //setting default discount as 0.0
	}
	
	//getters and setters
	public String getToyId() {
		return toyId;
	}

	public void setToyId(String toyId) {
		this.toyId = toyId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getTargetSpecies() {
		return targetSpecies;
	}

	public void setTargetSpecies(String targetSpecies) {
		this.targetSpecies = targetSpecies;
	}

	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	public double getStockQuantity() {
		return stockQuantity;
	}

	public void setStockQuantity(double stockQuantity) {
		this.stockQuantity = stockQuantity;
	}

	public LocalDate getStockListingDate() {
		return stockListingDate;
	}

	public void setStockListingDate(LocalDate stockListingDate) {
		this.stockListingDate = stockListingDate;
	}

	public LocalDate getStockUpdateDate() {
		return stockUpdateDate;
	}

	public void setStockUpdateDate(LocalDate stockUpdateDate) {
		this.stockUpdateDate = stockUpdateDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getDiscounts() {
		return discounts;
	}

	public void setDiscounts(double discounts) {
		this.discounts = discounts;
	}

	//overriding toString()
	@Override
	public String toString() {
		return "PetsToy [toyId=" + toyId + ", name=" + name + ", brand=" + brand + ", targetSpecies=" + targetSpecies
				+ ", material=" + material + ", stockQuantity=" + stockQuantity + ", stockListingDate="
				+ stockListingDate + ", stockUpdateDate=" + stockUpdateDate + ", price=" + price + ", discounts="
				+ discounts + "]";
	}
	
	
	
	
	
	
}
