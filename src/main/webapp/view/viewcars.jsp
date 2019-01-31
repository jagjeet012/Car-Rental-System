<!DOCTYPE html>  
  
<%@page import="java.util.List"%>
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>View Users</title>  
</head>  
<body>  
  
<%@page import="org.jagjeet.crs.dao.CarDao"%>
<%@page import="org.jagjeet.crs.model.Car"%>
<%@page import="org.jagjeet.crs.dao.CarDaoImpl"%>  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
  
<h1>Customers List</h1>  
  
<%  
CarDao dao = new CarDaoImpl();
List<Car> cars = dao.getAllRecord();  
request.setAttribute("cars",cars);  
%>  
  
<table border="1" width="90%">  
<tr><th>Id</th><th>Name</th><th>Contact</th><th>Address</th>  
<th>Edit</th><th>Delete</th></tr>  
<c:forEach items="${list}" var="u">  
<tr><td>${e.getId()}</td><td>${e.getName()}</td><td>${e.getContact()}</td>  
<td>${e.getAddress()}</td>  
<td><a href="editform.jsp?id=${e.getId()}">Edit</a></td>  
<td><a href="deletecar.jsp?id=${e.getId()}">Delete</a></td></tr>  
</c:forEach>  
</table>  
<br/><a href="addcarform.jsp">Add New User</a>  
  
</body>  
</html>  