<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Not Found</title>
<link
	href="${pageContext.request.contextPath}/webjars/bootstrap/4.5.0/css/bootstrap.min.css"
	rel="stylesheet" />

</head>
<body>
	<div class="container-fluid">
		<div class="row">

			<div class="error-template mx-auto my-3">
				<h1>Oops!</h1>
				<h2>404 Not Found</h2>
				<div class="error-details">Sorry, an error has occurred,
					Requested page not found!</div>
				<div class="error-actions row my-2">
					<a href="${pageContext.request.contextPath }"
						class="btn btn-primary btn-lg"><span></span> Go home page </a> <a
						href="${pageContext.request.contextPath }"
						class="btn btn-default btn-lg"><span></span> Contact Support </a>



				</div>
			</div>
		</div>
	</div>
	<script src="//code.jquery.com/jquery.js"></script>
	<script
		src="//netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
</body>
</html>
