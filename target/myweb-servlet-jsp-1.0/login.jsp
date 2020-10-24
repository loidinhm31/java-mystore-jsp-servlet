<%-- 
    Document   : login
    Created on : Oct 16, 2020
    Author     : Loi Dinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
        <link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet" type="text/css"/>
    </head>
    <body>
        <%
            String error = "";
            if (session.getAttribute("error") != null) {
                error = (String) session.getAttribute("error");
            }
        %>
        <div class="login">
            <h1>Sign in</h1>
            <!-- Display login error -->
            <p class="login-error"><%= error  %></p><br>
            <form class="login-form" action="${pageContext.request.contextPath}/login" method="POST">
                <label for="username">Username</label><br>
                <input type="text" name="username"><br>
                <label for="password">Password</label><br>
                <input type="password" name="password"><br>
                <a href="#">Forgot your password?</a><br>
                
                <input type="checkbox" name="remember">
                <label for="remember">Remember me</label><br>
                
                <input type="submit" value="Login">
            
            </form>  
        </div>
        <div class ="display">
            <h1>Welcome Back!</h1>
            <p>To keep connected with us please login with your personal info</p>
            
        </div>
            
        <%-- Footer --%>
        <c:import url="footer.jsp"/>
        
           