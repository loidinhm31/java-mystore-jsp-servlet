<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- Get Product --%>
<c:set var="product" value="${PRODUCT}" />

<%-- Header Section --%>
<c:import url="_header.jsp">
	<c:param name="title" value="Mobile Store - ${product.productCategory}" />
</c:import>


<!-- Body Section -->


<%-- Menu Section --%>
<c:import url="_menu.jsp" />

<div class="container-fluid">
	<div class="row mt-5 ml-3">
		<c:set var="productName" value="${product.productName}" />
		<h1>${productName}</h1>
	</div>
	
	<div class="row mx-auto my-5">
		<div class="col-sm-4">
			<div class="card-body">
				<%-- Create URL image for product --%>
				<c:url var="productSrc"
					value="/resources/product/${product.productSKU}.png" />
				<img class="card-img" src="${productSrc}" alt="${productSKU}">
			</div>
		</div>

		<div class="col-sm-4 mx-auto card-body">

			<p>
				<c:out value="${product.productDescription}" />
			</p>
			
			<p>
				<b>SKU: </b>
				<c:out value="${product.productSKU}" />
			</p>
						
			<p>
				<b>Category: </b>
				<c:out value="${product.productCategory}" />
			</p>

			<p>
				<b>Available: </b>
				<c:out value="${product.productStock}" />
			</p>
			
			
			
			<%-- Format price --%>
			<fmt:formatNumber currencySymbol="$" value="${product.productPrice}"
				type="currency" var="productPriceFormatter" />
			<h2>
				<b>Price: </b>
				<c:out value="${productPriceFormatter}" />
			</h2>
			
			<div class="row">
				<div class="col-2">
					<a href="${pageContext.request.contextPath}" class="badge badge-success">
					<img src="${pageContext.request.contextPath}/resources/media/keyboard_backspace-white-24dp.svg" /> 
					Back </a>
				</div>


				<%-- Create URL for the product (noted by ActionOnProductInCartServlet) --%>
				<c:url
					value="/action-cart?action=add&product-code=${product.productSKU}"
					var="addProductToCart" />

				<div class="col-5">
					<a href="${addProductToCart}" class="badge badge-danger"> <img
						src="${pageContext.request.contextPath}/resources/media/shopping_cart-white-24dp.svg" />
						Order Now
					</a>
				</div>
			</div>
		</div>

	</div>

</div>

<%-- Footer Section --%>
<c:import url="_footer.jsp" />

</html>