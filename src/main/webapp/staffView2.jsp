<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import ="com.feedback.model.feedback" %>   
<%@ page import ="com.feedback.service.IFeedbackService" %>  
<%@ page import ="com.feedback.service.FeedbackServiceImpl" %> 
<%@ page import ="java.util.ArrayList" %>     
 
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://cdn.tailwindcss.com"></script>
<title>ABC | View Feedbacks (Staff)</title>
</head>
<body>

<div class="flex h-screen bg-gray-100">

    <!-- sidebar -->
    <div class="hidden md:flex flex-col w-64 bg-gray-800">
        <div class="flex items-center justify-center h-16 bg-gray-900">
            <span class="text-white font-bold uppercase">Sidebar</span>
        </div>
        <div class="flex flex-col flex-1 overflow-y-auto">
            <nav class="flex-1 px-2 py-4 bg-gray-800">
                <a href="<%= request.getContextPath()%>/adminHome.jsp" class="flex items-center px-4 py-2 text-gray-100 hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                   Add USers
                </a>
                <a href="#" class="flex items-center px-4 py-2 mt-2 text-gray-100 hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M6 18L18 6M6 6l12 12" />
                    </svg>
                    Delete Users
                </a>
                <a href="#" class="flex items-center px-4 py-2 mt-2 text-gray-100   hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M13 10V3L4 14h7v7l9-11h-7z" />
                    </svg>
                    View Users
                </a>
                
                <a href="<%= request.getContextPath()%>/adminView2.jsp" class="flex items-center px-4 py-2 mt-2 text-gray-100 bg-gray-700  hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M13 10V3L4 14h7v7l9-11h-7z" />
                    </svg>
                    View Admins
                </a>
            </nav>
        </div>
    </div>

    <!-- Main content -->
    <div class="flex flex-col flex-1 overflow-y-auto">
        <div class="flex items-center justify-between h-16 bg-white border-b border-gray-200">
            <div class="flex items-center px-4">
                <button class="text-gray-500 focus:outline-none focus:text-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                </button>
                <input class="mx-4 w-full border rounded-md px-4 py-2" type="text" placeholder="Search">
            </div>
            <div class="flex items-center pr-4">

                <button
                    class="flex items-center text-gray-500 hover:text-gray-700 focus:outline-none focus:text-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M12 19l-7-7 7-7m5 14l7-7-7-7" />
                    </svg>
                </button>
            </div>
        </div>
        <table class="min-w-full divide-y divide-gray-200">
    <thead>
        <tr>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">ID</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Name</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Email</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Message</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Action</th>
        </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200">
        
        	
        	
        	<%
        	
        		IFeedbackService iFeedbackService = new FeedbackServiceImpl();
        		ArrayList<feedback> feedbackList = iFeedbackService.getFeedbacks();
        	%>
        	
        	
        	<%
        		for(feedback feedback: feedbackList) {
        	%>
        	<tr>
        	
        	<td class="px-6 py-4 whitespace-nowrap"><%= feedback.getId() %></td>
          	<td class="px-6 py-4 whitespace-nowrap"><%= feedback.getName() %></td>
          	<td class="px-6 py-4 whitespace-nowrap"><%= feedback.getEmail() %></td>
          	<td class="px-6 py-4 whitespace-nowrap"><%= feedback.getMessage() %></td>
          	
          	<td>
          		<div class="flex flex-row items-center justify-center">
          			<div>
          				<form action="<%= request.getContextPath()%>/DeleteFeedbackServelet" method="post">
          					<input type="hidden" name="id" value="<%= feedback.getId() %>"/>
          					
          					<button class="bg-red-500 p-1 rounded-lg text-white" type="submit">
          						Delete
          					</button>
          				</form>
          			</div>
          		</div>
          	</td>
  
           
        </tr>
        	
        	<%
        		}
        	%>
        
            
       
    </tbody>
</table>
    </div>
    
</div>

</body>
</html>