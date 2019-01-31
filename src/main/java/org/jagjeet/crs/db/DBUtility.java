package org.jagjeet.crs.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtility {
	private static Connection con;
	static {
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
		} catch (InstantiationException e) {

			e.printStackTrace();
		} catch (IllegalAccessException e) {

			e.printStackTrace();
		} catch (ClassNotFoundException e) {

			e.printStackTrace();
		}
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/car_rental?user=root&password=root");
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public PreparedStatement createPST(String sql) throws SQLException {
		return con.prepareStatement(sql);
	}

	public int update(PreparedStatement pst) throws SQLException {
		try {
			return pst.executeUpdate();
		} finally {
			pst.close();
		}

	}

	public ResultSet query(PreparedStatement pst) throws SQLException {
		return pst.executeQuery();
	}
}