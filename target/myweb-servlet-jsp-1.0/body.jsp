<%-- 
    Document   : body
    Created on : Oct 16, 2020
    Author     : Loi Dinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<div class="container-fluid">
    <div class="row">
        <div class="leftcolumn col-sm-8">
            <div class="row">
                <c:import url="/list"/>
            </div>
        </div>
       

        <div class="rightcolumn col-sm-4">
            <div class="card shadow-">
                <div class="card-body">
                    <h2>Shopping cart</h2>
                    <div class="fakeimg" ">Cart</div>
                    <p>Summary information of your cart can be displayed here</p>
                </div>

            </div>
            <div class="card shadow-">
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