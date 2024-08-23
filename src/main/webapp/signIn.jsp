<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://cdn.tailwindcss.com"></script>
<title>ABC Restaurant | SignIn </title>
</head>
<body>

<!-- source:https://codepen.io/owaiswiz/pen/jOPvEPB -->
<div class="min-h-screen bg-gray-100 text-gray-900 flex justify-center">
  <div class="max-w-screen-xl m-0 sm:m-10 bg-white shadow sm:rounded-lg flex justify-center flex-1">
    <div class="lg:w-1/2 xl:w-5/12 p-6 sm:p-12">
      
      <div class="mt-12 flex flex-col items-center">
        <h1 class="text-2xl xl:text-3xl font-extrabold">
          Sign In
        </h1>
        <div class="w-full flex-1 mt-8">

          <div class="mx-auto max-w-xs">

            <form action="<%= request.getContextPath()%>/signin" method="post">
              
              <input
                      class="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white mt-5"
                      type="email" placeholder="Email" name="email"/>
              <input
                      class="w-full px-8 py-4 rounded-lg font-medium bg-gray-100 border border-gray-200 placeholder-gray-500 text-sm focus:outline-none focus:border-gray-400 focus:bg-white mt-5"
                      type="password" placeholder="Password" name="password"/>

             
              <Input type="submit" value="Sign In"
                      class="mt-5 mb-5 tracking-wide font-semibold bg-indigo-500 text-gray-100 w-full py-4 rounded-lg hover:bg-indigo-700 transition-all duration-300 ease-in-out flex items-center justify-center focus:shadow-outline focus:outline-none">
                
     
     		   <span class="text-gray-500 mt-5">Do Not Have an Account ? <a href="<%= request.getContextPath()%>/index.jsp"><span class="text-blue-400">SignUp</span></a></span>
     
              <p class="mt-6 text-xs text-gray-600 text-center">
                I agree to abide by 
                <a href="#" class="border-b border-gray-500 border-dotted">
                  Terms of Service
                </a>
                and its
                <a href="#" class="border-b border-gray-500 border-dotted">
                  Privacy Policy
                </a>
              </p>
            </form>

          </div>
        </div>
      </div>
    </div>
    <div class="flex-1 bg-indigo-100 text-center hidden lg:flex">
      <div class="m-12 xl:m-16 w-full bg-contain bg-center bg-no-repeat"
           style="background-image: url('https://storage.googleapis.com/devitary-image-host.appspot.com/15848031292911696601-undraw_designer_life_w96d.svg');">
      </div>
    </div>
  </div>
</div>

</body>
</html>