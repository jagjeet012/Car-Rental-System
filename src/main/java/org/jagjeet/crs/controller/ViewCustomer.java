package org.jagjeet.crs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.jagjeet.crs.dao.CustomerDao;
import org.jagjeet.crs.dao.CustomerDaoImpl;
import org.jagjeet.crs.model.Customer;

@SuppressWarnings("serial")
public class ViewCustomer extends HttpServlet {

	List<Customer> customers;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.jsp'>Add New Customer</a>");
		out.println("<h1>Customer List</h1>");

		CustomerDao cutomerDao = new CustomerDaoImpl();

		try {
			customers = cutomerDao.getAllRecord();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		HttpSession session = request.getSession();
		session.setAttribute("customers", customers);
		request.getRequestDispatcher("viewcustomers.jsp").forward(request, response);

		out.print("</table>");

		out.close();
	}

}
