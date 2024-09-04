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
 * Servlet implementation class GetServiceServelet
 */
public class GetServiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetServiceServelet() {
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
		
		String  serviceId = request.getParameter("id");
		
		
		IAdminService iAdminService = new AdminServiceImpl();
		iAdminService.getServiceById(serviceId);
		
		request.setAttribute("id", serviceId);
		jakarta.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/editService.jsp");
        requestDispatcher.forward(request, response);
	
	}

}
