<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
 <%@ page import ="com.services.model.Service" %>   
<%@ page import ="com.admin.service.IAdminService" %>  
<%@ page import ="com.admin.service.AdminServiceImpl" %> 
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
                <a href="<%= request.getContextPath()%>/staffHome.jsp" class="flex items-center px-4 py-2 text-gray-100 hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                   Add Services
                </a>
                <a href="#" class="flex items-center px-4 py-2 mt-2 text-gray-100   hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M13 10V3L4 14h7v7l9-11h-7z" />
                    </svg>
                    View Feedbacks
                </a>
                
                <a href="<%= request.getContextPath()%>/adminView2.jsp" class="flex items-center px-4 py-2 mt-2 text-gray-100 bg-gray-700  hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M13 10V3L4 14h7v7l9-11h-7z" />
                    </svg>
                    View Services
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
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Service Name</th>
               <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Category</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Availability</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Price</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Details</th>
            <th class="px-6 py-3 text-left text-xs font-medium text-gray-500 uppercase tracking-wider">Action</th>
        </tr>
    </thead>
    <tbody class="bg-white divide-y divide-gray-200">
        
        	
        	
        	<%
        	
        		IAdminService iAdminService = new AdminServiceImpl();
        		ArrayList<Service> ServiceList = iAdminService.getSerivices();
        	%>
        	
        	
        	<%
        		for(Service services: ServiceList) {
        	%>
        	<tr>
        	
        	<td class="px-6 py-4 whitespace-nowrap"><%= services.getId() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= services.getName() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= services.getCategory() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= services.getAvailability() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= services.getPrice() %></td>
        	<td class="px-6 py-4 whitespace-nowrap"><%= services.getDetails() %></td>
          	
          	
          	<td>
          		<div class="flex flex-row gap-2">
          			<div>
          				<form action="<%= request.getContextPath()%>/GetServiceServelet" method="post">
          					<input type="hidden" name="id" value="<%= services.getId() %>"/>
          					
          					<button class="bg-blue-500 p-1 rounded-lg text-white" type="submit">
          						Edit
          					</button>
          				</form>
          			</div>
          			<div>
          				<form action="<%= request.getContextPath()%>/DeleteServiceServelet" method="post">
          					<input type="hidden" name="id" value="<%= services.getId() %>"/>
          					
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