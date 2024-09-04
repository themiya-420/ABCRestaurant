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
<title>ABC | Edit Service (Staff)</title>
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
                <a href="#" class="flex items-center px-4 py-2 text-gray-100 bg-gray-700 hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M4 6h16M4 12h16M4 18h16" />
                    </svg>
                    Add Users
                </a>
                <a href="#" class="flex items-center px-4 py-2 mt-2 text-gray-100 hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M6 18L18 6M6 6l12 12" />
                    </svg>
                   Delete Users
                </a>
                <a href="<%= request.getContextPath()%>/adminView.jsp" class="flex items-center px-4 py-2 mt-2 text-gray-100 hover:bg-gray-700">
                    <svg xmlns="http://www.w3.org/2000/svg" class="h-6 w-6 mr-2" fill="none" viewBox="0 0 24 24"
                        stroke="currentColor">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                            d="M13 10V3L4 14h7v7l9-11h-7z" />
                    </svg>
                   View Users
                </a>
                
                  <a href="<%= request.getContextPath()%>/adminView2.jsp" class="flex items-center px-4 py-2 mt-2 text-gray-100  hover:bg-gray-700">
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
        <div class="ml-[600px] w-1/2 flex flex-row items-center justify-between">
        	<div>
        	
        	<% 
        	
        		String id = (String) request.getAttribute("id");
        	
        		IAdminService iAdminService = new AdminServiceImpl();
        		
        		ArrayList<Service> ServiceList = iAdminService.getServiceById(id);
        	
        	%>
        	
        	
        	<% for (Service services: ServiceList) { %>
        	
        	
        	<form action="<%= request.getContextPath()%>/UpdateServiceServelet" method="post" class="w-[400px] mx-auto mt-20 p-6 bg-white border rounded-lg shadow-lg">
			    <h2 class="text-2xl font-bold mb-6">Edit Service</h2>
			     <div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="name">
			      ID:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="id" name="id" value="<%= services.getId() %>">
			    </div>
			    <div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="name">
			      Service Name:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="name" name="name" type="text" value="<%= services.getName() %>">
			    </div>
			    <div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="email">
			      Category:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="category" name="category" type="text" value="<%= services.getCategory() %>" >
			    </div>
			  	<div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="email">
			      Availability:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="availability" name="availability" type="text" value="<%= services.getAvailability() %>" >
			    </div>
			    <div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="email">
			      Price:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="price" name="price" type="text" value="<%= services.getPrice() %>" >
			    </div>
			     <div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="email">
			      Image:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="image" name="image" type="text" value="<%= services.getImage() %>" >
			    </div>
			     <div class="mb-4">
			        <label class="block text-gray-700 font-bold mb-2" for="email">
			      Details:
			    </label>
			        <input class="shadow appearance-none border rounded w-full py-2 px-3 text-gray-700 leading-tight focus:outline-none focus:shadow-outline" id="details" name="details" type="text" value="<%= services.getDetails() %>" >
			    </div>
			    <button class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline" type="submit">
			    Submit
			  </button>
		  </form>
        	
        	<% } %>
        	
    
        	</div>
        
        </div>
    </div>
    
</div>
</body>
</html>