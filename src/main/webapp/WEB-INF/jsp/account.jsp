<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account Page</title>
 <link rel="stylesheet" href="css/styles.css">
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>

<div class ="container"> 

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

		 <h2>Account Info</h2> 
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">ID</th>
     <th scope = "row">Username</th>
  

    </tr>
   </thead>
   <tbody>
    <c:forEach items="${account}" var="saleItem" >
     <tr>
      <td>${account.id }</td>
      <td>${account.account_name}</td>
      
     </tr>
    </c:forEach>
   </tbody>
  </table>

<div class ="button">
			<form action = "pastOrders">
			<input type ='hidden' name='userId' value = '${account.id}' />
				<button class = "button">Past Orders</button>
			</form>
		</div>
		


	

</div>




</body>
</html>