package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import vn.iotstar.models.Constant;
import vn.iotstar.models.User;
import vn.iotstar.Service.UserService;
import vn.iotstar.Service.UserServiceImpl;

import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class LoginControler
 */

@WebServlet(urlPatterns = { "/login", "/logout", "/forgetPass", "/register","/checkUser" })
public class LoginControler extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginControler() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url = request.getRequestURI();
		HttpSession session = request.getSession();
		if (url.contains("login")) {
			if (session != null && session.getAttribute("account") != null) {
				response.sendRedirect(request.getContextPath() + "/waiting");
				return;
			}
			request.getRequestDispatcher("/views/login.jsp").forward(request, response);
		} else if (url.contains("logout")) {
			if (session != null) {
				session.invalidate();
			}

			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (Cookie cookie : cookies) {
					cookie.setValue("");
					cookie.setMaxAge(0);
					response.addCookie(cookie);
				}
			}
			response.sendRedirect("/WebJDBC/home");
		} else if (url.contains("forgetPass")) {
			request.getRequestDispatcher("/views/forgetPass.jsp").forward(request, response);
		} else if (url.contains("/register")) {
			if (session != null && session.getAttribute("username") != null) {
				response.sendRedirect(request.getContextPath() + "/admin");
				return;
			}
			request.getRequestDispatcher("/views/register.jsp").forward(request, response);
		} else if(url.contains("checkUser")) {
			request.getRequestDispatcher("/views/checkUser.jsp").forward(request, response);
			
		}

	}

	private void saveRemeberMe(HttpServletResponse response, String username) {
		Cookie cookie = new Cookie(Constant.COOKIE_REMEMBER, username);
		cookie.setMaxAge(30 * 60);
		response.addCookie(cookie);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		response.setCharacterEncoding("UTF-8");
		request.setCharacterEncoding("UTF-8");
		String url = request.getRequestURI();
		if (url.contains("login")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			boolean isRememberMe = false;
			String remember = request.getParameter("remember");

			if ("on".equals(remember)) {
				isRememberMe = true;
			}
			String alertMsg = "";

			if (username.isEmpty() || password.isEmpty()) {
				alertMsg = "Tài khoản hoặc mật khẩu không được rỗng";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/login").forward(request, response);
				return;
			}

			UserService service = new UserServiceImpl();
			User user = service.login(username, password);
			// User user = service.get(username, password);
			if (user != null) {
				HttpSession session = request.getSession(true);
				session.setAttribute("account", user);
				session.setAttribute("usernameS", user.getFullName());
				if (isRememberMe) {
					saveRemeberMe(response, username);
				}
				String fullname = (String) session.getAttribute("usernameS");
				request.setAttribute("fullname", fullname);
				request.getRequestDispatcher("/home").forward(request, response);
				//response.sendRedirect(request.getContextPath()+"/waiting");
			} else {

				alertMsg = "Tài khoản hoặc mật khẩu không đúng";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			}
		}else if(url.contains("forgetPass")) {
			String password = request.getParameter("password");

			HttpSession session = request.getSession(false);
			String alertMsg = "";

			String username = (String) session.getAttribute("username");
			UserService service = new UserServiceImpl();
			boolean reset = service.forgetPass(username, password);
			if (reset) {
				request.getRequestDispatcher("/views/login.jsp").forward(request, response);
			} else {
				System.out.print(password);
				alertMsg = "Lỗi";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/views/test.html").forward(request, response);
			}
		}else if(url.contains("register")) {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			String email = request.getParameter("email");
			String fullname = request.getParameter("fullname");
			String phone = request.getParameter("phone");
			UserService service = new UserServiceImpl();
			String alertMsg = "";
			PrintWriter out=response.getWriter();		//response.sendRedirect(request.getContextPath() + "/views/test.html");
			if (service.checkExistUsername(username)) {
				alertMsg = "Tài khoản đã tồn tại!";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
				//out.print("ko lỗi");
				return;
			}
			boolean isSuccess = service.register(username, password, email, fullname, phone);
			if (isSuccess) {
				//System.out.print("hi");
				request.setAttribute("alert", alertMsg);
				response.sendRedirect(request.getContextPath() + "/login");
				
			} else {
				System.out.print("lỗi");
				alertMsg = "System error!";
				System.out.print(username);
				System.out.print(password);
				System.out.print(email);
				System.out.print(phone);
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher(Constant.REGISTER).forward(request, response);
				response.sendRedirect(request.getContextPath() + "views/test.html");
			}
		}else if(url.contains("checkUser")) {
			String username = request.getParameter("username");
			boolean isRememberMe = false;
			 UserService service = new UserServiceImpl();
			String alertMsg = "";

			if (username.isEmpty()) {
				alertMsg = "Vui lòng nhập tài khoản";
				request.setAttribute("alert", alertMsg);
				request.getRequestDispatcher("/views/checkUser.jsp").forward(request, response);
				return;
			}
			if (service.checkExistUsername(username)) {
				request.getRequestDispatcher("/views/forgetPass.jsp").forward(request, response);
			}else {
				alertMsg = "Không có tài khoản này";
				request.setAttribute("alert", alertMsg);
			}
		}

	}

}
