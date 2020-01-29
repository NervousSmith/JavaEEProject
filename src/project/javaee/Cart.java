package project.javaee;

import java.util.ArrayList;

public class Cart {
	
	private ArrayList<Product> lista;
	
	Cart(){
		lista = new ArrayList<Product>();
	}
	
	public void addToCart(Product product) {
		lista.add(product);
	}
	
	public void removeFromCart(Product product) {
		lista.remove(product);
	}
	
	public ArrayList<Product> getProducts() {
		return lista;
	}
	
	public void clear() {
		lista = null;
	}
	
	public float getFullPrice() {
		float price = 0;
		for(int i = 0; i<lista.size(); i++) {
			price += lista.get(i).getPrice();
		}
		return price;
	}
}
