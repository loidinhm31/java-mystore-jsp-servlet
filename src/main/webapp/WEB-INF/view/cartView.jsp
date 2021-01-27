<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<%-- Header Section --%>
<c:import url="_header.jsp">
	<c:param name="title" value="Mobile Store - Shopping Cart" />
</c:import>

<%-- Menu Section --%>
<c:import url="_menu.jsp" />

<c:set var="items" value="${cart.getItems()}" />

<div class="container-fluid">
	<div class="row mx-1 mt-3 justify-content-between">
		<%-- Create URL for the product (noted by ActionOnProductInCartServlet) --%>
		<c:url value="/action-cart?action=clear" var="clearProductInCart" />
		<div class="col-md-3">
			<a class="btn btn-lg btn-danger btn-block"
				href="${clearProductInCart}"> <img
				src="${pageContext.request.contextPath}/resources/media/cancel-white-24dp.svg" />
				Clear Cart
			</a>
		</div>


		<div class="col-md-3">
			<a href="${pageContext.request.contextPath}"
				class="btn btn-lg btn-success btn-block"> <img
				src="${pageContext.request.contextPath}/resources/media/shopping_cart-white-24dp.svg" />
				Keep Shopping
			</a>
		</div>


	</div>
	<div class="row mx-3 my-2">

		


		<table class="table table-stripped">
			<thead class="thead-dark">
				<tr>
					<th class="th-sm" scope="col">#</th>
					<th class="th-sm" scope="col">Products in cart: <c:out
							value="${items.size()}" /></th>
					<th class="th-sm" scope="col">Quantity</th>

					<th class="th-sm" scope="col">Unit Price</th>

					<th class="th-sm" scope="col">Price</th>

					<th class="th-sm" scope="col">Action</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="product" items="${items}">
					<tr>
						<th scope="row"><c:out value="${items.indexOf(product) + 1}" /></th>
						<td>
							<div class="row">
								<div class="col-2">
									<%-- Create URL image for product --%>
									<c:url var="productSrc"
										value="/resources/product/${product.productSrc}" />
									<img class="card-img" src="${productSrc}">
								</div>
								<div class="col-5">
									<p>
										<c:out value="${product.productName}" />
									</p>
									<p>
										SKU:
										<c:out value="${product.productSKU}" />
									</p>
								</div>

							</div>

						</td>

						<td><c:out value="${product.inCartQuantity}" /></td>

						<%-- Format price --%>
						<fmt:formatNumber currencySymbol="$"
							value="${product.productPrice}" type="currency"
							var="productPrice" />
						<td><c:out value="${productPrice}" /></td>


						<%-- Format price --%>
						<fmt:formatNumber currencySymbol="$"
							value="${product.productPrice * product.inCartQuantity}"
							type="currency" var="productTotalPrice" />
						<td><c:out value="${productTotalPrice}" /></td>


						<%-- Create URL for the product (noted by ActionOnProductInCartServlet) --%>
						<c:url
							value="/action-cart?action=delete&product-code=${product.productSKU}"
							var="deleteProductFromCart" />

						<td><span class="badge badge-pill badge-danger"> <a
								class="text-light text-decoration-none"
								href="${deleteProductFromCart}"> <img
									src="${pageContext.request.contextPath}/resources/media/close-white-18dp.svg" />
									Remove
							</a>

						</span></td>

					</tr>
				</c:forEach>

				<tr>
					<th scope="row"></th>
					<td colspan="2"></td>

					<%-- Format price --%>
					<fmt:formatNumber currencySymbol="$"
						value="${cart.getTotalPrice()}" type="currency" var="totalPrice" />
					<td><b>GRAND TOTAL</b></td>
					<td><c:out value="${totalPrice}" /></td>
				</tr>


			</tbody>
		</table>
	</div>

	<div class="row mx-5 my-3">

		<div class="col-3">


			<%-- Check EMPTY cart --%>
			<c:choose>
				<c:when test="${not empty cart}">
					<form action="${pageContext.request.contextPath}/payment"
						method="POST">

						<a onclick="this.parentNode.submit();"
							class="btn btn-lg btn-success btn-block text-light"> <img
							src="${pageContext.request.contextPath}/resources/media/payment-white-24dp.svg" />
							Checkout
						</a>

					</form>
				</c:when>
				<c:otherwise>
					<a href="${pageContext.request.contextPath}"
						class="btn btn-lg btn-success btn-block my-2"> <img
						src="${pageContext.request.contextPath}/resources/media/shopping_cart-white-24dp.svg" />
						Keep Shopping
					</a>
				</c:otherwise>
			</c:choose>


		</div>


	</div>
</div>

<%-- Footer Section --%>
<c:import url="_footer.jsp" />
