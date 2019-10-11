<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Sale Items List</title>
 <link href="../webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="../webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="../webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <h2>Items List</h2>
  <table class="table table-striped">
   <thead>
    <tr>
     <th scope="row">ID</th>
     <th scope = "row">Picture</th>
     <th scope="row">Name</th>
     <th scope="row">PPU</th>
     <th scope="row">SRP</th>

    </tr>
   </thead>
   <tbody>
    <c:forEach items="${saleItem_list }" var="saleItem" >
     <tr>
      <td>${saleItem.id }</td>
      <td><a href="/itemInfo?id=${saleItem.id}""><img src= ${saleItem.imageSource} height = "50" width = "50"></td>
      <td>${saleItem.name }</td>
      <td>${saleItem.pricePerUnit }</td>
      <td>${saleItem.srp }</td>
     </tr>
    </c:forEach>
   </tbody>
  </table>
  
 </div>
 
 

</body>
</html>