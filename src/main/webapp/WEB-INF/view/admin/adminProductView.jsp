<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="productList" value="${PRODUCTS}" />


<div class="container mt-3">
	<div class="row">
		<!-- Product Section -->
		<table class="table table-stripped">
			<thead class="thead-dark">
				<tr>
					<th class="th-sm" scope="col">#</th>
					<th class="th-sm" scope="col">Total Products: <c:out
							value="${productList.size()}" /></th>
					<th class="th-sm" scope="col">In Stock</th>

					<th class="th-sm" scope="col">Price</th>

					<th class="th-sm" scope="col">Manufacturer</th>

					<th class="th-sm" scope="col">Category</th>

					<th class="th-sm" scope="col">Cond.</th>

					<th class="th-sm" scope="col">Description</th>
				</tr>
			</thead>


			<tbody>
				<c:forEach var="product" items="${productList}">
					<tr>
						<th scope="row"><c:out
								value="${productList.indexOf(product) + 1}" /></th>
						<td>

							<div class="col-7">
								<%-- Create URL image for product --%>
								<c:url var="productSrc"
									value="/resources/product/${product.productSrc}" />
								<img class="card-img" src="${productSrc}">
							</div>
							<div class="row">
								<p>
									<b><c:out value="${product.productName}" /></b>
								</p>
								<p>
									<b>SKU: </b>
									<c:out value="${product.productSKU}" />
								</p>
							</div>



						</td>


						<td><c:out value="${product.productStock}" /></td>

						<%-- Format price --%>
						<fmt:formatNumber currencySymbol="$"
							value="${product.productPrice}" type="currency"
							var="productPrice" />
						<td><c:out value="${productPrice}" /></td>

						<td><c:out value="${product.productManufacturer}" /></td>

						<td><c:out value="${product.productCategory}" /></td>

						<td><c:choose>
								<c:when test="${product.productCondition == 1}">
									<p>New</p>
								</c:when>
								<c:when test="${product.productCondition == 2}">
									<p>Old</p>
								</c:when>
								<c:when test="${product.productCondition == 3}">
									<p>Refurbished</p>
								</c:when>
							</c:choose></td>


						<td><c:out value="${product.productDescription}" /></td>
					</tr>

				</c:forEach>
			</tbody>





		</table>


	</div>









</div>



