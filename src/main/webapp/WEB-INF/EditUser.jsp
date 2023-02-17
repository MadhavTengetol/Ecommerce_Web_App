<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update User</title>
</head>
<body>
	<h1>Update User</h1>



	<form:form method="POST" action="/edit/user/${user.userId}"
		>
		<table>
			<tr>
				<td>User Id</td>
				<td>
					<%-- <form:hidden path="user.userId" /> --%> 
					<input type="number" value="${user.userId }" readonly />
				</td>
			</tr>
			<tr>
				<td>Username :</td>
				<td>
					<%-- <form:input path="user.userName" /> --%> 
					<input type="text"
					value="${user.userName }" />
				</td>
			</tr>
			<tr>
				<td>Email :</td>
				<td>
					<%-- <form:input path="user.email" /> --%> <input type="email"
					value="${user.email }" />
				</td>
			</tr>
			<tr>
				<td>Phone:</td>
				<td>
					<%-- <form:input path="user.phone" /> --%> <input type="text"
					value="${user.phone }" />
				</td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Edit Save" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>