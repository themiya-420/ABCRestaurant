<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
 <script src="https://cdn.tailwindcss.com"></script>
 <script>
        let currentIndex = 0;

        function scrollCarousel(direction) {
            console.log("Button Pressed");
            const carousel = document.getElementById("carousel");
            const totalSlides = carousel.children.length;
            currentIndex = (currentIndex + direction + totalSlides) % totalSlides;
            carousel.style.transform = `translateX(-${currentIndex * 100}%)`;
        }

        // Function to handle smooth scrolling
        function scrollToDiv() {
            document.getElementById('2').scrollIntoView({
                behavior: 'smooth'
            });
        }
        
        function scrollToNextDiv() {
            document.getElementById('3').scrollIntoView({
                behavior: 'smooth'
            });
        }
        
        function scrollToNextOtherDiv() {
            document.getElementById('4').scrollIntoView({
                behavior: 'smooth'
            });
        }
    </script>
<title>ABCRestaurant | Home</title>
</head>
<body>
<nav class="bg-white fixed top-0 z-20 border-gray-200 py-2.5 w-screen dark:bg-gray-900">
    <div class="flex flex-wrap items-center justify-between max-w-screen-xl px-4 mx-auto">
        <a href="#" class="flex items-center">
            <img src="https://www.svgrepo.com/show/499962/music.svg" class="h-6 mr-3 sm:h-9" alt="Landwind Logo">
            <span class="self-center text-xl font-semibold whitespace-nowrap dark:text-white">ABCRestaurant</span>
        </a>
        <div class="flex items-center lg:order-2">
            <div class="hidden mt-2 mr-4 sm:inline-block">
                <span></span>
            </div>

            <a href="https://themesberg.com/product/tailwind-css/landing-page"
                class="text-white bg-purple-700 hover:bg-purple-800 focus:ring-4 focus:ring-purple-300 font-medium rounded-lg text-sm px-4 lg:px-5 py-2 lg:py-2.5 sm:mr-2 lg:mr-0 dark:bg-purple-600 dark:hover:bg-purple-700 focus:outline-none dark:focus:ring-purple-800">Sign OUt</a>
            <button data-collapse-toggle="mobile-menu-2" type="button"
				class="inline-flex items-center p-2 ml-1 text-sm text-gray-500 rounded-lg lg:hidden hover:bg-gray-100 focus:outline-none focus:ring-2 focus:ring-gray-200 dark:text-gray-400 dark:hover:bg-gray-700 dark:focus:ring-gray-600"
				aria-controls="mobile-menu-2" aria-expanded="true">
				<span class="sr-only">Open main menu</span>
				<svg class="w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd"
						d="M3 5a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 10a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1zM3 15a1 1 0 011-1h12a1 1 0 110 2H4a1 1 0 01-1-1z"
						clip-rule="evenodd"></path>
				</svg>
				<svg class="hidden w-6 h-6" fill="currentColor" viewBox="0 0 20 20" xmlns="http://www.w3.org/2000/svg">
					<path fill-rule="evenodd"
						d="M4.293 4.293a1 1 0 011.414 0L10 8.586l4.293-4.293a1 1 0 111.414 1.414L11.414 10l4.293 4.293a1 1 0 01-1.414 1.414L10 11.414l-4.293 4.293a1 1 0 01-1.414-1.414L8.586 10 4.293 5.707a1 1 0 010-1.414z"
						clip-rule="evenodd"></path>
				</svg>
			</button>
        </div>
        <div class="items-center justify-between w-full lg:flex lg:w-auto lg:order-1" id="mobile-menu-2">
            <ul class="flex flex-col mt-4 font-medium lg:flex-row lg:space-x-8 lg:mt-0">
                <li>
                    <a href="#"
                        class="block py-2 pl-3 pr-4 text-white bg-purple-700 rounded lg:bg-transparent lg:text-purple-700 lg:p-0 dark:text-white"
                        aria-current="page">Home</a>
                </li>
                <li>
                    <a href="#"
                        class="block py-2 pl-3 pr-4 text-gray-700 border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-purple-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">Company</a>
                </li>
                <li>
                    <a href="#"
                        class="block py-2 pl-3 pr-4 text-gray-700 border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-purple-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">Reserve</a>
                </li>
                <li>
                    <a href="<%= request.getContextPath()%>/gallery.jsp"
                        class="block py-2 pl-3 pr-4 text-gray-700 border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-purple-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">Gallery</a>
                </li>
                <li>
                    <a href="#"
                        class="block py-2 pl-3 pr-4 text-gray-700 border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-purple-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">FAQ</a>
                </li>
                <li>
                    <a href="<%= request.getContextPath()%>/contact.jsp"
                        class="block py-2 pl-3 pr-4 text-gray-700 border-b border-gray-100 hover:bg-gray-50 lg:hover:bg-transparent lg:border-0 lg:hover:text-purple-700 lg:p-0 dark:text-gray-400 lg:dark:hover:text-white dark:hover:bg-gray-700 dark:hover:text-white lg:dark:hover:bg-transparent dark:border-gray-700">Contact</a>
                </li>
            </ul>
        </div>
    </div>
