package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.dao.SanPhamDAO;
import vn.iotstar.dao.SanPhamDAOImpl;
import vn.iotstar.models.SanPham;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class HomeController
 */

@WebServlet(urlPatterns="/home")
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		SanPhamDAOImpl svDao= new SanPhamDAOImpl();
		List<SanPham> list = svDao.getSP();
		
		request.setAttribute("listSP", list);
        request.getRequestDispatcher("/views/home.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
