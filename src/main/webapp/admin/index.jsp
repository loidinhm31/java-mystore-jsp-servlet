<%-- 
    Document   : index
    Created on : Oct 21, 2020
    Author     : Dawn
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Page</title>
        <link href="index.css" rel="stylesheet" type="text/css">
        <link href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
       
        
        <div class="container-fluid">
            <div class="row mx-1 my-2 ">
                <div class="card shadow">
                    <h5 class=" card-body card-title">Hello, ${user.name} </h5>
                </div>
                
            </div>
            
            
            <div class="row">
                <nav class="col-md-3 d-none d-md-block bg-light sidebar">
                    <div class="sidebar-sticky">
                        <ul class="nav flex-column">
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-home"><path d="M3 9l9-7 9 7v11a2 2 0 0 1-2 2H5a2 2 0 0 1-2-2z"></path><polyline points="9 22 9 12 15 12 15 22"></polyline></svg>
                                    Dashboard
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-file"><path d="M13 2H6a2 2 0 0 0-2 2v16a2 2 0 0 0 2 2h12a2 2 0 0 0 2-2V9z"></path><polyline points="13 2 13 9 20 9"></polyline></svg>
                                    Orders
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link active" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-shopping-cart"><circle cx="9" cy="21" r="1"></circle><circle cx="20" cy="21" r="1"></circle><path d="M1 1h4l2.68 13.39a2 2 0 0 0 2 1.61h9.72a2 2 0 0 0 2-1.61L23 6H6"></path></svg>
                                    Products
                                </a>
                            </li>
                            <li class="nav-item">
                                <a class="nav-link" href="#">
                                    <svg xmlns="http://www.w3.org/2000/svg" width="24" height="24" viewBox="0 0 24 24" fill="none" stroke="currentColor" stroke-width="2" stroke-linecap="round" stroke-linejoin="round" class="feather feather-users"><path d="M17 21v-2a4 4 0 0 0-4-4H5a4 4 0 0 0-4 4v2"></path><circle cx="9" cy="7" r="4"></circle><path d="M23 21v-2a4 4 0 0 0-3-3.87"></path><path d="M16 3.13a4 4 0 0 1 0 7.75"></path></svg>
                                    Customers
                                </a>
                            </li>
                            
                        </ul>
                    </div>        
                </nav>
 
                <main class="col-md-9">

                    <div class="row mx-2">
                        <form class="form-inline my-2 my-lg-0" action="${pageContext.request.contextPath}/SearchController">
                            <input class="form-control mr-sm-2" name="search" type="search" placeholder="Search" aria-label="Search">
                            
                            <button class="btn btn-warning my-2 my-sm-0" type="submit">Search</button>
                        </form>
                      
                    </div>
                    <div class="row mx-2 my-2">
                        <c:import url="../list.jsp"/>
                        
                    </div>        
                </main>
            </div>     
        </div>                 
    </body>
</html>
