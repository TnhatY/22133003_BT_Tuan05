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

@WebServlet(urlPatterns = "/profile")
public class updateProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public updateProfileController() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		String username = (String) session.getAttribute("usernameS");
		try {
			User user = new User();
			UserDaoImpl dao = new UserDaoImpl();
			user = dao.get(username);
			request.setAttribute("user1", user);
			request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
			// System.out.print("tahfnh cong");
		} catch (Exception e) {
			System.out.print("lỗi");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fullname=request.getParameter("fullname");
		String email=request.getParameter("email");
		String phone=request.getParameter("phone");
		HttpSession session = request.getSession(false);
		String image = request.getParameter("uploadFile");
		String username = (String) session.getAttribute("usernameS");
		try {
		
			User user =new User(email,username,fullname,null,image,1,phone,null);
			UserService dao = new UserServiceImpl();
			dao.updateProfile(user);
			System.out.print(fullname);
			System.out.print(email);
			System.out.print(image);
			System.out.print(username);
			
			//String currentPath = request.getRequestURI();

			 String referer = request.getHeader("Referer");
		     if (referer != null) {
		            response.sendRedirect(referer);
		     }
			
	      //  if ("/admin/*".equals(currentPath)) {
	      //  	request.getRequestDispatcher("/views/admin/home.jsp").forward(request, response);
	      //  } else {
	      //  	request.getRequestDispatcher("/views/manager/home.jsp").forward(request, response);
	       // }
			
			//request.getRequestDispatcher("/views/.jsp").forward(request, response);
			
		}catch(Exception e) {
			System.out.print(fullname);
		}
	}
	
}
