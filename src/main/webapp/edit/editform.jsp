<!DOCTYPE html>  
<html>  
<head>  
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">  
<title>Edit Form</title>  
</head>  
<body>  
<%@page import="org.jagjeet.crs.dao.CustomerDao"%>  
<%@page import="org.jagjeet.crs.model.Customer"%>
<%@page import="org.jagjeet.crs.dao.CustomerDaoImpl"%>  
<%  
CustomerDao dao = new CustomerDaoImpl();
String id=request.getParameter("id");  
Customer e = dao.getCustomerById(Integer.parseInt(id));  
%>  
  
<h1>Edit Form</h1>  
<form action="editcustomer.jsp" method="post">  
<input type="hidden" name="id" value="<%=e.getId() %>"/>  
<table>  
<tr><td>Name:</td><td>  
<input type="text" name="name" value="<%= e.getName()%>"/></td></tr>  
<tr><td>Password:</td><td>  
<input type="password" name="password" value="<%= e.getContact()%>"/></td></tr>  
<tr><td>Email:</td><td>  
<input type="email" name="email" value="<%= e.getAddress()%>"/></td></tr>  
<tr><td colspan="2"><input type="submit" value="Edit User"/></td></tr>  
</table>  
</form>  
  
</body>  
</html>  