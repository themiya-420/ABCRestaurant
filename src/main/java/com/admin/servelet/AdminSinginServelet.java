package com.admin.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.admin.service.IAdminService;
import com.admin.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminSinginServelet
 */
@WebServlet("/admin-signin")
public class AdminSinginServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSinginServelet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	
       
		String username = request.getParameter("username");
	    String password = request.getParameter("password");

	    IAdminService iAdminService = new AdminServiceImpl();
	    String role = iAdminService.adminSignin(username, password);

	    if (role != null) {
	        if (role.equals("admin")) {
	            jakarta.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/adminHome.jsp");
	            requestDispatcher.forward(request, response);
	        } else {
	            jakarta.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/staffHome.jsp");
	            requestDispatcher.forward(request, response);
	        }
	    } else {
	        request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
	        request.getRequestDispatcher("signIn.jsp").forward(request, response);
	    }
		
	}

}
