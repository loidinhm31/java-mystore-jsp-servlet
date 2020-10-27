<%-- 
    Document   : login
    Created on : Oct 16, 2020
    Author     : Loi Dinh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Header Section --%>
<c:import url="/jsp/header.jsp">
    <c:param name="title" value="My Website - Login"/>
</c:import>

<!-- Body Section -->
<div>
<div class="container-fluid pb-5 mb-5">
    <div class="row my-3">
        <div class="col-md-6 text-center">
            <h1>Sign in</h1>
            <!-- Display login error -->
            <p class="text-danger font-italic"><c:out value="${error}"/></p><br>
            <!-- Login form -->
            <form class="form-signin" action="${pageContext.request.contextPath}/login" method="POST">
                <label for="inputEmail" class="sr-only">Username</label>
                <input type="email" id="inputEmail" name="username" class="form-control" placeholder="Email address" required="" autofocus="">
                <label for="inputPassword" class="sr-only">Password</label>
                <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required="">
                <div class="checkbox mb-3">
                    <label>
                        <input type="checkbox" value="remember-me"> Remember me
                    </label>
                 </div>
                  <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
                  <p class="mt-5 mb-3 text-muted">&copy 2020-2021</p>
            </form>


            <p>Or <a href="#">Forgot password</a></p>
            <p>Don't have account? <a href="${pageContext.request.contextPath}/jsp/signup.jsp">Sign Up</a><br>

        </div>
        <div class ="col-md-6">
            <div class="card card-box shadow">
                <h1 class="text-center">Welcome Back!</h1>
                <p class="text-center">To keep connected with us please login with your personal info</p>
            </div>

        </div>
    </div>
</div>
</div>
            
<%-- Footer Section --%>
<c:import url="/jsp/footer.jsp"/>
        
           