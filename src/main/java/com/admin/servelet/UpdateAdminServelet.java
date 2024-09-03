package com.admin.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.admin.model.Admin;
import com.admin.service.AdminServiceImpl;
import com.admin.service.IAdminService;

/**
 * Servlet implementation class UpdateAdminServelet
 */
public class UpdateAdminServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminServelet() {
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
		
		String id = request.getParameter("id");
		
		
		System.out.println(id + "This is from Servlet");
		
		admin.setId(id);
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("password"));
        admin.setRole(request.getParameter("role"));
        
        IAdminService iadminService = new AdminServiceImpl();
        
        
        
        
        // PrintWriter to write response
	    PrintWriter out = response.getWriter();
	    
	    try {
	    	iadminService.updateAdmin(id ,admin);
	    	request.setAttribute("Admin", admin);
	        // Feedback successfully added
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Admin Added Successfully !');");
	        out.println("location='adminView2.jsp';");
	        out.println("</script>");
	    } finally {
	        out.close();
	    }
	}

}
