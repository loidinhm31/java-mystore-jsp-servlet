<%--
    Document   : list.jsp
    Created on : Oct 23, 2020
    Author     : Loi Dinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%-- Get list of products --%>
<c:set var="productList" value="${PRODUCTS}"/>   



<%-- Check EMPTY LIST --%>
<c:choose>
    
    <c:when test="${empty productList}">
        <div class="card shadow mx-auto my-5">
            <div class="card-body">
                <h3 class="text-center">SORRY! No results were found matching the keyword: "<c:out value="${param.search}"/>" </h3> 
            </div>
        </div>
    </c:when>
    <c:otherwise>
        <%-- Loop through the list --%>
        <c:forEach var="product" items="${productList}">
            <%-- Create URL for the product --%>
            <c:url value="/infoproduct?id=${product.id}" var="infoproduct"/>

            <!-- Product Section -->
            <div class="card col-md-4 shadow">
                <a class="text-decoration-none stretched-link item" href="${infoproduct}">
                    <div class="card-body">
                        <%-- Format price --%>
                        <fmt:formatNumber currencySymbol="$" value="${product.price}" 
                                          type="currency" var="price"/>
                        <p class="text-muted"><c:out value="${product.type}"/></p>
                        <h5 class="cart-title text-info"><c:out value="${product.name}"/></h5>
                        <p class="card-text text-danger font-weight-bold"><c:out value="${price}"/></p>
                    </div>
                    <div class="my-3">
                        <img class="card-img" src="${product.src}">
                    </div>
                </a>
            </div>
        </c:forEach>
    </c:otherwise>
</c:choose>






