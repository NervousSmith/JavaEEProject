package project.javaee;

import java.sql.Connection;

public class Categories {
       
	DbManager dbManager;
    Connection dbConnection;
	
    public Categories() {
        super();
        dbManager = new DbManager();
        
    }

}
