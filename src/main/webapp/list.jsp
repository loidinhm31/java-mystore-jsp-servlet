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
<c:forEach var="product" items="${productList}">
    <%-- Create URL for the product --%>
    <c:url value="/infoproduct?id=${product.id}" var="infoproduct"/>
    
    <!-- Product Section -->
    <div class="card col-md-4 shadow">
    
        <a class="item" href="${infoproduct}">
            <div class="card-body">
                    <%-- Format price --%>
                <fmt:formatNumber currencySymbol="$" value="${product.price}" 
                                  type="currency" var="price"/>
                <h5><c:out value="${product.type}"/></h5>
                <p class="cart-title">${product.name}</p>
                <p class="card-text">${price}</p>
            </div>
            <div class="card-img">
                <img src="${product.src}">
            </div>
        </a>
    </div>
</c:forEach>

