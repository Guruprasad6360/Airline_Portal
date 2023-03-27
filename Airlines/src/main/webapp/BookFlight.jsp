<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>FlyAway</title>
</head>
<body>
	<br>
	<a href=HomePage.jsp
		style="color: black; text-decoration: none; font-size: 35px; font-weight: bold;">FlyAway</a>
	<br>
	<br>

	<%
	@SuppressWarnings("unchecked")
	HashMap<String, String> user = (HashMap<String, String>) session.getAttribute("user");
	if (user == null) {
		response.sendRedirect("UserPage.jsp");
	}
	%>
	<p align="center"
		style="color: blue; font-size: 40px; font-weight: bold">Payment</p>
	<center>
		<div
			style="border: 3px solid black; width: 25%; border-radius: 20px; padding: 20px"
			align="center">
			<form action=payment method=post>
				<label for=upi>upi :-</label> <input type="number" name=upi
					id=upi /><br> <br> <label for=card>card :-</label>
				<input type="number" name=card id=card placeholder="xxxxx"/><br> <br>
				<input type=submit value=submit /> <input type=reset />
			</form>
		</div>
	</center>
</body> 
</html>