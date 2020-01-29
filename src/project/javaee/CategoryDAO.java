package project.javaee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	ResultSet result;
	DbManager dbManager = DbManager.getInstance();
	
	public List<Category> listCategories() throws SQLException {
        List<Category> listCategory = new ArrayList<>();

        try {
        
        	result = dbManager.getQuerryResponse("SELECT * FROM kategoria ORDER BY nazwa");
             
            while (result.next()) {
                int id = result.getInt("id_kategoria");
                String name = result.getString("nazwa");
                Category category = new Category(id, name);
                     
                listCategory.add(category);
            }          
             
        } catch (SQLException ex) {
            ex.printStackTrace();
            throw ex;
        }      
         
        return listCategory;
    }
	
	public Category getCategory(int id) {
		result = dbManager.getQuerryResponse("SELECT * FROM kategoria WHERE id_kategoria="+id);
		Category kategoria;
		try {
			kategoria = new Category(result.getInt("id"), result.getString("nazwa"));
		} catch (SQLException e) {
			e.printStackTrace();
			kategoria = null;
		}
		return kategoria;
	}
}
