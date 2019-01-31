package org.jagjeet.crs.dao;

import java.sql.SQLException;
import java.util.List;

import org.jagjeet.crs.model.Customer;

public interface CustomerDao {

	public int insertCustomerDetails(Customer details) throws SQLException;

	public int updateCustomerDetails(Customer details) throws SQLException;

	public int deleteCustomerDetails(int id) throws SQLException;

	public Customer getCustomerById(int id) throws SQLException;

	public List<Customer> getAllRecord() throws SQLException;

}
