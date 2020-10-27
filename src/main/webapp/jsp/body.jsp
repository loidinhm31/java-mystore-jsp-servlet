<%-- 
    Document   : body
    Created on : Oct 16, 2020
    Author     : Loi Dinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="container-fluid mb-5 pb-5">
    <div class="row my-2">
        <!-- Item Section -->
        <div class="leftcolumn col-sm-8">
            <div class="row">
                <c:import url="/ListController"/>
            </div>
        </div>
       
        <!-- Cart And Popular Banner -->        
        <div class="rightcolumn col-sm-4">
            <div class="card shadow">
                <div class="card-body row">
                    <div class="col-sm-5">
                        <h6>Shopping cart</h6>
                        <img src="${pageContext.request.contextPath}/resources/media/shopping_cart-black-48dp.svg">
                    </div>
                    <div class="col-sm-6">
                        <p>You have: <c:out value="${cart.getItems().size()}"/> product(s) in your cart</p>
                        
                        <%-- Format price --%>
                        <fmt:formatNumber currencySymbol="$" value="${cart.getAmount()}" 
                                          type="currency" var="totalAmount"/>
                        <p class="card-title">Total amount: <c:out value="${totalAmount}"/> </p>
                    </div>
                    <a class="btn btn-primary mx-auto" href="${pageContext.request.contextPath}/jsp/cart.jsp">Go to your Cart</a>
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