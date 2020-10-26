<%-- 
    Document   : infoproduct
    Created on : Oct 20, 2020
    Author     : Loi Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
<c:import url="header.jsp">
    <c:param name="title" value="My Web Shop"/>
</c:import> 

<%-- Get Product --%>
<c:set var="product" value="${PRODUCT}"/>
<%-- Create URL for the product (noted by InformationProductController) --%>
<c:url value="/AddToCartController?action=add&id=${product.id}" var="infocart"/>


<div class="container-fluid">
    <div class="row mt-5 ml-3">
        <h1>${product.name}</h1>
    </div>
    <div class="row mx-auto my-5">
        <div class="col-sm-5">
            <div class="card-body">
                <img class="card-img" src="${product.src}">
            </div>
        </div>
        <div class="col-sm-4 mx-auto card-body">
            <h2>Price: ${product.price}</h2>
            <p>${product.description}</p>
            <a href="${infocart}" class="btn btn-warning">Add to cart</a>
        </div>
        
    </div>

</div>


<c:import url="footer.jsp"/>