</nav>


<!-- forked from: https://codepen.io/cuonoj/pen/JjPmMaB -->

<section class="relative h-screen flex flex-col items-center justify-center text-center text-white ">
    <div class="video-docker absolute top-0 left-0 w-full h-full overflow-hidden">
        <video class="min-w-full min-h-full absolute object-cover"
            src="https://videos.pexels.com/video-files/3298718/3298718-uhd_2732_1440_25fps.mp4"
            type="video/mp4" autoplay muted loop></video>
    </div>
    <div class="video-content space-y-2 z-10">
        <h1 class="font-bold text-6xl">ABCRestaruant</h1>
        <h3 class="font-light text-lg max-w-[1500px] mb-5">
        
        At ABC Restaurant, we bring you a delightful fusion of traditional and contemporary cuisine in a warm and inviting atmosphere. 
        Our chefs craft each dish with passion and creativity, using only the freshest ingredients to ensure a memorable dining experience. 
        Whether you're here for a casual meal or a special occasion, 
        ABC Restaurant is the perfect place to enjoy great food, exceptional service, 
        and a cozy ambiance. Join us and savor the flavors of excellence!
        
        </h3>
        
        <button id="scrollBtn" class="bg-purple-700 px-2 py-2 mt-[50px] rounded-xl" >Scroll Down To Learn More</button>
    </div>
