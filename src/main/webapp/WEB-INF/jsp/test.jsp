<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Page</title>
</head>
<body>
This is a test page within  JSP folder
 
 <br>
the message you passed is  -----> ${messageToPass}
<br>
 <button onclick = "/SaleItem.next">Next Page</button>
 
 <form action="/next">
 	<button type="submit" class="btn btn-primary">Next</button>
 
 </form>
 <br>
</body>
</html>