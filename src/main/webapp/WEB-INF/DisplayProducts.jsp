<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Product List</title>
<style>
.container {
	display: flex;
	align-item: center;
	justify-content: center;
}

table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	padding: 8px;
	text-align: left;
	border-bottom: 1px solid #DDD;
}

tr:hover {
	background-color: #D6EEEE;
}

img {
	width: 70px;
	height: 70px;
}
</style>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Product ID</th>
					<th>Product Name</th>
					<th>Product Price</th>
					<th>Category</th>
					<th>Image</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty products}">
					<tr>
						<td colspan="8">No Products to Display</td>
					</tr>
				</c:if>
				<c:if test="${not empty products}">

					<c:forEach items="${products}" var="product">
						<tr class="">
							<td>${product.productId}</td>
							<td>${product.productName}</td>
							<td>${product.unitPrice}</td>
							<td>${product.category}</td>
							<td><img src="${product.imageUrl }" alt="Image" /></td>
							<td><a href="/edit/${product.productId}">Edit</a></td>
							<td><a href="/delete/${product.productId}">Delete</a></td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>