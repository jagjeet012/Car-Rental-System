package org.jagjeet.crs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jagjeet.crs.db.DBUtility;
import org.jagjeet.crs.model.Car;

public class CarDaoImpl implements CarDao {

	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;
	String sql;

	@Override
	public int insertCarDetails(Car details) throws SQLException {

		sql = "insert into car(id,carId,carName,carType) values (?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, details.getCarId());
		pst.setString(2, details.getCarName());
		pst.setString(3, details.getCarType());

		return db.update(pst);
	}

	@Override
	public int updateCarDetails(Car details) throws SQLException {
		sql = "update car set id=?,carId=?,carName=?,carType=? where id=?";
		pst = db.createPST(sql);
		pst.setString(1, details.getCarId());
		pst.setString(2, details.getCarName());
		pst.setString(3, details.getCarType());
		pst.setInt(4, details.getId());

		return db.update(pst);
	}

	@Override
	public int deleteCarDetails(int id) throws SQLException {
		sql = "delete from car where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);

		return db.update(pst);
	}

	@Override
	public Car getCarById(int id) throws SQLException {
		sql = "select * from car where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			Car c = new Car();
			c.setId(rs.getInt(1));
			c.setCarId(rs.getString(2));
			c.setCarName(rs.getString(3));
			c.setCarType(rs.getString(4));
			return c;
		}
		return null;
	}

	@Override
	public List<Car> getAllRecord() throws SQLException {
		List<Car> car = new ArrayList<Car>();
		sql = "select * from customer";
		pst = db.createPST(sql);
		rs = db.query(pst);
		while (rs.next()) {
			Car c = new Car();
			c.setId(rs.getInt(1));
			c.setCarId(rs.getString(2));
			c.setCarName(rs.getString(3));
			c.setCarType(rs.getString(4));
			car.add(c);
		}
		return car;
	}

}
