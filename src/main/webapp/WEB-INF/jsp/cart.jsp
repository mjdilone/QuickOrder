<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Customer Cart</title>
 <link rel="stylesheet" href="css/styles.css">
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
 <link rel="stylesheet" type="text/css" href="//wpcc.io/lib/1.0.2/cookieconsent.min.css"/><script src="//wpcc.io/lib/1.0.2/cookieconsent.min.js"></script><script>window.addEventListener("load", function(){window.wpcc.init({"border":"thin","corners":"small","colors":{"popup":{"background":"#f6f6f6","text":"#000000","border":"#555555"},"button":{"background":"#555555","text":"#ffffff"}},"position":"bottom"})});</script>
</head>
<body>
 <div class="container">
 
 	<div class = "navBar">
 	Welcome,  ${username}
 	<br>
 	 	<div class = "button">
			<form action="welcome">
				<button class = "button">Home</button>
			</form>
		</div>
		
 		<div class = "button">
			<form action="login">
				<button class = "button">Login</button>
			</form>
		</div>
			
		<div class ="button">
			<form action="logout">
				<button class = "button" >Logout</button>
			</form>
		</div>
		
		<div class ="button">
			<form action = "retrieveCart">
				<button class = "button">Cart(${cartCount})</button>
			</form>
		</div>
		
		<div class ="button">
			<form action = "accountDetails"  >
			<input type='hidden' name='username' value='${username}'/> 
				<button class = "button">Account</button>
			</form>
		</div>	
		
		</div>
		
		
	
 
 	<br>
	<br>
	<br>
	<form action="/searchSaleItem">
			Search: <input type = "text" name="name">
		</form>
 
 
  <h2>Cart</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope = "row">Picture</th>
     <th scope="row">Name</th>
     <th scope="row">Quantity</th>
     <th scope="row"></th>

    </tr>
   </thead>
   <tbody>
    <c:forEach items="${cart }" var="cart" >
     <tr>
     <td><img src= ${cart.imageSource} height = "50" width = "50"></td>
      <td>${cart.name }</td>
      
      <td>${cart.quantity }</td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 	<form action="/list"><input type ="submit" value ="Keep Shopping"></form>
 	<form action="/checkout"><input type = "hidden" name = "id" value =${id }><input type ="submit" value ="Checkout"></form> 
 	
 	
 </div>

</body>
</html>