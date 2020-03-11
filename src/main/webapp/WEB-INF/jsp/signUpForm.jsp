<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link rel="stylesheet" type="text/css" href="css/styles.css">
<link rel="stylesheet" type="text/css" href="//wpcc.io/lib/1.0.2/cookieconsent.min.css"/><script src="//wpcc.io/lib/1.0.2/cookieconsent.min.js"></script><script>window.addEventListener("load", function(){window.wpcc.init({"border":"thin","corners":"small","colors":{"popup":{"background":"#f6f6f6","text":"#000000","border":"#555555"},"button":{"background":"#555555","text":"#ffffff"}},"position":"bottom"})});</script>
</head>
<body>

<div class = "container">
	<div class = "tutorialMessage">
		Please fill in details below
	</div>
	<div class = "signUpForm">
		<form action="signUpNewUser" method = "post">
			<table>
				<tr>
				<td align = "right"> First Name:</td>
				<td align = "left">  <input type = "text" name = "fname"></td>
				</tr>
				<tr>
				<td align = "right"> Last Name:</td>
				<td align = "left">  <input type = "text" name = "lname"></td>
				</tr>
				<tr>
				<td align = "right"> Username:</td>
				<td align = "left">  <input type = "text" name = "uname"></td>
				</tr>
				<tr>
				<td align = "right"> Password:</td>
				<td align = "left">  <input type = "password" name = "password"></td>
				</tr>
				<tr>
				<td align = "right"> Email:</td>
				<td align = "left">  <input type = "text" name = "email"></td>
				</tr>
			</table>
						<br>
						<div class ="">
							<input type = "submit" value="Sign Up!">
						</div>
		</form>
	</div>
</div>


</body>
</html>