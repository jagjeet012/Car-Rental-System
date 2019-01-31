package org.jagjeet.crs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jagjeet.crs.dao.CustomerDaoImpl;
import org.jagjeet.crs.model.Customer;

@SuppressWarnings("serial")
public class saveCustomer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Customer customer = new Customer();

		customer.setName(request.getParameter("name"));
		customer.setContact(request.getParameter("contact"));
		customer.setAddress(request.getParameter("address"));

		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

		try {
			int status = customerDaoImpl.insertCustomerDetails(customer);
			if (status == 1) {
				pw.print("<p>Record saved successfully!</p>");
				request.getRequestDispatcher("addcustomer.jsp").include(request, response);
			} else {
				pw.println("Sorry! unable to save record");
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		pw.close();

	}

}
