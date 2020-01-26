<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<form method="post" class="w3-container w3-card-4" >
			<div class="w3-cell-row">
				<div class="w3-cell">
					<label>Sposób dostawy</label>
					<select class="w3-select w3-margin" name="option">
		  				<option value="1">Kurier + 20zł</option>
		  				<option value="2">Paczkomat + 10 zł</option>
				</select> 
				</div>
			</div>
			<div class="w3-cell-row">
				<div class="w3-cell">
					<label>Rodzaj płatności</label>
					<p>
					<input class="w3-radio" type="radio" name="payment" value="cash">
					<label>Przy odbiorze</label></p>
					<p>
					<input class="w3-radio" type="radio" name="payment" value="transfer">
					<label>Przelew</label></p>
				</div>
			</div>
			<div class="w3-cell-row">
				<input type="submit" value="Płacę" class="w3-button w3-red w3-margin">
			</div>
		</form>	
	</body>
</html>