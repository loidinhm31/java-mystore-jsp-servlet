<%-- 
    Document   : cart
    Created on : Oct 20, 2020
    Author     : Loi Dinh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
       
<c:import url="header.jsp">
    <c:param name="title" value="My Web Shop"/>
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
                        <div class="name">
                            <p>${product.name}</p>
                        </div>
                        <div class="id">
                            <p>ID: ${product.id}</p>
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
        <table class="table table-stripped w-auto">
            <tbody>
                <tr>
                    <td>Customer name</td>
                    <td>A</td>
                </tr>
                <tr>
                    <td>Customer address</td>
                    <td>B</td>
                </tr>
                <tr>
                    <td>DISCOUNT CODE(if any)</td>
                    <td>C</td>
                </tr>
            </tbody>
        </table>        
    </div>             
</div>        



            
            
<c:import url="footer.jsp"/>