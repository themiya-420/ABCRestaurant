package com.user.servelet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import com.feedback.model.feedback;
import com.feedback.service.*;

/**
 * Servlet implementation class AddFeedbackServelet
 */
@WebServlet("/addFeedback")
public class AddFeedbackServelet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddFeedbackServelet() {
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
		
		feedback Feedback = new feedback();
		
		Feedback.setName(request.getParameter("name"));
		Feedback.setEmail(request.getParameter("email"));
		Feedback.setMessage(request.getParameter("message"));
		
		IFeedbackService  ifeedbackService = new FeedbackServiceImpl();
		ifeedbackService.addFeedback(Feedback);
		
		 // PrintWriter to write response
	    PrintWriter out = response.getWriter();
	    
	    try {
	        ifeedbackService.addFeedback(Feedback);
	        // Feedback successfully added
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Feedback Sent Successfully');");
	        out.println("location='contact.jsp';");
	        out.println("</script>");
	    } catch (Exception e) {
	        // Error occurred while adding feedback
	        out.println("<script type='text/javascript'>");
	        out.println("alert('Error: Could not send feedback. Please try again later.');");
	        out.println("</script>");
	    } finally {
	        out.close();
	    }
	}

}
