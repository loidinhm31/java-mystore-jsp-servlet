<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- Navigation bar -->
<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
	<a class="navbar-brand" href="${pageContext.request.contextPath}">Navbar
		LOGO</a>
	<button class="navbar-toggler" type="button" data-toggle="collapse"
		data-target="#navbarNav" aria-controls="navbarNav"
		aria-expanded="false" aria-label="Toggle navigation">
		<span class="navbar-toggler-icon"></span>
	</button>

	<div class="collapse navbar-collapse" id="navbarNav">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link"
				href="${pageContext.request.contextPath}"> Home <span
					class="sr-only">(current)</span>
			</a></li>
			<li class="nav-item dropdown"><a
				class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
				role="button" data-toggle="dropdown" aria-haspopup="true"
				aria-expanded="false"> Products </a>
				<div class="dropdown-menu" aria-labelledby="navbarDropdown">
					<a class="dropdown-item" href="#">Action</a> <a
						class="dropdown-item" href="#">Another action</a>
					<div class="dropdown-divider"></div>
					<a class="dropdown-item" href="#">Something else here</a>
				</div></li>
			<li class="nav-item"><a class="nav-link" href="">About Us</a></li>

		</ul>


		<!-- Search -->
		<form class="form-inline my-2 my-lg-0"
			action="${pageContext.request.contextPath}">
			<%-- EL here to see what key searched --%>
			<input class="form-control mr-sm-2" name="key" type="search"
				placeholder="Search" aria-label="Search" value="${param.key}">
			<button class="btn btn-outline-warning my-2 my-sm-0" type="submit">Search</button>
		</form>

		<!-- Cart -->
		<a class="my-2 my-lg-0 nav-link"
			href="${pageContext.request.contextPath}/cart"> <img
			src="${pageContext.request.contextPath}/resources/media/shopping_cart-white-24dp.svg">
			<!-- Display quantity of products in the cart --> <span
			class="badge badge-light"><c:out
					value="${cart.getItems().size()}" /></span>
		</a>

		<c:choose>
			<c:when test="${empty loginedUser}">
				<ul class="navbar-nav">

					<!-- Login -->
					<li class="nav-item"><a class="nav-link"
						href="${pageContext.request.contextPath}/login">Login</a></li>

					<!-- Sign up -->
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/signup">Sign
							Up</a></li>
				</ul>
			</c:when>
			<c:otherwise>


				<ul class="navbar-nav">

					<!-- User Name -->
					<li class="nav-item"><a class="navbar-brand">${loginedUser.userName}</a>
					</li>

					<!-- Log out -->
					<li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/logout?action=logout">Log
							out</a></li>
				</ul>
			
				
				
				
			</c:otherwise>
		</c:choose>

	</div>
</nav>
