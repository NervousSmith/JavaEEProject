package project.javaee;

public class Product {
	private int id;
	private String name;
	private int cat_id;
	private int brand_id;
	private float price;
	
	Product(int id, String name, int cat_id, int brand_id, float price){
		this.id = id;
		this.name = name;
		this.brand_id = brand_id;
		this.cat_id = cat_id;
		this.price = price;
	}
	
	public int getId() {
		return this.id;
	}
	
	public int getBrandId() {
		return this.brand_id;
	}
	
	public int getCategoryId() {
		return this.cat_id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public float getPrice() {
		return this.price;
	}
}
