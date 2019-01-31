package org.jagjeet.crs.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jagjeet.crs.dao.CarDaoImpl;
import org.jagjeet.crs.model.Car;

@SuppressWarnings("serial")
public class EditCar2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		String carId = request.getParameter("carId");
		String carName = request.getParameter("carName");
		String carType = request.getParameter("carType");
		System.out.println(id + carId + carName + carType);
		Car c = new Car();
		c.setId(id);
		c.setCarName(carId);
		c.setCarName(carName);
		c.setCarType(carType);

		CarDaoImpl carDaoImpl = new CarDaoImpl();

		int status = 0;
		try {
			status = carDaoImpl.updateCarDetails(c);
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
		if (status > 0) {
			response.sendRedirect("editcar.jsp");
		} else {
			out.println("Sorry! unable to update record");
		}

		out.close();

	}

}
