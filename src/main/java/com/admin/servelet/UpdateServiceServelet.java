package com.admin.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.io.PrintWriter;

import com.services.model.Service;
import com.admin.service.AdminServiceImpl;
import com.admin.service.IAdminService;

/**
 * Servlet implementation class UpdateServiceServelet
 */
@WebServlet("/UpdateServiceServlet")
public class UpdateServiceServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServiceServelet() {
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
		
		Service service = new Service();
		
		String id = request.getParameter("id");
		
		
		System.out.println(id + "This is from UpdateService Servlet");
		service.setName(request.getParameter("name"));
		service.setCategory(request.getParameter("category"));
		service.setAvailability(request.getParameter("availability"));
		service.setPrice(request.getParameter("price"));
		service.setImage(request.getParameter("image"));
		service.setDetails(request.getParameter("details"));
        
        IAdminService iadminService = new AdminServiceImpl();
        
        
        
        
        // PrintWriter to write response
	    PrintWriter out = response.getWriter();
	    
	    try {
	    	iadminService.updateService(id ,service);
	    	request.setAttribute("Service", service);
	        // Feedback successfully added
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Service Added Successfully !');");
	        out.println("location='staffView.jsp';");
	        out.println("</script>");
	    } finally {
	        out.close();
	    }
	}

}
