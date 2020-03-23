<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Information</title>
<link rel="stylesheet" href="css/styles.css">
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
 <link rel="stylesheet" type="text/css" href="//wpcc.io/lib/1.0.2/cookieconsent.min.css"/><script src="//wpcc.io/lib/1.0.2/cookieconsent.min.js"></script><script>window.addEventListener("load", function(){window.wpcc.init({"border":"thin","corners":"small","colors":{"popup":{"background":"#f6f6f6","text":"#000000","border":"#555555"},"button":{"background":"#555555","text":"#ffffff"}},"position":"bottom"})});</script>
</head>
<body>
<div class = "container">
<div class = "navBar">
 	Welcome,  ${username}
 	<br>
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
		
<!-- 		<script type="text/javascript">
		var user = "<?php echo $username?>"; 
		</script> -->
			
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
		
		
	<br>
	<br>
	<br>
	<div class = "itemInfo">
	<form action="/addToCart">
 	  <img src= ${saleItem.imageSource} height = "300" width = "300">
 	  <br>
      <input type='hidden' name='id' value='${saleItem.id}'/> 
      <br>
      ${saleItem.name }
      <br>
      ${saleItem.pricePerUnit }
      <br>
      ${saleItem.srp }
      <br>
      <br>
      <br>
      ${saleItem.itemDescription}
      <br>
      <br>
      Amount: <br> 
      <input type = "number" name = "quantity" value ="quantity">
      <br>
      <br>
      <input type="submit" value = "Add to Cart">
      </form>
	</div>
</div>
</body>
</html>