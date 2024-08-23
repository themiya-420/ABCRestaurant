package com.user.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import com.user.service.IUserService;
import com.user.service.UserServiceImpl;

/**
 * Servlet implementation class SignInServelet
 */
@WebServlet("/signin")
public class SignInServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignInServelet() {
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
		
		// Get the email and password from the request
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Validate user credentials
        IUserService iUserService = new UserServiceImpl();
        boolean isAuthenticated = iUserService.userSingIn(email, password);

        if (isAuthenticated) {
            // Redirect or forward to a success page or dashboard
        	 jakarta.servlet.RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/home.jsp");
             requestDispatcher.forward(request, response);
        } else {
            // Redirect or forward to an error page with an error message
        	System.out.println(isAuthenticated);
            request.setAttribute("errorMessage", "Invalid email or password. Please try again.");
            request.getRequestDispatcher("signIn.jsp").forward(request, response);
        }
	}

}
