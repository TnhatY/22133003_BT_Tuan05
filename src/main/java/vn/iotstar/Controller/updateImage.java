package vn.iotstar.Controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;
import vn.iotstar.models.Constant;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Servlet implementation class updateImage
 */
@WebServlet(urlPatterns = "/updateImage")

@MultipartConfig(fileSizeThreshold = 1024 * 1024,

		maxFileSize = 1024 * 1024 * 5,

		maxRequestSize = 1024 * 1024 * 5 * 5)
public class updateImage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public updateImage() {
		super();
		// TODO Auto-generated constructor stub
	}

	private String getFileName(Part part) {

		for (String content : part.getHeader("content-disposition").split(";")) {

			if (content.trim().startsWith("filename"))

				return content.substring(content.indexOf("=") + 2, content.length() - 1);

		}

		return Constant.DEFAULT_FILENAME;

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("/views/test.html").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uploadPath = File.separator + Constant.UPLOAD_DIRECTORY; // upload vào thư mục bất kỳ

		// String uploadPath = getServletContext().getRealPath("") + File.separator +
		// UPLOAD_DIRECTORY; //upload vào thư mục project

		File uploadDir = new File(uploadPath);

		if (!uploadDir.exists())

			uploadDir.mkdir();

		try {

			String fileName = "";

			for (Part part : request.getParts()) {

				fileName = getFileName(part);

				part.write(uploadPath + File.separator + fileName);

			}
			System.out.print("thanh cong");
			request.setAttribute("message", "File " + fileName + " has uploaded successfully!");

		} catch (FileNotFoundException fne) {
			System.out.print("loi");
			request.setAttribute("message", "There was an error: " + fne.getMessage());

		}

		//response.getRequestDispatcher("/views/result.jsp").forward(request, response);
		System.out.print("hi");
	}

}
