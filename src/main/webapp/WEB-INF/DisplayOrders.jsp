<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>All Orders</title>
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
</style>
</head>
<body>
	<div class="container">
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Order ID</th>
					<th>UserName</th>
					<th>Product Name</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty orders}">
					<tr>
						<td colspan="8">No Orders to Display</td>
					</tr>
				</c:if>
				<c:if test="${not empty orders}">

					<c:forEach items="${orders}" var="order">

						<tr class="">
							<td>${order.orderId}</td>
							<td>${order.users.userName}</td>
							<td>${order.itemList}</td>
							<td><a href="#">Edit</a></td>
							<td><a href="#">Delete</a></td>

						</tr>

					</c:forEach>

				</c:if>
			</tbody>
		</table>
	</div>
</body>
</html>