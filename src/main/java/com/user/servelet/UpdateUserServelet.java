package com.user.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.user.model.User;
import com.user.service.UserServiceImpl;
import com.user.service.IUserService;

/**
 * Servlet implementation class UpdateUserServelet
 */
public class UpdateUserServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateUserServelet() {
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
		
		User user = new User();
		
		String id = request.getParameter("id");
		
		
		System.out.println(id + "This is from Servlet");
		
		user.setId(id);
		user.setUsername(request.getParameter("username"));
        user.setPassword(request.getParameter("password"));
        user.setEmail(request.getParameter("email"));
        user.setPhone(request.getParameter("phone"));
        user.setRole(request.getParameter("role"));
        
        IUserService iUserService = new UserServiceImpl();
        
        
        
        
        // PrintWriter to write response
	    PrintWriter out = response.getWriter();
	    
	    try {
	    	iUserService.updateUser(id ,user);
	    	request.setAttribute("User", user);
	        // Feedback successfully added
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Admin Added Successfully !');");
	        out.println("location='adminView.jsp';");
	        out.println("</script>");
	    } finally {
	        out.close();
	    }
	}

}
