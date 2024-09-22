package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.config.DBconnectionSQLServer;
import vn.iotstar.dao.UserDaoImpl;
import vn.iotstar.models.User;

import java.io.IOException;

/**
 * Servlet implementation class updateProfileController
 */

@WebServlet(urlPatterns="/profile")
public class updateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public updateProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			User user =new User();	
			UserDaoImpl dao =new UserDaoImpl();
			user =dao.get("anh");
			request.setAttribute("user1", user);
	        request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
	       // System.out.print("tahfnh cong");
		}catch(Exception e) {
			System.out.print("lỗi");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		HttpSession session = request.getSession(false);
		String image = request.getParameter("uploadFile");
		//String username = (String) session.getAttribute("username");
		try {
		
			User user =new User(email,"anh",fullname,"5",image,1,phone,null);
			UserService dao = new UserServiceImpl();
			dao.updateProfile(user);
			System.out.print(fullname);
			System.out.print(email);
			System.out.print(image);
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			
		}catch(Exception e) {
			System.out.print(fullname);
		}
	}
	
}




