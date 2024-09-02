package com.admin.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import com.admin.model.Admin;
import com.admin.service.IAdminService;
import com.admin.service.AdminServiceImpl;

/**
 * Servlet implementation class AdminSignupServelet
 */
@WebServlet("/admin-signup")
public class AdminSignupServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminSignupServelet() {
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
		
		Admin admin = new Admin();
		
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("password"));
        admin.setRole("admin");
        
        IAdminService iadminService = new AdminServiceImpl();
        
        
        
        
        // PrintWriter to write response
	    PrintWriter out = response.getWriter();
	    
	    try {
	    	iadminService.adminSignup(admin);
	    	request.setAttribute("Admin", admin);
	        // Feedback successfully added
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Admin Added Successfully !');");
	        out.println("location='adminSignin.jsp';");
	        out.println("</script>");
	    } finally {
	        out.close();
	    }
        
		
	}

}
