package com.user.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.reserve.model.Reserve;
import com.reserve.service.ReserveServiceImpl;
import com.reserve.service.IReserveService;

/**
 * Servlet implementation class AddReserveServelet
 */
@WebServlet("/addReserve")
public class AddReserveServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddReserveServelet() {
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
		
		Reserve reserve = new Reserve();
		
		reserve.setFname(request.getParameter("fname"));
		reserve.setLname(request.getParameter("lname"));
		reserve.setGuest(request.getParameter("guest"));
		reserve.setPhone(request.getParameter("phone"));
		reserve.setType(request.getParameter("type"));
		reserve.setDate(request.getParameter("date").toString());
		reserve.setTime(request.getParameter("time").toString());
		
		
		IReserveService  iReserveService = new ReserveServiceImpl();
//		ifeedbackService.addReserve(reserve);
		
		 // PrintWriter to write response
	    PrintWriter out = response.getWriter();
	    
	    try {
	        iReserveService.addReserve(reserve);
	        // Feedback successfully added
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Reservation SuccessFull you will be contacted.');");
	        out.println("location='reserve.jsp';");
	        out.println("</script>");
	    } catch (Exception e) {
	        // Error occurred while adding feedback
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Error: Could Not Reserve Try again later.');");
	        out.println("</script>");
	    } finally {
	        out.close();
	    }

	}

}
