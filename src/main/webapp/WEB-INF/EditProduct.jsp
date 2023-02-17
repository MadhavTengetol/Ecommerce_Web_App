<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Product</title>
</head>
<body>

	<h1>Edit Product</h1>
	
	
	
	 <form:form method="POST" action="/edit/${product.productId }">
		<table>
			<tr>
				<td>Product Id</td>
				<td>
				 <form:hidden path="product.productId" />  
				 <%-- <input type="number" value="${product.productId }" readonly/> --%>
				 </td>
			</tr>
			<tr>
				<td>Name :</td>
				<td>
				 <form:input path="product.productName" /> 
			<%-- <input type="text" value="${product.productName }"/> --%> 
			</td>
			</tr>
			<tr>
				<td>Unit Price :</td>
				<td>
				 <form:input path="product.unitPrice" />
				<%--  <input type="number" value="${product.unitPrice }"/> --%> 
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