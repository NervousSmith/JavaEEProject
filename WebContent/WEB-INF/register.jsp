<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rejestracja</title>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>
<jsp:include page="guestHeader.jsp"/>
	<div class="w3-display-topmiddle">
	
		<div class="w3-container w3-red">
  			<h2>Rejestracja</h2>
		</div>
		
			<form action="Register" method="post" class="w3-container">
					<label> Login </label>
					<input type="text" name="login" class="w3-input">
					<label>Hasło</label>
					<input type="password" name="password" class="w3-input">

					<label>Powtórz hasło</label>
					<input type="password" name="password2" class="w3-input">

					<label>Imię</label>
					<input type="text" name="imie" class="w3-input">
	
					<label>Nazwisko</label>
					<input type="text" name="nazwisko" class="w3-input">

					<label>Numer telefonu</label>
					<input type="tel" name="nr_tel" class="w3-input">

					<label>Adres e-mail</label>
					<input type="email" name="e_mail" class="w3-input">

					<label>Ulica</label>
					<input type="text" name="ulica" class="w3-input">

					<label>Miasto</label>
					<input type="text" name="miasto" class="w3-input">

					<label>Kod Pocztowy</label>
					<input type="text" name="kod_pocztowy" class="w3-input">

					<label>Numer Domu</label>
					<input type="text" name="nr_domu" class="w3-input">
				
				<input type="submit" value="Zarejestruj" class = "w3-button w3-red">
			</form>
	
</div>
</body>
</html>