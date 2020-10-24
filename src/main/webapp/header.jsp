<%-- 
    Document   : header
    Created on : Oct 16, 2020
    Author     : Loi Dinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${param.title}</title>
        <link href="${pageContext.request.contextPath}/resources/css/home.css" rel="stylesheet" type="text/css"/>
        <link href="webjars/bootstrap/4.5.0/css/bootstrap.min.css" rel="stylesheet"/>
    </head>
    <body>
        <div class="header">
            <h1>My Website</h1>
            <p>Logo should be inserted here</p>
        </div>

        <div class="topnav">
            <a href="${pageContext.request.contextPath}">Home</a>
            <a href="#">Products</a>
            <a href="#">About Us</a>
            <!-- Login -->
            <a href="${pageContext.request.contextPath}/login.jsp" style="float:right">Login</a>

            <!-- Search -->
            <form action="${pageContext.request.contextPath}/UserSearchController">
                <input type="text" name="key" placeholder="Search..." style="float:right">
            </form>
            <!-- Cart -->
            <a href="${pageContext.request.contextPath}/cart.jsp" style="float:right">
                <img src="${pageContext.request.contextPath}/resources/media/shopping_cart-white-24dp.svg"/>
            </a>
        </div>