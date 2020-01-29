<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
	<form action=mock method="post" class="w3-container">
		<label> Numer karty: </label> 
		<input class="w3-input" type="text" name="numer" required><br><br>
		<label> Kod: </label> 
		<input class="w3-input" type="text" name="kod" required><br><br>
		<input type="submit" value="Zaplac" class = "w3-button w3-red">
	</form>
</body>
</html>