package project.javaee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    		
    		try {
    			UserBean user = new UserBean();
    			user.setLogin(req.getParameter("login"));
    			user.setPass(req.getParameter("password"));
    			
    			user = UserDAO.login(user);
    			
    			if(user.isValid()) {
    				HttpSession session = req.getSession(true);
    				session.setAttribute("currentSessionUser", user);
    				resp.sendRedirect("userLogged.jsp");
    			}
    			else
    				resp.sendRedirect("invalidLogin.jsp");
    		}
    		
    		catch(Throwable e) {
    			System.out.println(e);
    		}
    	}

}
