<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
 <%@ page import ="com.reserve.model.Reserve" %>   
<%@ page import ="com.reserve.service.IReserveService" %>  
<%@ page import ="com.reserve.service.ReserveServiceImpl" %> 
<%@ page import ="java.util.ArrayList" %>        


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://cdn.tailwindcss.com"></script>
<title>Insert title here</title>
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
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">First Name</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Last Name</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Guests</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Phone</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Type</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Date</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Time</th>
        </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200">
        
        	
        	
        	<%
        	
        		IReserveService iFeedbackService = new ReserveServiceImpl();
        		ArrayList<Reserve> reserveList = iFeedbackService.getReserves();
        	%>
        	
        	
        	<%
        		for(Reserve reserves: reserveList) {
        	%>
        	<tr>
        	
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getId() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getFname() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getLname() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getGuest() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getPhone() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getType() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getDate() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= reserves.getTime() %></td>
         
          	
          	<td>
          		<div class="flex flex-row items-center justify-center">
          			<div>
          				<form action="<%= request.getContextPath()%>/DeleteReserveServelet" method="post">
          					<input type="hidden" name="id" value="<%= reserves.getId() %>"/>
          					
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