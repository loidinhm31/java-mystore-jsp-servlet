<%-- 
    Document   : infoproduct
    Created on : Oct 20, 2020
    Author     : Loi Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>


<%-- Header Section --%>
<c:import url="/jsp/header.jsp">
    <c:param name="title" value="My Web Shop - ${product.type}" />
</c:import> 


<!-- Body Section -->

<%-- Get Product --%>
<c:set var="product" value="${PRODUCT}"/>
<%-- Create URL for the product (noted by InformationProductController) --%>
<c:url value="/AddToCartController?action=add&id=${product.id}" var="infocart"/>
<div class="container-fluid">
    <div class="row mt-5 ml-3">
        <h1><c:out value="${product.name}"/></h1>
    </div>
    <div class="row mx-auto my-5">
        <div class="col-sm-5">
            <div class="card-body">
                <%-- Create URL image for product --%>
                <c:url var="productSrc" value="${product.src}"/>
                <img class="card-img" src="${productSrc}">
            </div>
        </div>
        <div class="col-sm-4 mx-auto card-body">
            <%-- Format price --%>
                    <fmt:formatNumber currencySymbol="$" value="${product.price}" 
                                          type="currency" var="productPrice"/>
            <h2>Price: <c:out value="${productPrice}"/></h2>
            
            <p>${product.description}</p>
            <a href="${infocart}" class="btn btn-warning">Add to cart</a>
        </div>
        
    </div>

</div>

<%-- Footer Section --%>
<c:import url="/jsp/footer.jsp"/>