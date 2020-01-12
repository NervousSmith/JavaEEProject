package project.javaee;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerServlet",
		loadOnStartup = 1,
		urlPatterns = {
				"/index",
				"/login",
				"/categories",
				"/userLogged",
				}
)
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String userPath = req.getServletPath();
    	
    	if(userPath.equals("/login")) {
    		login(req, resp);
    	}
    	
    	else 
    	{
    		resp.sendRedirect("Error.jsp");
    	}

    	String url = "/WEB-INF/view" + userPath + ".jsp";
    	req.getRequestDispatcher(url).forward(req, resp);
    
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String userPath = req.getServletPath();
    	
    	if(userPath.equals("/index")) {

    	}
    	
    	else if(userPath.equals("/login")) {
    		
    	}
    	
    	else if(userPath.equals("/userLogged")) {
    		
    	}
    	
    	else 
    	{
    		resp.sendRedirect("Error.jsp");
    	}
    	
    	String url = "/WEB-INF/view" + userPath + ".jsp";
    	req.getRequestDispatcher(url).forward(req, resp);
    }	
    
    
    private void login(HttpServletRequest req, HttpServletResponse resp) {
    	try {
			UserBean user = new UserBean();
			user.setLogin(req.getParameter("login"));
			user.setPass(req.getParameter("password"));
			
			user = UserDAO.login(user);
			
			if(user.isValid()) {
				HttpSession session = req.getSession(true);
				session.setAttribute("currentSessionUser", user);
			}
			
		}
		
		catch(Throwable e) {
			System.out.println(e);
		}
	}
}