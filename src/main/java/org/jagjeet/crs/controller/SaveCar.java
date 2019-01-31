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
public class SaveCar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		Car car = new Car();

		car.setCarId(request.getParameter("carId"));
		car.setCarName(request.getParameter("carName"));
		car.setCarType(request.getParameter("carType"));

		CarDaoImpl carDaoImpl = new CarDaoImpl();

		try {
			int status = carDaoImpl.insertCarDetails(car);
			if (status == 1) {
				pw.print("<p>Record saved successfully!</p>");
				request.getRequestDispatcher("index.jsp").include(request, response);
			} else {
				pw.println("Sorry! unable to save record");
			}
		} catch (SQLException e1) {

			e1.printStackTrace();
		}

		pw.close();

	}

}
