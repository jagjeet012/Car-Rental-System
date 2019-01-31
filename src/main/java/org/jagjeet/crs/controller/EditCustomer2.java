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
public class EditCustomer2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String address = request.getParameter("address");
		System.out.println(id + name + contact + address);
		Customer e = new Customer();
		e.setId(id);
		e.setName(name);
		e.setContact(contact);
		e.setAddress(address);

		CustomerDaoImpl crudDaoImpl = new CustomerDaoImpl();

		int status = 0;
		try {
			status = crudDaoImpl.updateCustomerDetails(e);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (status > 0) {
			response.sendRedirect("editcustomer.jsp");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();

	}

}
