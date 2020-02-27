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
	
 
<!--  
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
	<link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
	
	<link rel="stylesheet" type="text/css" href="css/main.css">
-->

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
			
				<form class="login100-form validate-form">
					<span class="login100-form-title p-b-43">
						<h1>Welcome to ${company.name}'s online ordering system</h1>
					</span>
				
				</form>
				
			<p class ="description">
				<h2>${company.description}</h2>
			
			</p>
			
			
			</div>
			
			<div class = "companyInfo">
			</div>
  
 
  <div class = "categoriesList">
  <h2>Categories</h2> 
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">ID</th>
     <th scope="row">Name</th>
     <th scope="row">Test Link</th>

    </tr>
   </thead>
   <tbody>
    <c:forEach items="${categories}" var="category" >
     <tr>
      <td>${category.id }</td>
      <td>${category.name }</td>
      <td><a href="/category?categoryToSearch=${category.name}"">${category.name } </a></td>
      
      
     </tr>
    </c:forEach>
   </tbody>
  </table>
  

  
 </div>
 
 <br>
 
   <div id="cookieConsent">
    			<div id="closeCookieConsent">x</div>
  			 This website is using cookies. <a href="#" target="">More info</a>. <a class="cookieConsentOK">That's Fine</a>
	</div>
 
 




<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/bootstrap/js/popper.js"></script>
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>

</body>
</html>