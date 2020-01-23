<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
		<title>Computer Shop</title>
	</head>
	<body>
		<div id="main">
			<div id="left_menu">
				<form action=category method="get">
				<table>
					<c:forEach items="${listCategory}" var="category">
	        			<tr>
	        				<td><option value="${category.id}"><input class="w3-button w3-teal" type="submit" value=${category.name}></option></td>
	        			</tr>
	   				</c:forEach>
	   			</table>
	   			</form>
			</div>
			<div id="show">
				
			</div>
		</div>
	</body>
</html>