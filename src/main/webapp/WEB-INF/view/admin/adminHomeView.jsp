<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- Header Section --%>
<c:import url="../_header.jsp">
	<c:param name="title" value="Product Management" />
</c:import>

<%-- Menu Section --%>
<c:import url="../_menu.jsp" />

<%-- Body Section --%>
<div class="container">
	<div class="row mt-3 d-flex justify-content-around ">
		<h3>Products</h3>
		<a href="${pageContext.request.contextPath}/admin/create-product" class="btn btn-success">Create new
			product </a>
	</div>
	<div class="row ml-3">
		<c:import url="/admin/product"></c:import>
	</div>
</div>

<%-- Footer Section --%>
<c:import url="../_footer.jsp" />