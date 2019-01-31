package org.jagjeet.crs.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.jagjeet.crs.db.DBUtility;
import org.jagjeet.crs.model.Customer;

public class CustomerDaoImpl implements CustomerDao {

	DBUtility db = new DBUtility();
	PreparedStatement pst;
	ResultSet rs;
	String sql;

	@Override
	public int insertCustomerDetails(Customer details) throws SQLException {
		sql = "insert into customer(id,name,contact,address) values (?,?,?,?)";
		pst = db.createPST(sql);
		pst.setString(1, details.getName());
		pst.setString(2, details.getContact());
		pst.setString(3, details.getAddress());

		return db.update(pst);
	}

	@Override
	public int updateCustomerDetails(Customer details) throws SQLException {
		sql = "update customer set id=?,name=?,contact=?,address=? where id=?";
		pst = db.createPST(sql);
		pst.setString(1, details.getName());
		pst.setString(2, details.getContact());
		pst.setString(3, details.getAddress());
		pst.setInt(4, details.getId());

		return db.update(pst);

	}

	@Override
	public int deleteCustomerDetails(int id) throws SQLException {
		sql = "delete from customer where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);

		return db.update(pst);
	}

	@Override
	public Customer getCustomerById(int id) throws SQLException {
		sql = "select * from customer where id=?";
		pst = db.createPST(sql);
		pst.setInt(1, id);
		ResultSet rs = pst.executeQuery();
		if (rs.next()) {
			Customer e = new Customer();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setContact(rs.getString(3));
			e.setAddress(rs.getString(4));
			return e;
		}
		return null;

	}

	@Override
	public List<Customer> getAllRecord() throws SQLException {
		List<Customer> customer = new ArrayList<Customer>();
		sql = "select * from customer";
		pst = db.createPST(sql);
		rs = db.query(pst);
		while (rs.next()) {
			Customer e = new Customer();
			e.setId(rs.getInt(1));
			e.setName(rs.getString(2));
			e.setContact(rs.getString(3));
			e.setAddress(rs.getString(4));
			customer.add(e);
		}
		return customer;
	}

}
