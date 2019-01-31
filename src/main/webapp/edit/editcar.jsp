<%@page import="org.jagjeet.crs.dao.CarDao"%>
<%@page import="org.jagjeet.crs.model.Car"%>
<%@page import="org.jagjeet.crs.dao.CarDaoImpl"%>
<jsp:setProperty property="*" name="e" />
<%
	Car car = new Car();
	CarDao dao = new CarDaoImpl();
	int i = dao.updateCarDetails(car);
	response.sendRedirect("viewcars.jsp");
%>
