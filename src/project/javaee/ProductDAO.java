package project.javaee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	List<Product> listProducts;
	ResultSet result;
		
	public List<Product> listAllProducts(){
		listProducts = new ArrayList<>();
		result = ControllerServlet.manager.getQuerryResponse("SELECT * FROM produkty");
		try {
			while (result.next()) {
			    int id = result.getInt("id_produkt");
			    String name = result.getString("nazwa");
			    int brand_id = result.getInt("marka_id");
			    int cat_id = result.getInt("kategoria_id");
			    float price = result.getFloat("cena");
			    listProducts.add(new Product(id, name, cat_id, brand_id, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}         
		return listProducts;
	}
	
	public List<Product> listProducts(int id_kategoria){
		listProducts = new ArrayList<>();
		result = ControllerServlet.manager.getQuerryResponse("SELECT * FROM produkty WHERE kategoria_id=" + id_kategoria);
		try {
			while (result.next()) {
			    int id = result.getInt("id_produkt");
			    String name = result.getString("nazwa");
			    int brand_id = result.getInt("marka_id");
			    int cat_id = result.getInt("kategoria_id");
			    float price = result.getFloat("cena");
			    listProducts.add(new Product(id, name, cat_id, brand_id, price));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}         
		return listProducts;
	}
	
	public Product getProduct(int id) {
		result = ControllerServlet.manager.getQuerryResponse("SELECT * FROM produkty WHERE id_produkt="+id);
		Product produkt;
		try {
			produkt = new Product(result.getInt("id"), result.getString("nazwa"), result.getInt("kategoria_id"), result.getInt("marka_id"), result.getFloat("cena"));
		} catch (SQLException e) {
			e.printStackTrace();
			produkt = null;
		}
		return produkt;
	}
}
