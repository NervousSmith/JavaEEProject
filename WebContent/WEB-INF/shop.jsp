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
   	<jsp:include page="guestHeader.jsp"/>
	   <div class="w3-bar-block w3-display-left" style="width:25%">
			<c:forEach items="${listCategory}" var="category">
		       	<input class="w3-bar-item w3-button w3-cyan" type="button" value=${category.name} onClick ="">
		   	</c:forEach>
		</div>
		<div class="w3-container w3-border w3-display-topmiddle">
		<%
			
		%>
		</div>
	</body>
</html>