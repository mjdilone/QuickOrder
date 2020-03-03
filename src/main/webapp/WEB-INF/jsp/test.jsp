<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test Page</title>
<link rel="stylesheet" type="text/css" href="//wpcc.io/lib/1.0.2/cookieconsent.min.css"/><script src="//wpcc.io/lib/1.0.2/cookieconsent.min.js"></script><script>window.addEventListener("load", function(){window.wpcc.init({"border":"thin","corners":"small","colors":{"popup":{"background":"#f6f6f6","text":"#000000","border":"#555555"},"button":{"background":"#555555","text":"#ffffff"}},"position":"bottom"})});</script>
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