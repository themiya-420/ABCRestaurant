package com.admin.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.admin.service.AdminServiceImpl;
import com.admin.service.IAdminService;

/**
 * Servlet implementation class DeleteAdminServelet
 */
public class DeleteAdminServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteAdminServelet() {
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
		
		response.setContentType("text/html");
		
		String  adminId = request.getParameter("id");
		
		
		IAdminService iAdminService = new AdminServiceImpl();
		iAdminService.deleteAdmin(adminId);
		
		request.setAttribute("id", adminId);
		jakarta.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/adminView2.jsp");
        requestDispatcher.forward(request, response);
		
	}

}
