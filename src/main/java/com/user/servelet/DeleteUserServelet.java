package com.user.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.user.service.UserServiceImpl;
import com.user.service.IUserService;

/**
 * Servlet implementation class DeleteUserServelet
 */
@WebServlet("/delete_user")
public class DeleteUserServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteUserServelet() {
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
		
		String  userId = request.getParameter("id");
		
		
		IUserService iUserService = new UserServiceImpl();
		iUserService.deleteUser(userId);
		
		request.setAttribute("id", userId);
		jakarta.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/adminView.jsp");
        requestDispatcher.forward(request, response);
	}

}
