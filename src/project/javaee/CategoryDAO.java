package project.javaee;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
	
	
	public List<Category> listCategories() throws SQLException {
        List<Category> listCategory = new ArrayList<>();
        DbManager dbManager = new DbManager();
         
        try {
        
        	ResultSet result = dbManager.getQuerryResponse("SELECT * FROM kategoria ORDER BY nazwa");
             
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
}
