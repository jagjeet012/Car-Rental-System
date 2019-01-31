package org.jagjeet.crs.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jagjeet.crs.dao.CustomerDaoImpl;

@SuppressWarnings("serial")
public class DeleteCustomer extends HttpServlet {

	CustomerDaoImpl customerDaoImpl = new CustomerDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String sid = request.getParameter("id");
		int id = Integer.parseInt(sid);
		try {
			customerDaoImpl.deleteCustomerDetails(id);
		} catch (SQLException e) {

			e.printStackTrace();
		}
		response.sendRedirect("deletecustomer.jsp");
	}

}
