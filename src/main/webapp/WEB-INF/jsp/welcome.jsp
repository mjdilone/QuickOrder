<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 

<!DOCTYPE html>
<html lang="en">
<head>
	<title>Welcome</title>
	
	
	
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link rel="stylesheet" type="text/css" href="css/styles.css">
<link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
<script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
<script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
	
<link rel="stylesheet" type="text/css" href="//wpcc.io/lib/1.0.2/cookieconsent.min.css"/><script src="//wpcc.io/lib/1.0.2/cookieconsent.min.js"></script><script>window.addEventListener("load", function(){window.wpcc.init({"border":"thin","corners":"small","colors":{"popup":{"background":"#f6f6f6","text":"#000000","border":"#555555"},"button":{"background":"#555555","text":"#ffffff"}},"position":"bottom"})});</script>
</head>

<body>
<div class="container ">
			
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
		
		<script type="text/javascript">
		var user = "<?php echo $username?>"; 
		</script>
			
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
		
				
			
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
					<!--  	<h1>Welcome to ${company.name}'s online ordering system</h1> -->
					</span>
				
				</form>
				
			<p class ="description">
				<h2>${company.description}</h2>
			</p>

	<br>
	
	<div class = "tutorialMessage">
	<p>
		Start by choosing an item category, searching for a specific item in the search bar above or click <a href="list">here</a> to browse all items.
	</p>
	</div>
	
	<br>
	
  <div class = "categoriesList">
  <h2>Item Categories</h2> 
  <table class="table table-striped">
   <thead>
    <tr>

    </tr>
   </thead>
   <tbody>
    <c:forEach items="${categories}" var="category" >
     <tr>
      <td><a href="/category?categoryToSearch=${category.name}"">${category.name } </a></td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
 </div>			


</div>
			

<!-- <!--===============================================================================================--> -->
<!-- 	<script src="vendor/jquery/jquery-3.2.1.min.js"></script> -->
<!-- <!--===============================================================================================--> -->
<!-- 	<script src="vendor/animsition/js/animsition.min.js"></script> -->
<!-- <!--===============================================================================================--> -->
<!-- 	<script src="vendor/bootstrap/js/popper.js"></script> -->
<!-- 	<script src="vendor/bootstrap/js/bootstrap.min.js"></script> -->
<!-- <!--===============================================================================================--> -->
<!-- 	<script src="vendor/select2/select2.min.js"></script> -->
<!-- <!--===============================================================================================--> -->
<!-- 	<script src="vendor/daterangepicker/moment.min.js"></script> -->
<!-- 	<script src="vendor/daterangepicker/daterangepicker.js"></script> -->
<!-- <!--===============================================================================================--> -->
<!-- 	<script src="vendor/countdowntime/countdowntime.js"></script> -->
<!-- <!--===============================================================================================--> -->
<!-- <script src="js/main.js"></script> -->

</body>
</html>