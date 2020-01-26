package project.javaee;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ControllerServlet",
		urlPatterns = {
				"/login",
				"/shop",
				"/register",
				"/product",
				"/checkout",
				"/cart"
				}
)
public class ControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    @Override
    	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String userPath = req.getServletPath();
    	HttpSession session = req.getSession(true);
    	
    	if(userPath.equals("/login")) {
    		login(req, resp, session);
    		return;
    	}
    	else if(userPath.equals("/register")) {
    		register(req, resp);
    		return;
    	}
    	else if(userPath.equals("/cart")) {
    		
    	}
    	else if(userPath.equals("/shop")) {
    		Cart cart;
    		String pro = req.getParameter("id").toString();
    		int id = Integer.parseInt(pro);
    		if(session.getAttribute("cart") != null) {
    			cart = (Cart) session.getAttribute("cart");
    			addToCart(id, cart, session);
    		}
    		else if(session.getAttribute("cart") == null) {
    			cart = new Cart();
    			addToCart(id, new Cart(), session);
    		}
    	}
    	

    	String url = "/WEB-INF" + userPath + ".jsp";
    	req.getRequestDispatcher(url).forward(req, resp);
    
    }
    @Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	
    	String userPath = req.getServletPath();
    	HttpSession session = req.getSession(true);
    	
    	if(userPath.equals("/login")) {
    		
    	}
    	
    	else if(userPath.equals("/shop")) {
    		listCategories(req, resp);
    		if(req.getParameter("category") != null)
    		{
    			String cat = req.getParameter("category").toString();
    			listProducts(req, resp, Integer.parseInt(cat));
    		}
    		else {
    			listProducts(req, resp);
    		}
    	}
    	
    	else if(userPath.equals("/product")) {
    		String pro = req.getParameter("product").toString();
    		showProduct(req, resp, Integer.parseInt(pro));
    	}
    	
    	else if(userPath.equals("/cart")) {
    		if(session.getAttribute("cart") != null) {
    		Cart cart = (Cart) session.getAttribute("cart");
    		req.setAttribute("cartList", cart.getProducts());
    		}
    		else if(session.getAttribute("cart") == null) {
    			
    		}
    	}
    	
    	
    	String url = "/WEB-INF" + userPath + ".jsp";
    	req.getRequestDispatcher(url).forward(req, resp);
    }	
    
    
    private void login(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
    	UserDAO dao = new UserDAO();
    	try {
			UserBean user = new UserBean();
			user.setLogin(req.getParameter("login"));
			user.setPass(req.getParameter("password"));
			user = dao.login(user);
			
			if(user.isValid()) {
				
				session.setAttribute("currentSessionUser", user);
				req.getRequestDispatcher("index.jsp").forward(req, resp);
			}
			
		}
		
		catch(Throwable e) {
			System.out.println(e);
		}
	}
    
    private void listProducts(HttpServletRequest req, HttpServletResponse resp) {
    	ProductDAO dao = new ProductDAO();
    	List<Product> list = dao.listAllProducts();
    	req.setAttribute("products", list);
    }
    
    private void listProducts(HttpServletRequest req, HttpServletResponse resp, int id) {
    	ProductDAO dao = new ProductDAO();
    	List<Product> list = dao.listProducts(id);
    	req.setAttribute("products", list);
    }
    
    private void listCategories(HttpServletRequest req, HttpServletResponse resp) {
    	try {
    		CategoryDAO dao = new CategoryDAO();
            List<Category> listCatagory = dao.listCategories();
            req.setAttribute("listCategory", listCatagory);
 
        } catch (SQLException e) {
            e.printStackTrace();
        } 
    }
    private void showProduct(HttpServletRequest req, HttpServletResponse resp, int id) {
    	ProductDAO dao = new ProductDAO();
    	req.setAttribute("product", dao.getProduct(id));
    }
    
    private void register(HttpServletRequest req, HttpServletResponse resp) {
    	UserDAO dao = new UserDAO();
    	UserBean newUser = new UserBean();
       	newUser.setLogin(req.getParameter("login"));
       	newUser.setPass(req.getParameter("password"));
        newUser.setImie(req.getParameter("imie"));
       	newUser.setNazwisko(req.getParameter("nazwisko"));
       	newUser.setE_mail(req.getParameter("e_mail"));
       	newUser.setNr_tel(req.getParameter("nr_tel"));
       	newUser.setMiasto(req.getParameter("miasto"));
       	newUser.setKod_pocztowy(req.getParameter("kod_pocztowy"));
       	newUser.setUlica(req.getParameter("ulica"));
       	newUser.setNr_domu(req.getParameter("nr_domu"));       	
        try {
        	dao.register(newUser);
        	HttpSession session = req.getSession(true);
        	session.setAttribute("currentSessionUser", newUser);
        	req.getRequestDispatcher("login.jsp").forward(req, resp);
        }
       	catch (Exception e) {
        		
       	}
    }
    
    private void addToCart(int id, Cart cart, HttpSession session) {
    	ProductDAO dao = new ProductDAO();
    	cart.addToCart(dao.getProduct(id));
    	session.setAttribute("cart", cart);
    }
}