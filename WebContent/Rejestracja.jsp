<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Rejestracja</title>
</head>
<body>
	<div align="center">
		<form action="Register" method="post">
		<table style="with: 80%">
			<tr>
				<td>Login</td> 
				<td><input type="text" name="login"></td>
			</tr>
			<tr>
				<td>Hasło</td>
				<td><input type="password" name="password"></td>
			</tr>
			<tr>
				<td>Powtórz Hasło</td>
				<td><input type="password" name="password2"></td>
			</tr>
			<tr>
				<td>Imię</td>
				<td><input type="text" name="imie"></td>
			</tr>
			<tr>
				<td>Nazwisko</td>
				<td><input type="text" name="nazwisko"></td>
			</tr>
			<tr>
				<td>Numer telefonu</td>
				<td><input type="tel" name="nr_tel"></td>
			</tr>
			<tr>
				<td>Adres e-mail</td>
				<td><input type="email" name="e_mail"></td>
			</tr>
			<tr>
				<td>Ulica</td>
				<td><input type="text" name="ulica"></td>
			</tr>
			<tr>
				<td>Miasto</td>
				<td><input type="text" name="miasto"></td>
			</tr>
			<tr>
				<td>Kod Pocztowy</td>
				<td><input type="text" name="kod_pocztowy"></td>
			</tr>
			<tr>
				<td>Numer Domu</td>
				<td><input type="text" name=nr_domu></td>
			</tr>
		</table>
			<input type="submit" value="Zarejestruj">
		</form>
	
</div>
</body>
</html>