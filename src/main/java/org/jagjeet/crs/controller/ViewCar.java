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

import org.jagjeet.crs.dao.CarDao;
import org.jagjeet.crs.dao.CarDaoImpl;
import org.jagjeet.crs.model.Car;

@SuppressWarnings("serial")
public class ViewCar extends HttpServlet {

	List<Car> cars;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<a href='index.jsp'>Add New Car</a>");
		out.println("<h1>Car List</h1>");

		CarDao carDao = new CarDaoImpl();

		try {
			cars = carDao.getAllRecord();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		HttpSession session = request.getSession();
		session.setAttribute("cars", cars);
		request.getRequestDispatcher("viewcars.jsp").forward(request, response);

		out.print("</table>");

		out.close();
	}
}
