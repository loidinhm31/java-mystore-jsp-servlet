<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<div class="container-fluid mb-5 pb-5">
	<div class="row my-2">
		<!-- Item Section -->
		<div class="leftcolumn col-sm-10">
			<div class="row">
				<%-- List of Product Section --%>
				<c:import url="/product" />

			</div>
		</div>


		<!-- Cart And Popular Banner -->
		<div class="rightcolumn col-sm-2">
			<div class="card shadow">
				<div class="card-body row">
					<div class="col-sm-6">
						<h6>Shopping cart</h6>
						<img
							src="${pageContext.request.contextPath}/resources/media/shopping_cart-black-48dp.svg">
					</div>
					<div class="col-sm-6">
						<p>
							You have:
							<c:out value="${cart.getItems().size()}" />
							product(s) in your cart
						</p>

						<%-- Format price --%>
						<fmt:formatNumber currencySymbol="$" value="${cart.getTotalPrice()}"
							type="currency" var="totalPrice" />
						<p class="card-title">
							<b>Total Price: </b>
							<c:out value="${totalPrice}" />
						</p>
					</div>
					<a class="btn btn-primary mx-auto"
						href="${pageContext.request.contextPath}/cart">Go to
						your Cart</a>
				</div>

			</div>
			<div class="card shadow">
				<div class="card-body">
					<h3>Popular products or banners</h3>
					<div class="fakeimg">
						<p>Image</p>
					</div>
					<div class="fakeimg">
						<p>Image</p>
					</div>
					<div class="fakeimg">
						<p>Image</p>
					</div>
				</div>
			</div>
		</div>
	</div>
</div>


