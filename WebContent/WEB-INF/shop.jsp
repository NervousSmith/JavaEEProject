<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
 
 
<html>
   <head>
   	  <meta charset="UTF-8">
      <title>Sklep</title>
      <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
   </head>
   <body>
	   <div class="w3-cell-row">	
	   		<jsp:include page="headers.jsp"/>
	   </div>
	   <div class="w3-cell-row">
		   <div class="w3-cell w3-bar-block" style="width:20%">
				<form action=shop method="get">
					<c:forEach items="${listCategory}" var="category">
				       	<input class="w3-bar-item w3-button w3-cyan" type="submit" value=${category.name}>
				   	</c:forEach>
			   	</form>
			</div>
			<div class="w3-container w3-cell">
				<table class="w3-table w3-striped w3-border">
					<tr>
					  <th></th>
					  <th>Nazwa</th>
					  <th>Cena</th>
					  <th></th>
					  <th></th>
					</tr>
					<c:forEach items="${products}" var="product">
						<tr>
							<td> <img src="<c:out value="${product.name}"></c:out>" class="w3-border w3-padding" alt="<c:out value="${product.name}"></c:out>"> </td>
							<td> <c:out value="${product.name}"></c:out></td>
							<td> <c:out value="${product.price}"></c:out> </td>
							<td> <input type="button" class="w3-button w3-round-large" onClick="more()" value="Więcej" name="<c:out value="${product.name}"></c:out>">
							<td> <input type="button" class="w3-button w3-round-large" value="Dodaj do koszyka" name="<c:out value="${product.name}"></c:out>"> </td>
						</tr>	
				   	</c:forEach>
				</table>
			</div>
		</div>
		<FORM NAME="form1" METHOD="GET">
        	<INPUT TYPE="HIDDEN" NAME="product">
    	</FORM>
    	<% 
        if(request.getParameter("buttonName") != null) {
               session.setAttribute("status", "guest");
        }
    	%>
		<SCRIPT>
        function addToCart()
        {
            document.form1.buttonName.value = "yes";
            form1.submit();
        } 
        function more()
        {
        	document.form1.buttonName.value = "yes";
        	form1.submit();
        }
    	</SCRIPT>
	</body>
</html>