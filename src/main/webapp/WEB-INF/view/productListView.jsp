<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


<%-- Get list of products --%>
<c:set var="productList" value="${PRODUCTS}" />




<%-- Check EMPTY LIST --%>
<c:choose>

	<c:when test="${empty productList}">
		<div class="card shadow mx-auto my-5">
			<div class="card-body">
				<h3 class="text-center">
					SORRY! No results were found matching the keyword: "
					<c:out value="${param.search}" />
					"
				</h3>
			</div>
		</div>
	</c:when>


	<c:otherwise>
		<%-- Loop through the list --%>
		<c:forEach var="product" items="${productList}">
			<%-- Create URL for the product --%>
			<c:url value="" var="detailProduct" />

			
				<!-- Product Section -->
				<div class="col-md-3 my-1">
					<div class="card shadow">

						<div class="card-body">

							<h5 class="cart-title text-center">
								<b><c:out value="${product.productName}" /></b>
							</h5>

						</div>


						<div class="card-body">
							<%-- Create URL image for product --%>
							<c:url var="productSrc"
								value="/resources/product/${product.productSrc}" />

							<img class="card-img" src="${productSrc}" alt="${productSrc}" />
						</div>

						<div class="card-body">
							<h6>
								<c:out value="${product.productDescription}" />
							</h6>

							<%-- Format price --%>
							<fmt:formatNumber currencySymbol="$"
								value="${product.productPrice}" type="currency"
								var="productPriceFormatter" />

							<p class="card-text text-danger font-weight-bold">
								<c:out value="${productPriceFormatter}" />
							</p>
							<p class="text-muted">
								<c:out value="${product.productStock}" />
								unit(s) in stock
							</p>
						</div>


						<!-- Button -->
						<div class="card-footer">
							<div class="row">


								<div class="col-md-5">

									<%-- Create URL for the product (noted by DetailProductServlet) --%>
									<c:url
										value="/detail-product?product-code=${product.productSKU}"
										var="detailProduct" />
									<span class="badge badge-pill badge-success"> <a
										class="text-light text-decoration-none"
										href="${detailProduct}"> <img
											src="${pageContext.request.contextPath}/resources/media/info-white-18dp.svg" />
											Detail
									</a>

									</span>

								</div>

								<div class="col-md-7">
									<%-- Create URL for the product (noted by ActionOnProductInCartServlet) --%>
									<c:url
										value="/action-cart?action=add&product-code=${product.productSKU}"
										var="addProductToCart" />
									<span class="badge badge-pill badge-danger"> <a
										class="text-light text-decoration-none"
										href="${addProductToCart}"> <img
											src="${pageContext.request.contextPath}/resources/media/shopping_cart-white-18dp.svg" />
											Order Now
									</a>

									</span>
								</div>
							</div>

						</div>
					</div>
				</div>
		
		</c:forEach>
	</c:otherwise>
</c:choose>

