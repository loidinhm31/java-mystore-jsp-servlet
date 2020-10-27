<%-- 
    Document   : search
    Created on : Oct 24, 2020, 12:48:07 PM
    Author     : Loi Dinh
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%-- Save data from search form --%>
<c:set var="searchKey" value="${param.key}"/>

<%-- Header Section --%>
<c:import url="header.jsp">
    <c:param name="title" value="Search Results"/>
</c:import>

<!-- Body Section -->
<div class="container-fluid">
    <div class="row">
        <c:import url="/jsp/list.jsp">
            <c:param name="search" value="${searchKey}"/>
        </c:import>
        
    </div>
    <c:if test="${empty PRODUCTS}">
        <div class="row">
            <div class="card shadow mx-auto my-5">
                <div class="card-body">
                <h3 class="card-title">Try adjusting your search. Here are some ideas:</h3>
                <ul>
                    <li>Make sure all words are spelled correctly

                    </li>
                    <li>
                        Try different search terms

                    </li>
                    <li>
                        Try more general search terms
                    </li>
                </ul>
                </div>
                
            </div>
            
        </div>
    </c:if>
</div>
<%-- Footer Section --%>
<c:import url="/jsp/footer.jsp"/>