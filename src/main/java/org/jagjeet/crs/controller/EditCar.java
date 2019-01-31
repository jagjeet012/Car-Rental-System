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
public class EditCar extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<h1>Update Car</h1>");

		String sid = request.getParameter("id");

		int id = Integer.parseInt(sid);

		CarDaoImpl carDaoImpl = new CarDaoImpl();

		Car car;

		try {
			car = carDaoImpl.getCarById(id);

			out.print("<form action='Edit2' method='get'>");
			out.print("<table>");
			out.print("<tr><td></td><td><input type='hidden' name='id' value='" + car.getId() + "'/></td></tr>");
			out.print(
					"<tr><td>Name:</td><td><input type='text' name='name' carId='" + car.getCarId() + "'/></td></tr>");
			out.print("<tr><td>CarName:</td><td>");
			out.print("<select name='carName' style='width:150px'>");
			out.print("<option>Safari</option>");
			out.print("<option>Innova</option>");
			out.print("<option>Scorpio</option>");
			out.print("<option>Tata Indigo</option>");
			out.print("<option>Maruti Swift</option>");
			out.print("<option>Others</option>");
			out.print("</select>");
			out.print("</td></tr>");
			out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
			out.print("</table>");
			out.print("</form>");
			out.print("<tr><td>CarType:</td><td>");
			out.print("<select name='carType' style='width:150px'>");
			out.print("<option>AC</option>");
			out.print("<option>Non-AC</option>");
			out.print("</select>");
			out.print("</td></tr>");
			out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");
			out.print("</table>");
			out.print("</form>");

			out.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
