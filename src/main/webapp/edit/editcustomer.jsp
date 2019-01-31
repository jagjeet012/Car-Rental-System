<%@page import="org.jagjeet.crs.dao.CustomerDao"%>
<%@page import="org.jagjeet.crs.model.Customer"%>
<%@page import="org.jagjeet.crs.dao.CustomerDaoImpl"%>
<jsp:setProperty property="*" name="e" />
<%
	Customer customer = new Customer();
	CustomerDao dao = new CustomerDaoImpl();
	int i = dao.updateCustomerDetails(customer);
	response.sendRedirect("viewcustomers.jsp");
%>
