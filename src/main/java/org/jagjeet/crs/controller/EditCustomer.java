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
public class EditCustomer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Customer</h1>");

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

		Customer customer;
		try {
			customer = customerDaoImpl.getCustomerById(id);

			out.print("<form action='Edit2' method='get'>");
			out.print("<table>");
			out.print("<tr><td></td><td><input type='hidden' name='id' value='" + customer.getId() + "'/></td></tr>");
			out.print("<tr><td>Name:</td><td><input type='text' name='name' value='" + customer.getName()
					+ "'/></td></tr>");
			out.print("<tr><td>Password:</td><td><input type='text' name='contact' value='" + customer.getContact()
					+ "'/></td></tr>");
			out.print("<tr><td>Email:</td><td><input type='text' name='address' value='" + customer.getAddress()
					+ "'/></td></tr>");

			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
