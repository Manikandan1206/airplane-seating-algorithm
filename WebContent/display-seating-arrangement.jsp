<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
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
	<h2>Airplane Seating Display</h2>
	<%
	List<int[][]> allSeats = new ArrayList<int[][]>();
	allSeats = (List<int[][]>) request.getAttribute("allSeats");
	%>
	<div class="table-main ">
	<div class="table-div-main">
		<%
		for (int[][] seats : allSeats) {
		%>
		<table class="table">
			<%
			for (int i = 0; i < seats.length; i++) {
			%>
			<tr class="row">
				<%
				for (int j = 0; j < seats[i].length; j++) {
				%>
				<td class="cell"><%=seats[i][j] != 0 ? seats[i][j] : ""%></td>
				<%
				}
				%>
			</tr>
			<%
			}
			%>
		</table>
		<%
		}
		%>
		</div>
	</div>
</body>
</html>