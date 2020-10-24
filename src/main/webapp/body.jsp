<%-- 
    Document   : body
    Created on : Oct 16, 2020
    Author     : Loi Dinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row">
        <!-- Item Section -->
        <div class="leftcolumn col-sm-8">
            <div class="row">
                <c:import url="/list"/>
            </div>
        </div>
       
        <!-- Cart And Popular Banner -->        
        <div class="rightcolumn col-sm-4">
            <div class="card container shadow">
                <div class="card-body row">
                    <div class="col-sm-4">
                        <h2 class="card-title">Shopping cart</h2>
                    <img  src="${pageContext.request.contextPath}/resources/media/shopping_cart-black-48dp.svg">
                    </div>
                    
                    <div class="col-sm-8">
                        <p>You have: ${cart.getItems().size()} product(s) in your cart</p>
                        <p class="card-title">Total amount: ${cart.getAmount()}</p>
                        <a class="btn btn-primary stretched-link" href="${pageContext.request.contextPath}/cart.jsp">Go to your Cart</a>
                    </div>
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