package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.Service.UserService;
import vn.iotstar.Service.UserServiceImpl;

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
		
		
		try {
			
			request.getRequestDispatcher("/views/profile.jsp").forward(request, response);
			
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
		User user = (User) session.getAttribute("account");
		try {
		
			User user1 =new User(email,user.getUserName(),fullname,null,image,1,phone,null);
			UserService dao = new UserServiceImpl();
			dao.updateProfile(user1);
			System.out.print(fullname);
			System.out.print(email);
			System.out.print(image);
			System.out.print(user.getUserName());  
			request.setAttribute("user",user1);
			session.setAttribute("account", user1);
			request.getRequestDispatcher("/account").forward(request, response);
			
		}catch(Exception e) {
			System.out.print("lỗi");
		}
	}
	
}
