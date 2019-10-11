<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %> 
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
 <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <title>Employees</title>
 <link href="http://localhost:8080/webjars/bootstrap/4.0.0/css/bootstrap.min.css" rel="stylesheet" />
 <script src="http://localhost:8080/webjars/bootstrap/4.0.0/js/bootstrap.min.js" ></script>
 <script src="http://localhost:8080/webjars/jquery/3.0.0/js/jquery.min.js" ></script>
</head>
<body>
 <div class="container">
  <spring:url value="/employee/save" var="saveURL" />
  <h2>Item</h2>
  <form:form modelAttribute="employeeForm" method="post" action="${saveURL }" cssClass="form">
   <form:hidden path="employeeId"/>
   <div class="form-group">
    <lable for="id">First Name</lable>
    <form:input path="id" cssClass="form-control" id="id" />
   </div>
   <div class="form-group">
    <lable for="name">Last Name</lable>
    <form:input path="name" cssClass="form-control" id="name" />
   </div>
   <div class="form-group">
    <lable for="pricePerUnit">Email</lable>
    <form:input path="pricePerUnit" cssClass="form-control" id="pricePerUnit" />
   </div>
   <div class="form-group">
    <lable for="srp">Phone</lable>
    <form:input path="srp" cssClass="form-control" id="srp" />
   </div>
   <button type="submit" class="btn btn-primary">Search</button>
  </form:form>
 </div>
</body>
</html>