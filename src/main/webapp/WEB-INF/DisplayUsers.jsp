<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users List</title>
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
					<th>User ID</th>
					<th>UserName</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${empty users}">
					<tr>
						<td colspan="8">No Products to Display</td>
					</tr>
				</c:if>
				<c:if test="${not empty users}">

					<c:forEach items="${users}" var="user">
						<tr class="">
							<td>${user.userId}</td>
							<td>${user.userName}</td>
							<td>${user.email}</td>
							<td>${user.phone}</td>
							<td><a href="/edit/user/${user.userId}">Edit</a></td>
							<td><a href="/delete/user/${user.userId}">Delete</a></td>

						</tr>
					</c:forEach>
				</c:if>
			</tbody>
		</table>
	</div>

</body>
</html>