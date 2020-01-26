package project.javaee;

import java.sql.ResultSet;
import java.sql.Statement;

public class UserDAO {

	DbManager dbManager = DbManager.getInstance();
	static ResultSet rs = null;
	
	public UserBean login(UserBean bean) {

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
		         rs = dbManager.getQuerryResponse(searchQuery);
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
		String Query =
	               "INSERT INTO uzytkownicy (login, pass, imie, nazwisko, nr_tel, ulica, miasto, kod_pocztowy, nr_domu, e_mail) "
	               + "values('" + bean.getLogin() + "','" + bean.getPass() + "','"  + bean.getImie() + "','"  + bean.getNazwisko() + "','" 
	            		   + bean.getNr_tel() + "','" + bean.getUlica() + "','" + bean.getMiasto() + "','" + bean.getKod_pocztowy() + "','" +
	            		   bean.getNr_domu() + "','" + bean.getE_mail() + "')";
		dbManager.executeUpdate(Query);
	             
	}
}
