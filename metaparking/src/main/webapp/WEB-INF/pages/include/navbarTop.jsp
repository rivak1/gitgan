<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>${titleName}</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">
 <link rel="stylesheet" href="/css/index.css">
</head>
<body>
<nav id="navbar" class="navbar navbar-expand-sm navbar-dark bg-primary">
  <a class="navbar-brand" href="Vehicleform">Meta-Parking</a>
  
  <!-- Links -->
  <ul class="navbar-nav">
    <li <c:if test="${url == 4}"> class="active nav-item" </c:if> <c:if test="${url != 4}"> class="nav-item" </c:if>>
      <a class="nav-link" href="GatePass">Gate Pass</a>
    </li>
    <li<c:if test="${url == 3}"> class="active nav-item" </c:if> <c:if test="${url != 3}"> class="nav-item" </c:if>>
      <a class="nav-link" href="Profile">Profile</a>
    </li>
    <li <c:if test="${url == 2}"> class="active nav-item" </c:if> <c:if test="${url != 2}"> class="nav-item" </c:if> >
      <a class="nav-link" href="FriendList">Friend List</a>
    </li>
    <li <c:if test="${url == 1}"> class="active nav-item" </c:if> <c:if test="${url != 1}"> class="nav-item" </c:if>>
      <a class="nav-link " href="Vehicleform"> Vehicle Register </a>
    </li>
  </ul>
 </nav>
 <nav>
 	
 	<div class="container-fluid">
 		<div class="row">
 			<div class="col-md-12">
 				 <ul class="nav justify-content-end">
  					 <li class="nav-item">
  					    <a class="nav-link bg-primary text-white"  href="home">Logout</a>
    				</li>
  				</ul>
 			</div>
 		</div>
 	</div>
 
 </nav>
 
