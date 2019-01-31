<%@page import="org.jagjeet.crs.dao.CustomerDao"%>
<%@page import="org.jagjeet.crs.model.Customer"%>
<%@page import="org.jagjeet.crs.dao.CustomerDaoImpl"%>
<jsp:useBean id="u" class="org.jagjeet.crs.model.Customer"></jsp:useBean>
<jsp:setProperty property="*" name="u" />
<%
	Customer customer = new Customer();
	CustomerDao dao = new CustomerDaoImpl();

	int i = dao.insertCustomerDetails(customer);
	if (i > 0) {
		response.sendRedirect("addcustomer_success.jsp");
	} else {
		response.sendRedirect("addcustomer_error.jsp");
	}
%>
