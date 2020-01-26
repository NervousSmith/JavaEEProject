<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
		<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	</head>
	<body>
		<div class="w3-cell-row">	
			<jsp:include page="headers.jsp"/>
		</div>
		<div lass="w3-cell-row">
			<div>
				<table class="w3-table w3-striped w3-border">
					<tr>
						<th></th>
						<th>Nazwa</th>
						<th>Cena</th>
					</tr>
						<c:forEach items="${cartList}" var="product">
							<tr>
								<td> <img src="<c:out value="${product.name}.jpg" ></c:out>" class="w3-border w3-padding" alt="<c:out value="${product.name}"></c:out>"> </td>
								<td> <c:out value="${product.name}"></c:out></td>
								<td> <c:out value="${product.price}"></c:out> </td>
							</tr>	
						</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>