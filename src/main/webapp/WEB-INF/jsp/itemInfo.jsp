<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Item Information</title>
</head>
<body>
this is the item information page
<br>
<form action="/addToCart">
      ${saleItem.id } <input type='hidden' name='id' value='${saleItem.id}'/> 
      <br>
      <img src= ${saleItem.imageSource} height = "300" width = "300">
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
      Amount: <input type = "number" name = "quantity" value ="quantity">
      <button type = "submit" >Add to Cart</button>
      </form>
</body>
</html>