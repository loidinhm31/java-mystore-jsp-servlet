<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<%-- Header Section --%>
<c:import url="_header.jsp">
	<c:param name="title" value="My Store - Login" />
</c:import>

<!-- Body Section -->
<div class="container-fluid pb-5 mb-5">
	<div class="row my-3">
		<div class="col-md-6 text-center">
			<h1>Sign in</h1>
			<!-- Display login error -->
			<p class="text-danger font-italic">
				<c:out value="${errorString}" />
			</p>
			<br>
			<!-- Login form -->
			<form class="form-signin"
				action="${pageContext.request.contextPath}/login" method="POST">
				<label for="inputEmail" class="sr-only">Your Email</label> <input
					type="email" id="inputEmail" name="user-email" class="form-control"
					placeholder="Email address" required autofocus> <label
					for="inputPassword" class="sr-only">Password</label> <input
					type="password" id="inputPassword" name="password"
					class="form-control" placeholder="Password" required>
				<div class="checkbox mb-3">
					<label> <input type="checkbox" name="remember-me" value="Y">
						Remember me
					</label>
				</div>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Sign
					in</button>
				<p class="mt-5 mb-3 text-muted">&copy 2020-2021</p>
			</form>


			<p>
				Or <a href="#">Forgot password</a>
			</p>
			<p>
				Don't have account? <a
					href="${pageContext.request.contextPath}/signup">Sign
					Up</a><br>
		</div>
		<div class="col-md-6">
			<div class="card card-box shadow">
				<h1 class="text-center">Welcome Back!</h1>
				<p class="text-center">To keep connected with us please login
					with your personal info</p>
			</div>

		</div>
	</div>
</div>


<%-- Footer Section --%>
<c:import url="_footer.jsp" />
