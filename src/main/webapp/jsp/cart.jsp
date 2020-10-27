<%-- 
    Document   : cart
    Created on : Oct 20, 2020
    Author     : Loi Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>   

<%-- Header Section --%>
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
                    <th class="th-sm" scope="col">Products in cart: <c:out value="${items.size()}"/></th>
                    <th class="th-sm" scope="col">Price</th>
                    <th class="th-sm" scope="col">Quantity</th>
                    <th class="th-sm" scope="col">Amount</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${items}">
                <tr>
                    <th scope="row"><c:out value="${items.indexOf(product) + 1}"/></th>
                    <td>
                        <div class="row">
                            <div class="col-2">
                                <%-- Create URL image for product --%>
                                <c:url var="productSrc" value="${product.src}"/>
                                <img class="card-img" src="${productSrc}">
                            </div>
                            <div class="col-5">
                                <p><c:out value="${product.name}"/></p>
                                <p>ID: <c:out value="${product.id}"/></p>
                            </div>
                            
                        </div>
                        
                    </td>
                    <%-- Format price --%>
                    <fmt:formatNumber currencySymbol="$" value="${product.price}" 
                                          type="currency" var="productPrice"/>
                    <td><c:out value="${productPrice}"/></td>
                    <td><c:out value="${product.quantity}"/></td>
                    
                    <%-- Format price --%>
                    <fmt:formatNumber currencySymbol="$" value="${product.price * product.quantity}" 
                                          type="currency" var="productAmount"/>
                    <td><c:out value="${productAmount}"/></td>
                </tr>
                </c:forEach>
                <tr>
                    <th scope="row"></th>
                    <td colspan="3"></td>
                    
                    <%-- Format price --%>
                    <fmt:formatNumber currencySymbol="$" value="${cart.getAmount()}" 
                                          type="currency" var="totalAmount"/>
                    <td>TOTAL: <c:out value="${totalAmount}"/></td>
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
                        <td><c:out value="${user.name}"/></td>
                    </tr>
                    <tr>
                        <td>Customer address</td>
                        <td><c:out value="${user.address}"/></td>
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
                        <a href="${pageContext.request.contextPath}"><button class="btn btn-lg btn-primary btn-block my-2">
                        Keep Shopping
                        </button></a>   
                        </c:otherwise>
                    </c:choose>
                    
                </c:when>
                <c:otherwise>
                    <a href="${pageContext.request.contextPath}/jsp/login.jsp"><button class="btn btn-lg btn-primary btn-block my-2">
                        Checkout
                    </button></a> 
                </c:otherwise>    
            </c:choose>   
        </div>
                
             
    </div>             
</div>        

<%-- Footer Section --%>                        
<c:import url="/jsp/footer.jsp"/>