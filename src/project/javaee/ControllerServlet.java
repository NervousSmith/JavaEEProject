package project.javaee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
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
				"/category",
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
    		listCategories(req, resp);
    	}
    	
    	else if(userPath.equals("/login")) {
    		
    	}
    	
    	else if(userPath.equals("/userLogged")) {
    		
    	}
    	
    	else if(userPath.equals("/category")) {
    		
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
    
    private void listCategories(HttpServletRequest req, HttpServletResponse resp) {
    	try {
    		CategoryDAO dao = new CategoryDAO();
            List<Category> listCatagory = dao.listCategories();
            req.setAttribute("listCategory", listCatagory);
 
            RequestDispatcher dispatcher = req.getRequestDispatcher("index.jsp");
            dispatcher.forward(req, resp);
 
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}