</section>



	<div id="2" class="bg-white dark:bg-gray-800 h-screen h-full py-6 sm:py-8 lg:py-12 ">
    <div class="mx-auto max-w-screen-2xl px-4 md:px-8">
        <div class="mb-4 flex items-center justify-between gap-8 sm:mb-8 md:mb-12">
            <div class="flex items-center gap-12 mt-20">
                <h2 class="text-2xl font-bold text-gray-800 lg:text-3xl dark:text-white">Gallery</h2>

                <p class="hidden max-w-screen-sm text-gray-500 dark:text-gray-300 md:block">
                    This is a section of some simple filler text,
                    also known as placeholder text. It shares some characteristics of a real written text.
                </p>
            </div>

            <a href="#"
                class="inline-block rounded-lg border bg-white dark:bg-gray-700 dark:border-none px-4 py-2 text-center text-sm font-semibold text-gray-500 dark:text-gray-200 outline-none ring-indigo-300 transition duration-100 hover:bg-gray-100 focus-visible:ring active:bg-gray-200 md:px-8 md:py-3 md:text-base">
                More
            </a>
        </div>

        <div class="grid grid-cols-2 gap-4 sm:grid-cols-3 md:gap-6 xl:gap-8">
            <!-- image - start -->
            <a href="#"
                class="group relative flex h-48 items-end overflow-hidden rounded-lg bg-gray-100 shadow-lg md:h-80">
                <img src="https://images.unsplash.com/photo-1517248135467-4c7edcad34c4?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" loading="lazy" alt="Photo by Minh Pham" class="absolute inset-0 h-full w-full object-cover object-center transition duration-200 group-hover:scale-110" />

                <div
                    class="pointer-events-none absolute inset-0 bg-gradient-to-t from-gray-800 via-transparent to-transparent opacity-50">
                </div>

                <span class="relative ml-4 mb-3 inline-block text-sm text-white md:ml-5 md:text-lg"></span>
            </a>
            <!-- image - end -->

            <!-- image - start -->
            <a href="#"
                class="group relative flex h-48 items-end overflow-hidden rounded-lg bg-gray-100 shadow-lg md:col-span-2 md:h-80">
                <img src="https://images.unsplash.com/photo-1514933651103-005eec06c04b?q=80&w=1974&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" loading="lazy" alt="Photo by Magicle" class="absolute inset-0 h-full w-full object-cover object-center transition duration-200 group-hover:scale-110" />

                <div
                    class="pointer-events-none absolute inset-0 bg-gradient-to-t from-gray-800 via-transparent to-transparent opacity-50">
                </div>

                <span class="relative ml-4 mb-3 inline-block text-sm text-white md:ml-5 md:text-lg"></span>
            </a>
            <!-- image - end -->

            <!-- image - start -->
            <a href="#"
                class="group relative flex h-48 items-end overflow-hidden rounded-lg bg-gray-100 shadow-lg md:col-span-2 md:h-80">
                <img src="https://images.unsplash.com/photo-1488992783499-418eb1f62d08?q=80&w=1978&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" loading="lazy" alt="Photo by Martin Sanchez" class="absolute inset-0 h-full w-full object-cover object-center transition duration-200 group-hover:scale-110" />

                <div
                    class="pointer-events-none absolute inset-0 bg-gradient-to-t from-gray-800 via-transparent to-transparent opacity-50">
                </div>

                <span class="relative ml-4 mb-3 inline-block text-sm text-white md:ml-5 md:text-lg"></span>
            </a>
            <!-- image - end -->

            <!-- image - start -->
            <a href="#"
                class="group relative flex h-48 items-end overflow-hidden rounded-lg bg-gray-100 shadow-lg md:h-80">
                <img src="https://images.unsplash.com/photo-1533777857889-4be7c70b33f7?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" loading="lazy" alt="Photo by Lorenzo Herrera" class="absolute inset-0 h-full w-full object-cover object-center transition duration-200 group-hover:scale-110" />

                <div
                    class="pointer-events-none absolute inset-0 bg-gradient-to-t from-gray-800 via-transparent to-transparent opacity-50">
                </div>

                <span class="relative ml-4 mb-3 inline-block text-sm text-white md:ml-5 md:text-lg"></span>
            </a>
            <!-- image - end -->
            
            
            
        </div>
        
         <button id="scrollBtn2" class="bg-purple-700 text-white px-2 py-2 mt-[50px] rounded-xl" >Scroll Down To Learn More</button>
    </div>
</div>


<section class="bg-whiteoverflow-hidden">
 <div id="3" class="max-w-screen-xl 2xl:max-w-screen-3xl px-8 md:px-12 mx-auto py-12 lg:py-24 space-y-24 h-svh flex flex-col justify-center">
 <h2 class="text-3xl font-bold ">Meet Our Chefs.</h2>
  <div class="flex flex-col sm:flex-row mx-auto">
   <a href="#_"> <img src="https://plus.unsplash.com/premium_photo-1687697861242-03e99059e833?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="rounded-xl  rotate-6 hover:rotate-0 duration-500 hover:-translate-y-12 h-full w-full object-cover hover:scale-150 transform origin-bottom" alt="#_"> </a>
   <a href="#_"> <img src="https://plus.unsplash.com/premium_photo-1661778156582-670d5b62a9e4?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D " class="rounded-xl  -rotate-12 hover:rotate-0 duration-500 hover:-translate-y-12 h-full w-full object-cover hover:scale-150 transform origin-bottom" alt="#_"> </a>
   <a href="#_"> <img src="https://plus.unsplash.com/premium_photo-1683707120233-0ad52cb97b7b?q=80&w=2071&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="rounded-xl  rotate-6 hover:rotate-0 duration-500 hover:-translate-y-12 h-full w-full object-cover hover:scale-150 transform origin-bottom" alt="#_"> </a>
   <a href="#_"> <img src="https://plus.unsplash.com/premium_photo-1661778021952-65997d03b2b2?q=80&w=2070&auto=format&fit=crop&ixlib=rb-4.0.3&ixid=M3wxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHx8fA%3D%3D" class="rounded-xl  -rotate-12 hover:rotate-0 duration-500 hover:-translate-y-12 h-full w-full object-cover hover:scale-150 transform origin-bottom" alt="#_"> </a>
   <!--- Ends component -->
  </div>
  
  <button id="scrollBtn3" class="bg-purple-700 max-w-[300px] text-white px-2 py-2 mt-[50px] rounded-xl" >Scroll Down To Learn More</button>
 </div>
 
