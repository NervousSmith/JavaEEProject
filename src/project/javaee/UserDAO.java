package project.javaee;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

	
	static ResultSet rs = null;
	
	public static UserBean login(UserBean bean) {

		Statement stmt = null;
		
		String login = bean.getLogin();
		String password = bean.getPass();
		
		String searchQuery =
	               "select * from uzytkownicy where login='"
	                        + login
	                        + "' AND pass='"
	                        + password
	                        + "'";
		   try 
		      {
		         rs = ControllerServlet.manager.getQuerryResponse(searchQuery);
		         boolean more = rs.next();
		         
			       
		         if (!more) 
		         {
		            System.out.println("Sorry, you are not a registered user! Please sign up first");
		            bean.setValid(false);
		         } 
			        
		         else if (more) 
		         {
		        	 //if()
		            String firstName = rs.getString("imie");
		            String lastName = rs.getString("nazwisko");
			     	
		            System.out.println("Welcome " + firstName);
		            bean.setImie(firstName);
		            bean.setNazwisko(lastName);
		            bean.setValid(true);
		         }
		      } 

		      catch (Exception ex) 
		      {
		         System.out.println("Log In failed: An Exception has occurred! " + ex);
		      } 
			    
		      finally 
		      {
		         if (rs != null)	{
		            try {
		               rs.close();
		            } catch (Exception e) {}
		               rs = null;
		            }
			
		         if (stmt != null) {
		            try {
		               stmt.close();
		            } catch (Exception e) {}
		               stmt = null;
		            }
		      }

		return bean;
	}
	
	public void register(UserBean bean) {
		
		Statement stm = null;
		
		String Query =
	               "insert into uzytkownicy ";

	                       
		
		

	}
}
