<%-- 
    Document   : search
    Created on : Oct 24, 2020, 12:48:07 PM
    Author     : Loi Dinh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp">
    <c:param name="title" value="Search Results"/>
</c:import>

<div class="container-fluid">
    <div class="row">
        <%-- Get list of products --%>
        <c:set var="productList" value="${PRODUCTS}"/>
        
        <%-- Check EMPTY LIST --%>
        <c:choose>
            <c:when test="${empty productList}">
                <div class="card shadow mx-auto my-5">
                    <h1 style="color:red; text-align: center">SORRY! No results were found matching the keyword: "${param.key}" </h1> 
                </div>
                
            </c:when>
            <c:otherwise>
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
            </c:otherwise>
        </c:choose>
        
    </div>
</div>
<c:import url="footer.jsp"/>