</section>

<div id="4"  class="mt-8 bg-violet-900 pt-9">
  <div class="mx-auto w-full max-w-[1166px] px-4 xl:px-0">
    <div class="flex flex-col justify-between sm:px-[18px] md:flex-row md:px-10">
      <div class="md:w-[316px]">
        <p class="text-[18px] font-medium text-white">
        <h1 class="text-white font-extrabold">
          <span class="text-rose-600">ABC</span>Restaurant
        </h1>
        </p>
        <p class="mt-[18px] text-[15px] font-normal text-white/[80%]">ABCRestaurnt make your holidays more Live.</p>
        <div class="mt-[18px] flex gap-4">
          <a class="hover:scale-110" target="_blank"
            href="#"><img alt="facebook icon" loading="lazy" width="36" height="36" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/facebook.svg" /></a><a
            class="hover:scale-110" target="_blank"
            href="/"><img alt="linkdin icon" loading="lazy" width="36" height="36" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/linkdin.svg" /></a><a
            class="hover:scale-110" target="_blank"
            href="/"><img alt="instagram icon" loading="lazy" width="36" height="36" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/instagram1.svg" /></a><a
            class="hover:scale-110" target="_blank"
            href=""><img alt="twitter icon" loading="lazy" width="36" height="36" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/twitter.svg" /></a><a
            class="hover:scale-110" target="_blank"
            href="https://www.youtube.com/"><img alt="youtube icon" loading="lazy" width="36" height="36" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/youtube.svg" /></a>
        </div>
      </div>
      <div class="md:w-[316px]">
        <div class="mt-[23px] flex">
          <div class="flex h-[38px] w-[38px] items-center justify-center rounded-[75%]">
            <svg width="24" height="24" viewBox="0 0 24 24" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M20.8472 14.8554L16.4306 12.8764L16.4184 12.8707C16.1892 12.7727 15.939 12.7333 15.6907 12.7562C15.4424 12.7792 15.2037 12.8636 14.9963 13.002C14.9718 13.0181 14.9484 13.0357 14.9259 13.0545L12.6441 14.9998C11.1984 14.2976 9.70595 12.8164 9.00376 11.3895L10.9519 9.07294C10.9706 9.0495 10.9884 9.02606 11.0053 9.00075C11.1407 8.79384 11.2229 8.55667 11.2445 8.31035C11.2661 8.06402 11.2264 7.81618 11.1291 7.58887V7.57762L9.14438 3.15356C9.0157 2.85662 8.79444 2.60926 8.51362 2.44841C8.2328 2.28756 7.9075 2.22184 7.58626 2.26106C6.31592 2.42822 5.14986 3.05209 4.30588 4.01615C3.4619 4.98021 2.99771 6.21852 3.00001 7.49981C3.00001 14.9436 9.05626 20.9998 16.5 20.9998C17.7813 21.0021 19.0196 20.5379 19.9837 19.6939C20.9477 18.85 21.5716 17.6839 21.7388 16.4136C21.7781 16.0924 21.7125 15.7672 21.5518 15.4864C21.3911 15.2056 21.144 14.9843 20.8472 14.8554ZM16.5 19.4998C13.3185 19.4963 10.2682 18.2309 8.01856 15.9813C5.76888 13.7316 4.50348 10.6813 4.50001 7.49981C4.49648 6.58433 4.82631 5.69887 5.42789 5.00879C6.02947 4.3187 6.86167 3.87118 7.76907 3.74981C7.7687 3.75355 7.7687 3.75732 7.76907 3.76106L9.73782 8.16731L7.80001 10.4867C7.78034 10.5093 7.76247 10.5335 7.74657 10.5589C7.60549 10.7754 7.52273 11.0246 7.5063 11.2825C7.48988 11.5404 7.54035 11.7981 7.65282 12.0307C8.5022 13.7679 10.2525 15.5051 12.0084 16.3536C12.2428 16.465 12.502 16.5137 12.7608 16.495C13.0196 16.4762 13.2692 16.3907 13.485 16.2467C13.5091 16.2305 13.5322 16.2129 13.5544 16.1942L15.8334 14.2498L20.2397 16.2232C20.2397 16.2232 20.2472 16.2232 20.25 16.2232C20.1301 17.1319 19.6833 17.9658 18.9931 18.5689C18.3028 19.172 17.4166 19.5029 16.5 19.4998Z"
                fill="white"></path>
            </svg>
          </div>
          <div class="ml-[18px]">
            <a href="tel:+911800123444" class="font-Inter text-[14px] font-medium text-white">+941133445566</a>
            <p class="font-Inter text-[12px] font-medium text-white">Support Number</p>
          </div>
        </div>
        <div class="mt-[23px] flex">
          <div class="flex h-[38px] w-[38px] items-center justify-center rounded-[75%]">
            <svg width="20" height="15" viewBox="0 0 20 15" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M19 0H1C0.801088 0 0.610322 0.0790178 0.46967 0.21967C0.329018 0.360322 0.25 0.551088 0.25 0.75V13.5C0.25 13.8978 0.408035 14.2794 0.68934 14.5607C0.970644 14.842 1.35218 15 1.75 15H18.25C18.6478 15 19.0294 14.842 19.3107 14.5607C19.592 14.2794 19.75 13.8978 19.75 13.5V0.75C19.75 0.551088 19.671 0.360322 19.5303 0.21967C19.3897 0.0790178 19.1989 0 19 0ZM10 7.98281L2.92844 1.5H17.0716L10 7.98281ZM7.25406 7.5L1.75 12.5447V2.45531L7.25406 7.5ZM8.36406 8.51719L9.48906 9.55312C9.62743 9.68014 9.80842 9.75062 9.99625 9.75062C10.1841 9.75062 10.3651 9.68014 10.5034 9.55312L11.6284 8.51719L17.0659 13.5H2.92844L8.36406 8.51719ZM12.7459 7.5L18.25 2.45438V12.5456L12.7459 7.5Z"
                fill="white"></path>
            </svg>
          </div>
          <div class="ml-[18px]">
            <a href="mailto:help@lorem.com" class="font-Inter text-[14px] font-medium text-[#fff]">help@abcrestaurant.com</a>
            <p class="font-Inter text-[12px] font-medium text-[#fff]">Support Email</p>
          </div>
        </div>
        <div class="mt-[23px] flex">
          <div class="flex h-[38px] w-[38px] items-center justify-center rounded-[75%]">
            <svg width="18" height="21" viewBox="0 0 18 21" fill="none" xmlns="http://www.w3.org/2000/svg">
              <path
                d="M9 4.5C8.25832 4.5 7.5333 4.71993 6.91661 5.13199C6.29993 5.54404 5.81928 6.12971 5.53545 6.81494C5.25162 7.50016 5.17736 8.25416 5.32205 8.98159C5.46675 9.70902 5.8239 10.3772 6.34835 10.9017C6.8728 11.4261 7.54098 11.7833 8.26841 11.9279C8.99584 12.0726 9.74984 11.9984 10.4351 11.7145C11.1203 11.4307 11.706 10.9501 12.118 10.3334C12.5301 9.7167 12.75 8.99168 12.75 8.25C12.75 7.25544 12.3549 6.30161 11.6517 5.59835C10.9484 4.89509 9.99456 4.5 9 4.5ZM9 10.5C8.55499 10.5 8.11998 10.368 7.74997 10.1208C7.37996 9.87357 7.09157 9.52217 6.92127 9.11104C6.75097 8.6999 6.70642 8.2475 6.79323 7.81105C6.88005 7.37459 7.09434 6.97368 7.40901 6.65901C7.72368 6.34434 8.12459 6.13005 8.56105 6.04323C8.9975 5.95642 9.4499 6.00097 9.86104 6.17127C10.2722 6.34157 10.6236 6.62996 10.8708 6.99997C11.118 7.36998 11.25 7.80499 11.25 8.25C11.25 8.84674 11.0129 9.41903 10.591 9.84099C10.169 10.2629 9.59674 10.5 9 10.5ZM9 0C6.81273 0.00248131 4.71575 0.872472 3.16911 2.41911C1.62247 3.96575 0.752481 6.06273 0.75 8.25C0.75 11.1938 2.11031 14.3138 4.6875 17.2734C5.84552 18.6108 7.14886 19.8151 8.57344 20.8641C8.69954 20.9524 8.84978 20.9998 9.00375 20.9998C9.15772 20.9998 9.30796 20.9524 9.43406 20.8641C10.856 19.8147 12.1568 18.6104 13.3125 17.2734C15.8859 14.3138 17.25 11.1938 17.25 8.25C17.2475 6.06273 16.3775 3.96575 14.8309 2.41911C13.2843 0.872472 11.1873 0.00248131 9 0ZM9 19.3125C7.45031 18.0938 2.25 13.6172 2.25 8.25C2.25 6.45979 2.96116 4.7429 4.22703 3.47703C5.4929 2.21116 7.20979 1.5 9 1.5C10.7902 1.5 12.5071 2.21116 13.773 3.47703C15.0388 4.7429 15.75 6.45979 15.75 8.25C15.75 13.6153 10.5497 18.0938 9 19.3125Z"
                fill="white"></path>
            </svg>
          </div>
          <div class="ml-[18px]">
            <a href="mailto:help@lorem.com" class="font-Inter text-[14px] font-medium text-[#fff]">Colombo 5,
              Sri Lanka, 123456</a>
            <p class="font-Inter text-[12px] font-medium text-white">Address</p>
          </div>
        </div>
      </div>
      <div class="mt-6 flex w-full flex-col justify-between text-white sm:flex-row md:mt-0 md:max-w-[341px]">
        <div class="">
          <p class="text-deutziawhite font-inter text-[18px] font-medium leading-normal">Pages</p>
          <ul>
            <li class="mt-[15px]"><a
                class="text-deutziawhite hover:text-deutziawhite/80 font-inter text-[15px] font-normal hover:font-semibold"
                href="/">Home</a></li>
            <li class="mt-[15px]"><a
                class="text-deutziawhite hover:text-deutziawhite/80 font-inter text-[15px] font-normal hover:font-semibold"
                href="/our-tutors">Conatct</a></li>
            <li class="mt-[15px]"><a
                class="text-deutziawhite hover:text-deutziawhite/80 font-inter text-[15px] font-normal hover:font-semibold"
                href="/become-a-tutor">Gallery</a></li>
            <li class="mt-[15px]"><a
                class="text-deutziawhite hover:text-deutziawhite/80 font-inter text-[15px] font-normal hover:font-semibold"
                href="/plans-and-pricing">Plans and pricing</a></li>
            <li class="mt-[15px]"><a
                class="text-deutziawhite hover:text-deutziawhite/80 font-inter text-[15px] font-normal hover:font-semibold"
                href="/terms-and-conditions">Terms and conditions</a></li>
            <li class="mt-[15px]"><a
                class="text-deutziawhite hover:text-deutziawhite/80 font-inter text-[15px] font-normal hover:font-semibold"
                href="/privacy-policy">Privcay policy</a></li>
          </ul>
        </div>
        <div class="mt-6 flex flex-col gap-4 sm:mt-0">
          <p class="text-deutziawhite font-inter text-[18px] font-medium">App will be released Soon.....</p>
          <div class="flex gap-4 sm:flex-col">
            <a target="_blank"
              href="#"><img alt="facebook icon" loading="lazy" width="168" height="50" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/google-store.svg" /></a><a
              target="_blank"
              href="#"><img alt="facebook icon" loading="lazy" width="168" height="50" decoding="async" data-nimg="1" style="color:transparent" src="https://www.englishyaari.com/img/apple-store.svg" /></a>
          </div>
        </div>
      </div>
    </div>
    <hr class="mt-[30px] text-white" />
    <div class="flex items-center justify-center pb-8 pt-[9px] md:py-8">
      <p class="text-[10px] font-normal text-white md:text-[12px]">
        © Copyright
        <!-- -->2024
        <!-- -->, All Rights Reserved by ABCREstaurant. PVT. LTD
      </p>
    </div>
  </div>
</div>
 

<style>
    .video-docker video {
        top: 50%;
        left: 50%;
        transform: translate(-50%, -50%);
    }

    .video-docker::after {
        content: "";
        position: absolute;
        width: 100%;
        height: 100%;
        top: 0;
        left: 0;
        background: rgba(0, 0, 0, 0.6);
        z-index: 1;
    }
</style>

<script>
    document.getElementById('scrollBtn').addEventListener('click', scrollToDiv);
    document.getElementById('scrollBtn2').addEventListener('click', scrollToNextDiv);
    document.getElementById('scrollBtn3').addEventListener('click', scrollToNextOtherDiv);

</script>

		

<script src="https://unpkg.com/flowbite@1.4.1/dist/flowbite.js"></script>
</body>
</html>