<%-- 
    Document   : cart
    Created on : Oct 20, 2020
    Author     : Loi Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
<c:import url="header.jsp">
    <c:param name="title" value="My Web Shop - Shopping Cart"/>
</c:import> 


<c:set var="items" value="${cart.getItems()}"/>

<div class="container-fluid">
    <div class="row mx-3 my-5">
        <table class="table table-stripped">
            <thead class="thead-dark">
                <tr>
                    <th class="th-sm" scope="col">#</th>
                    <th class="th-sm" scope="col">Products in cart: ${cart.getItems().size()}</th>
                    <th class="th-sm" scope="col">Price</th>
                    <th class="th-sm" scope="col">Quantity</th>
                    <th class="th-sm" scope="col">Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${items}">
                <tr>
                    <th scope="row">${items.indexOf(product)+1}</th>
                    <td>
                        <div class="row">
                            <div class="col-2">
                                <img class="card-img" src="${product.src}">
                            </div>
                            <div class="col-5">
                                <p>${product.name}</p>
                                <p>ID: ${product.id}</p>
                            </div>
                            
                        </div>
                        
                    </td>
                    <td>${product.price}</td>
                    <td>${product.quantity}</td>
                    <td>${product.price * product.quantity}</td>
                </tr>
                </c:forEach>
                <tr>
                    <th scope="row"></th>
                    <td colspan="3"></td> 
                    <td>TOTAL: ${cart.getAmount()}</td>
                </tr>          
            </tbody>
        </table>
    </div>
        
    <div class="row mx-5 my-3">
        <div class="col-5">
            <table class="table table-stripped w-auto">
                <tbody>
                    <tr>
                        <td>Customer name</td>
                        <td>${user.name}</td>
                    </tr>
                    <tr>
                        <td>Customer address</td>
                        <td>${user.address}</td>
                    </tr>
                </tbody>
            </table>
        </div>
                    
        <div class="col-3">
            <c:choose>
                <%-- Check user login --%>
                <c:when test="${not empty user}">
                    
                     
                    <%-- Check EMPTY cart --%>   
                    <c:choose>
                        <c:when test="${not empty cart}">
                            <form action="${pageContext.request.contextPath}/PayController">
                                <label for="discount">DISCOUNT CODE (if any)</label>
                                <input type="text" name="discount">
                                <button data-purpose="shopping-cart-checkout" 
                                    type="submit" class="btn btn-lg btn-primary btn-block my-2">
                                Checkout
                                </button>
                            </form>    
                        </c:when>
                        <c:otherwise>
                        <a href="${pageContext.request.contextPath}/home.jsp"><button class="btn btn-lg btn-primary btn-block my-2">
                        Keep Shopping
                        </button></a>   
                        </c:otherwise>
                    </c:choose>
                    
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/login.jsp"><button class="btn btn-lg btn-primary btn-block my-2">
                        Checkout
                    </button></a> 
                </c:otherwise>    
            </c:choose>   
        </div>
                
             
    </div>             
</div>        



            
            
<c:import url="footer.jsp"/>