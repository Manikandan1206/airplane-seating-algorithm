<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Airplane Seating Algorithm</title>
<link rel="stylesheet" href="index.css" type="text/css"></link>
</head>
<body class="main">

	<form method="Get" action="seating-arrangement">
		<h2>Airplane Seating Algorithm</h2>
		<div class="input-mn">
			<label style="font-size: 18px; margin-left: 34px; font-weight: 600">Enter
				a 2D Array :</label> <input style="width: 200px; margin-left: 8px;height: 28px;letter-spacing:1px"
				type="text" name="input-array" placeholder="Ex: [[x1,y2],[x2,y2]]" />
		</div>
		<div class="input-mn">
			<label style="font-size: 18px; font-weight: 600">Number of
				passengers :</label> <input style="width: 200px; margin-left: 8px;height: 28px"
				" type="number" name="no-of-passengers" />
		</div>
		<div class="input-mn">
		<input type='submit' />
		</div>
	</form>
</body>
</html>