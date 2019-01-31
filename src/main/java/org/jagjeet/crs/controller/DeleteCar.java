package org.jagjeet.crs.controller;

import java.io.IOException;
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
public class DeleteCar extends HttpServlet {

	CarDao carDao = new CarDaoImpl();

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int sid = Integer.parseInt(request.getParameter("id"));

		try {
			int flag = carDao.deleteCarDetails(sid);
			if (flag > 0) {
				List<Car> updatedList = carDao.getAllRecord();
				HttpSession session = request.getSession(false);
				session.setAttribute("updatedList", updatedList);

				request.getRequestDispatcher("deletecar.jsp").forward(request, response);
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

}
