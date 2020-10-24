<%--
    Document   : list.jsp
    Created on : Oct 23, 2020
    Author     : Loi Dinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

   





<%-- Get list of products --%>
<c:set var="productList" value="${PRODUCTS}"/>
<%-- Loop through the list --%>
<c:forEach var="product" items="${productList}" varStatus="row">

    <!-- Product Section -->

    <div class="card col-md-4 shadow">
        <div class="card-body">
                <%-- Format price --%>
            <fmt:formatNumber currencySymbol="$" value="${product.price}" 
                              type="currency" var="price"/>
            <h5><c:out value="${product.type}"/></h5>
            <h2>${product.name}</h2>
            <p class="product-price">${price}</p>
        </div>
        <div class="product-img">
            <img src="${product.src}">
        </div>
        <p class="card-text">${product.description}</p>
    </div>
</c:forEach>

