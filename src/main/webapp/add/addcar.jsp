<%@page import="org.jagjeet.crs.dao.CarDao"%>
<%@page import="org.jagjeet.crs.model.Car"%>
<%@page import="org.jagjeet.crs.dao.CarDaoImpl"%>
<jsp:useBean id="u" class="org.jagjeet.crs.model.Car"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
	Car car = new Car();
	CarDao dao = new CarDaoImpl();

	int i = dao.insertCarDetails(car);
	if (i > 0) {
		response.sendRedirect("addcar_success.jsp");
	} else {
		response.sendRedirect("addcar_error.jsp");
	}
%>
