package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import vn.iotstar.dao.SanPhamDAOImpl;
import vn.iotstar.models.SanPham;

import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class SanPhamController
 */

@WebServlet(urlPatterns={"/admin/sanpham2","/admin/sanpham/edit","/admin/sanpham/add"})
public class SanPhamController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url =request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SanPhamDAOImpl svDao= new SanPhamDAOImpl();
		if(url.contains("edit")) {
			int id =Integer.parseInt(request.getParameter("id"));
			SanPham sp = svDao.get(id);
			request.setAttribute("sp", sp);
			System.out.print(sp.getHinhanh());
			System.out.print("lll");
	        request.getRequestDispatcher("/views/admin/category-edit.jsp").forward(request, response);
		}else if(url.contains("sanpham2")) {
			List<SanPham> list = svDao.getSP();
			request.setAttribute("listSP", list);
			request.getRequestDispatcher("/views/admin/category-list.jsp").forward(request, response);
		}else if (url.contains("add")) {
			request.getRequestDispatcher("/views/admin/category-add.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String url =request.getRequestURI();
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		SanPhamDAOImpl svDao= new SanPhamDAOImpl();
		try {
			if(url.contains("edit")) {
				int id =Integer.parseInt(request.getParameter("id"));
				String ten=request.getParameter("tensp");
				String giaban=request.getParameter("giaban");
				String giahientai=request.getParameter("giahientai");
				String hinhanh = request.getParameter("uploadFile");
				
				SanPham sp =new SanPham(id,ten,giaban,giahientai,hinhanh);
				svDao.editSP(sp);
				
				response.sendRedirect(request.getContextPath()+"/admin/sanpham2");
			}else if(url.contains("add")) {
				String ten=request.getParameter("tensp");
				String giaban=request.getParameter("giaban");
				String giahientai=request.getParameter("giahientai");
				String hinhanh = request.getParameter("uploadFile");
				
				svDao.insertSp(new SanPham(ten,giaban,giahientai,hinhanh));
				
				response.sendRedirect(request.getContextPath()+"/admin/sanpham2");
			}
		}catch(Exception ex) {
			System.out.print("Lỗi");
		}
		
	}

}
