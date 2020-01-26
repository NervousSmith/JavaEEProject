<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<c:set var = "product" scope = "request" value = "${product}"/>
	<div class="w3-cell-row">	
   		<jsp:include page="headers.jsp"/>
   	</div>
	<div class="w3-cell-row"> 
		<div class="w3-cell">
			<img src="<c:out value="${product.name}.jpg" ></c:out>" class="w3-border w3-padding" alt="<c:out value="${product.name}"></c:out>">
		</div>
		<div class="w3-cell">
			<div class="w3-cell-row"> 
				<div class="w3-cell">
					<c:out value="${product.price}"></c:out>
				</div>
			</div>
			<div class="w3-cell-row"> 
				<div class="w3-cell">
					<button class="w3-button w3-round-large">Dodaj do koszyka</button>
				</div>
			</div>
		</div>
	</div>
	<div class="w3-cell-row"> 
		Lorem ipsum
	</div>
</body>
</html>