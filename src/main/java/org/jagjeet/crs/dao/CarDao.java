package org.jagjeet.crs.dao;

import java.sql.SQLException;
import java.util.List;

import org.jagjeet.crs.model.Car;

public interface CarDao {

	public int insertCarDetails(Car details) throws SQLException;

	public int updateCarDetails(Car details) throws SQLException;

	public int deleteCarDetails(int id) throws SQLException;

	public Car getCarById(int id) throws SQLException;

	public List<Car> getAllRecord() throws SQLException;

}
