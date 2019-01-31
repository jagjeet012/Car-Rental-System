package org.jagjeet.crs.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
@SuppressWarnings("serial")
public class LoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String ln = request.getParameter("loginName");
		String pw = request.getParameter("password");
		System.out.println(ln);

		if (ln.equals("admin") && pw.equals("admin")) {
			response.sendRedirect("login/loginsuccess.html");
			return;
		} else {
			response.sendRedirect("login/loginerror.html");
			return;
		}
	}
}
