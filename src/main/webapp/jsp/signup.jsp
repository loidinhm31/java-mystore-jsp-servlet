<%-- 
    Document   : signup
    Created on : Oct 25, 2020
    Author     : Loi Dinh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:import url="header.jsp">
    <c:param name="title" value="My Web Shop"/>
</c:import>  
<div class="container-fluid my-5">
    <div class="row ">
        <div class="mx-auto my-5">
            <form action="" method="POST">
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputEmail4">Email</label>
                        <input type="email" class="form-control" id="inputEmail4" placeholder="Email">
                    </div>
                    <div class="form-group col-md-6">
                        <label for="inputPassword4">Password</label>
                        <input type="password" class="form-control" id="inputPassword4" placeholder="Password">
                    </div>
                </div>
                <div class="form-group">
                    <label for="inputAddress">Address</label>
                    <input type="text" class="form-control" id="inputAddress" placeholder="1234 Main St">
                </div>
                
                <div class="form-row">
                    <div class="form-group col-md-6">
                        <label for="inputCity">City</label>
                        <input type="text" class="form-control" id="inputCity">
                    </div>
                    <div class="form-group col-md-4">
                        <label for="inputState">State</label>             
                        <input type="text" class="form-control" id="inputState">
<!--                        <select id="inputState" class="form-control">
                            <option selected>Choose...</option>
                            <option>...</option>
                         </select>-->
                    </div>
<!--                    <div class="form-group col-md-2">
                        <label for="inputZip">Zip</label>
                        <input type="text" class="form-control" id="inputZip">
                    </div>-->
                </div>
                <button type="submit" class="btn btn-primary">Sign Up</button>
            </form>    
        </div>
    </div>
</div>
<c:import url="footer.jsp"/>