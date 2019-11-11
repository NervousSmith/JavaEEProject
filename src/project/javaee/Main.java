package project.javaee;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/hello")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private DbManager db = new DbManager("Dg3jCj0JRD","bHPu8tQZqy");
	Connection conn = db.getConnection();
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		PrintWriter writer = response.getWriter();
		writer.println("Hello World!");
		writer.println();
		if(conn == null)
		{
			writer.println("Database connection failed!");
		}
		else {
			writer.println("Database connection successfull!");
		}
	}

}
