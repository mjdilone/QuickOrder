<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Customer Cart</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
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
  <button>Keep Shopping</button> <button>Checkout</button> 
 </div>

</body>
</html>