<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:import url="../_header.jsp">
	<c:param name="title" value="Create Product" />
</c:import>
<c:import url="../_menu.jsp" />

<div class="container">
	<h3>Create Product</h3>

	<p style="color: red;">${errorString}</p>

	<form method="POST" enctype="multipart/form-data"
		action="${pageContext.request.contextPath}/admin/product-create">
		<div class="form-group row">
			<label for="ProductName" class="col-sm-2 col-form-label">Product
				Name: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="ProductName"
					id="ProductName" placeholder="">
			</div>
		</div>

		<div class="form-group row">
			<label for="SKU" class="col-sm-2 col-form-label">Product SKU:
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="SKU" id="SKU"
					placeholder="">
			</div>
		</div>



		<div class="form-group row">
			<label for="Price" class="col-sm-2 col-form-label">Unit
				Price: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="Price" id="Price"
					placeholder="">
			</div>
		</div>
		<div class="form-group row">
			<label for="Quantity" class="col-sm-2 col-form-label">Units
				in Stock: </label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="Quantity"
					id="Quantity" placeholder="0">
			</div>
		</div>
		<div class="form-group row">
			<label for="Description" class="col-sm-2 col-form-label">Description:
			</label>
			<div class="col-sm-10">
				<textarea class="form-control" name="Description" id="Description"
					rows="8" cols="15"></textarea>
			</div>
		</div>
		<div class="form-group row">
			<label for="Manufacturer" class="col-sm-2 col-form-label">Manufacturer:
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="Manufacturer"
					id="Manufacturer" placeholder="">
			</div>
		</div>
		<div class="form-group row">
			<label for="Category" class="col-sm-2 col-form-label">Category:
			</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" name="Category"
					id="Category" placeholder="">
			</div>
		</div>
		<fieldset class="form-group">
			<div class="row">
				<legend class="col-form-label col-sm-2 pt-0">Condition: </legend>
				<div class="row">
					<div class="form-check ml-3">
						<input class="form-check-input" type="radio" name="Option"
							id="NewRadios" value="1"> <label class="form-check-label"
							for="NewRadios"> New </label>
					</div>
					<div class="form-check ml-3">
						<input class="form-check-input" type="radio" name="Option"
							id="OldRadios" value="2"> <label class="form-check-label"
							for="OldRadios"> Old </label>
					</div>
					<div class="form-check ml-3">
						<input class="form-check-input" type="radio" name="Option"
							id="RefurbishedRadios" value="3"> <label
							class="form-check-label" for="RefurbishedRadios">
							Refurbished</label>
					</div>
				</div>
			</div>
		</fieldset>
		<div class="form-group row">
			<label for="ProductImage" class="col-sm-2 col-form-label">Product
				Image File: </label>
			<div class="col-sm-10">
				<input type="file" class="form-control-file" name="ProductImage"
					id="ProductImage">
			</div>
		</div>

		<div class="form-group row mt-3">
			<div class="col-sm-10">
				<button type="submit" class="btn btn-primary">Add Product</button>
			</div>
		</div>
	</form>
</div>

<c:import url="../_footer.jsp" />