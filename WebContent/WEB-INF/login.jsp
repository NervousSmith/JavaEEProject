<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<title>Logowanie</title>
</head>
<body>
<jsp:include page="guestHeader.jsp"/>
<div class="w3-display-middle"> 

	<div class="w3-container w3-blue">
  		<h2>Logowanie</h2>
	</div>

	<form action=login method="post" class="w3-container">
		<label> Login: </label> 
		<input class="w3-input" type="text" name="login"><br><br>
		<label> Hasło: </label> 
		<input class="w3-input" type="password" name="password"><br><br>
		<input type="submit" name="Zaloguj" value="Zaloguj" class = "w3-button w3-blue">
	</form>
</div>
</body>
</html>