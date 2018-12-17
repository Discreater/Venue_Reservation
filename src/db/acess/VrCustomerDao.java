package db.acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.MySQLHelper;
import db.inter.IVrCustomerDao;
import db.model.VrCustomer;

public class VrCustomerDao implements IVrCustomerDao {

	@Override
	public void insert(VrCustomer obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "insert into customer " + "(cust_name, cust_password, cust_email, "
					+ "cust_realName, cust_phone, cust_address) " + "values(?,?,?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getCustName());
			pStatement.setString(2, obj.getCustPassword());
			pStatement.setString(3, obj.getCustEmail());
			pStatement.setString(4, obj.getRealName());
			pStatement.setString(5, obj.getCustPhone());
			pStatement.setString(6, obj.getCustAddress());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
	}

	@Override
	public void update(VrCustomer obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "update customer set " + "cust_name=?, cust_password=?, cust_email=?, "
					+ "cust_realName=?, cust_phone=?, cust_address=?" + "where cust_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getCustName());
			pStatement.setString(2, obj.getCustPassword());
			pStatement.setString(3, obj.getCustEmail());
			pStatement.setString(4, obj.getRealName());
			pStatement.setString(5, obj.getCustPhone());
			pStatement.setString(6, obj.getCustAddress());
			pStatement.setInt(7, obj.getCustId());
			pStatement.executeUpdate();
		} catch (Exception e) {

		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
	}

	@Override
	public void delete(Integer id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "delete from customer where cust_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}

	}

	@Override
	public VrCustomer findById(Integer id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrCustomer vrCustomer = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from customer where cust_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrCustomer = new VrCustomer();
				vrCustomer.setCustId(rSet.getInt("cust_id"));
				vrCustomer.setCustName(rSet.getString("cust_name"));
				vrCustomer.setCustPassword(rSet.getString("cust_password"));
				vrCustomer.setCustDatetime(rSet.getDate("create_time"));
				vrCustomer.setCustAddress(rSet.getString("cust_address"));
				vrCustomer.setCustEmail(rSet.getString("cust_email"));
				vrCustomer.setCustPhone(rSet.getString("cust_phone"));
				vrCustomer.setRealName(rSet.getString("cust_realName"));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrCustomer;
	}

	@Override
	public List<VrCustomer> findAll() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCustomer> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from customer";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrCustomer vrCustomer = null;
			while (rSet.next()) {
				vrCustomer = new VrCustomer();
				vrCustomer.setCustId(rSet.getInt("cust_id"));
				vrCustomer.setCustName(rSet.getString("cust_name"));
				vrCustomer.setCustPassword(rSet.getString("cust_password"));
				vrCustomer.setCustEmail(rSet.getString("cust_email"));
				vrCustomer.setRealName(rSet.getString("cust_realName"));
				vrCustomer.setCustPhone(rSet.getString("cust_phone"));
				vrCustomer.setCustAddress(rSet.getString("cust_address"));
				vrCustomer.setCustDatetime(rSet.getDate("create_time"));
				list.add(vrCustomer);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return null;
	}

	@Override
	public List<VrCustomer> findPage(int pageSize, int pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCustomer> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from customer limit " + (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrCustomer vrCustomer = null;
			while (rSet.next()) {
				vrCustomer = new VrCustomer();
				vrCustomer.setCustId(rSet.getInt("cust_id"));
				vrCustomer.setCustName(rSet.getString("cust_name"));
				vrCustomer.setCustPassword(rSet.getString("cust_password"));
				vrCustomer.setCustEmail(rSet.getString("cust_email"));
				vrCustomer.setRealName(rSet.getString("cust_realName"));
				vrCustomer.setCustPhone(rSet.getString("cust_phone"));
				vrCustomer.setCustAddress(rSet.getString("cust_address"));
				vrCustomer.setCustDatetime(rSet.getDate("create_time"));
				list.add(vrCustomer);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}

		return list;
	}

	@Override
	public int findCount() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		int num = 0;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select count(*) as count from customer";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				num = rSet.getInt("count");
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return num;
	}

	@Override
	public VrCustomer findOne(String custName, String custPassword) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrCustomer vrCustomer = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from customer where cust_name=? and cust_password=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, custName);
			pStatement.setString(2, custPassword);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrCustomer = new VrCustomer();
				vrCustomer.setCustId(rSet.getInt("cust_id"));
				vrCustomer.setCustName(rSet.getString("cust_name"));
				vrCustomer.setCustPassword(rSet.getString("cust_password"));
				vrCustomer.setCustEmail(rSet.getString("cust_email"));
				vrCustomer.setRealName(rSet.getString("cust_realName"));
				vrCustomer.setCustPhone(rSet.getString("cust_phone"));
				vrCustomer.setCustAddress(rSet.getString("cust_address"));
				vrCustomer.setCustDatetime(rSet.getDate("create_time"));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrCustomer;
	}

	@Override
	public VrCustomer findByName(String custName) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrCustomer vrCustomer = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from customer where cust_name=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, custName);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrCustomer = new VrCustomer();
				vrCustomer.setCustId(rSet.getInt("cust_id"));
				vrCustomer.setCustName(rSet.getString("cust_name"));
				vrCustomer.setCustPassword(rSet.getString("cust_password"));
				vrCustomer.setCustEmail(rSet.getString("cust_email"));
				vrCustomer.setRealName(rSet.getString("cust_realName"));
				vrCustomer.setCustPhone(rSet.getString("cust_phone"));
				vrCustomer.setCustAddress(rSet.getString("cust_address"));
				vrCustomer.setCustDatetime(rSet.getDate("create_time"));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrCustomer;
	}

	@Override
	public List<VrCustomer> findPage(String catName, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCustomer> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from customer where locate(?,cust_name) limit " + (pageNo - 1) * pageSize + "," + pageSize + " ";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, catName);
			rSet = pStatement.executeQuery();
			VrCustomer vrCustomer = null;
			while (rSet.next()) {
				vrCustomer = new VrCustomer();
				vrCustomer.setCustId(rSet.getInt("cust_id"));
				vrCustomer.setCustName(rSet.getString("cust_name"));
				vrCustomer.setCustPassword(rSet.getString("cust_password"));
				vrCustomer.setCustEmail(rSet.getString("cust_email"));
				vrCustomer.setRealName(rSet.getString("cust_realName"));
				vrCustomer.setCustPhone(rSet.getString("cust_phone"));
				vrCustomer.setCustAddress(rSet.getString("cust_address"));
				vrCustomer.setCustDatetime(rSet.getDate("create_time"));
				list.add(vrCustomer);
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return list;
	}

	@Override
	public Integer findCount(String catName) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		int num = 0;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select count(*) as count from customer where cust_name like '%?'";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, catName);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				num = rSet.getInt("count");
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return num;
	}

}
