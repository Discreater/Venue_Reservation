package db.acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.MySQLHelper;
import db.inter.IVrOrderDao;
import db.model.VrOrder;

public class VrOrderDao implements IVrOrderDao {

	@Override
	public void insert(VrOrder obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "insert into `order` " + "(order_dealTime, order_useStartTime, "
					+ "order_useEndTime, order_state, " + "order_rejectReason, customer_cust_id,"
					+ "admin_admin_id, venue_venue_id, order_submitReason) " + "values(?,?,?,?,?,?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setDate(1, obj.getOrdDealTime());
			pStatement.setDate(2, obj.getUseStartTime());
			pStatement.setDate(3, obj.getUseEndTime());
			pStatement.setString(4, obj.getOrdStatus());
			pStatement.setString(5, obj.getOrdRejectReason());
			pStatement.setInt(6, obj.getCustId());
			pStatement.setInt(7, obj.getAdminId());
			pStatement.setInt(8, obj.getVenueId());
			pStatement.setString(9, obj.getOrdSubmitReason());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
	}

	@Override
	public void update(VrOrder obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "update `order` set" + " order_dealTime=?, order_useStartTime=?, "
					+ "order_useEndTime=?, order_state=?, " + "order_rejectReason=?, customer_cust_id=?,"
					+ "admin_admin_id=?, venue_venue_id=?, order_submitReason=?" + "where order_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setDate(1, obj.getOrdDealTime());
			pStatement.setDate(2, obj.getUseStartTime());
			pStatement.setDate(3, obj.getUseEndTime());
			pStatement.setString(4, obj.getOrdStatus());
			pStatement.setString(5, obj.getOrdRejectReason());
			pStatement.setInt(6, obj.getCustId());
			pStatement.setInt(7, obj.getAdminId());
			pStatement.setInt(8, obj.getVenueId());
			pStatement.setString(9, obj.getOrdSubmitReason());
			pStatement.setInt(10, obj.getOrdId());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
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
			String sql = "delete from `order` where order_id=?";
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
	public VrOrder findById(Integer id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrOrder vrOrder = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from `order` where order_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrOrder = new VrOrder();
				vrOrder.setOrdId(rSet.getInt("order_id"));
				vrOrder.setOrdSubmitTime(rSet.getDate("order_submitTime"));
				vrOrder.setOrdDealTime(rSet.getDate("order_dealTime"));
				vrOrder.setUseStartTime(rSet.getDate("order_useStartTime"));
				vrOrder.setUseEndTime(rSet.getDate("order_useEndTime"));
				vrOrder.setOrdStatus(rSet.getString("order_state"));
				vrOrder.setOrdRejectReason(rSet.getString("order_rejectReason"));
				vrOrder.setCustId(rSet.getInt("customer_cust_id"));
				vrOrder.setAdminId(rSet.getInt("admin_admin_id"));
				vrOrder.setVenueId(rSet.getInt("venue_venue_id"));
				vrOrder.setOrdSubmitReason(rSet.getString("order_submitReason"));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrOrder;
	}

	@Override
	public List<VrOrder> findAll() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrOrder> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from `order`";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrOrder vrOrder = null;
			while (rSet.next()) {
				vrOrder = new VrOrder();
				vrOrder.setOrdId(rSet.getInt("order_id"));
				vrOrder.setOrdSubmitTime(rSet.getDate("order_submitTime"));
				vrOrder.setOrdDealTime(rSet.getDate("order_dealTime"));
				vrOrder.setUseStartTime(rSet.getDate("order_useStartTime"));
				vrOrder.setUseEndTime(rSet.getDate("order_useEndTime"));
				vrOrder.setOrdStatus(rSet.getString("order_state"));
				vrOrder.setOrdRejectReason(rSet.getString("order_rejectReason"));
				vrOrder.setCustId(rSet.getInt("customer_cust_id"));
				vrOrder.setAdminId(rSet.getInt("admin_admin_id"));
				vrOrder.setVenueId(rSet.getInt("venue_venue_id"));
				vrOrder.setOrdSubmitReason(rSet.getString("order_submitReason"));
				list.add(vrOrder);
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
	public List<VrOrder> findPage(int pageSize, int pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrOrder> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from `order` limit " + (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrOrder vrOrder = null;
			while (rSet.next()) {
				vrOrder = new VrOrder();
				vrOrder.setOrdId(rSet.getInt("order_id"));
				vrOrder.setOrdSubmitTime(rSet.getDate("order_submitTime"));
				vrOrder.setOrdDealTime(rSet.getDate("order_dealTime"));
				vrOrder.setUseStartTime(rSet.getDate("order_useStartTime"));
				vrOrder.setUseEndTime(rSet.getDate("order_useEndTime"));
				vrOrder.setOrdStatus(rSet.getString("order_state"));
				vrOrder.setOrdRejectReason(rSet.getString("order_rejectReason"));
				vrOrder.setCustId(rSet.getInt("customer_cust_id"));
				vrOrder.setAdminId(rSet.getInt("admin_admin_id"));
				vrOrder.setVenueId(rSet.getInt("venue_venue_id"));
				vrOrder.setOrdSubmitReason(rSet.getString("order_submitReason"));
				list.add(vrOrder);
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
			String sql = "select count(*) as count from `order`";
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
	public List<VrOrder> findByCustId(Integer custId, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrOrder> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from `order` where customer_cust_id=? limit " + (pageNo - 1) * pageSize + ","
					+ pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, custId);
			rSet = pStatement.executeQuery();
			VrOrder vrOrder = null;
			if (rSet.next()) {
				vrOrder = new VrOrder();
				vrOrder.setOrdId(rSet.getInt("order_id"));
				vrOrder.setOrdSubmitTime(rSet.getDate("order_submitTime"));
				vrOrder.setOrdDealTime(rSet.getDate("order_dealTime"));
				vrOrder.setUseStartTime(rSet.getDate("order_useStartTime"));
				vrOrder.setUseEndTime(rSet.getDate("order_useEndTime"));
				vrOrder.setOrdStatus(rSet.getString("order_state"));
				vrOrder.setOrdRejectReason(rSet.getString("order_rejectReason"));
				vrOrder.setCustId(rSet.getInt("customer_cust_id"));
				vrOrder.setAdminId(rSet.getInt("admin_admin_id"));
				vrOrder.setVenueId(rSet.getInt("venue_venue_id"));
				vrOrder.setOrdSubmitReason(rSet.getString("order_submitReason"));
				list.add(vrOrder);
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
	public List<VrOrder> findByAdminId(Integer adminId, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrOrder> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from `order` where admin_admin_id=? limit " + (pageNo - 1) * pageSize + ","
					+ pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, adminId);
			rSet = pStatement.executeQuery();
			VrOrder vrOrder = null;
			if (rSet.next()) {
				vrOrder = new VrOrder();
				vrOrder.setOrdId(rSet.getInt("order_id"));
				vrOrder.setOrdSubmitTime(rSet.getDate("order_submitTime"));
				vrOrder.setOrdDealTime(rSet.getDate("order_dealTime"));
				vrOrder.setUseStartTime(rSet.getDate("order_useStartTime"));
				vrOrder.setUseEndTime(rSet.getDate("order_useEndTime"));
				vrOrder.setOrdStatus(rSet.getString("order_state"));
				vrOrder.setOrdRejectReason(rSet.getString("order_rejectReason"));
				vrOrder.setCustId(rSet.getInt("customer_cust_id"));
				vrOrder.setAdminId(rSet.getInt("admin_admin_id"));
				vrOrder.setVenueId(rSet.getInt("venue_venue_id"));
				vrOrder.setOrdSubmitReason(rSet.getString("order_submitReason"));
				list.add(vrOrder);
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
public List<VrOrder> findByVenueId(Integer venueId, Integer pageSize, Integer pageNo) {
	Connection connection = null;
	PreparedStatement pStatement = null;
	ResultSet rSet = null;
	List<VrOrder> list = new ArrayList<>();
	try {
		connection = MySQLHelper.getConnection();
		String sql = "select * from `order` where venue_venue_id=? limit " + (pageNo - 1) * pageSize + ","
				+ pageSize;
		pStatement = connection.prepareStatement(sql);
		pStatement.setInt(1, venueId);
		rSet = pStatement.executeQuery();
		VrOrder vrOrder = null;
		if (rSet.next()) {
			vrOrder = new VrOrder();
			vrOrder.setOrdId(rSet.getInt("order_id"));
			vrOrder.setOrdSubmitTime(rSet.getDate("order_submitTime"));
			vrOrder.setOrdDealTime(rSet.getDate("order_dealTime"));
			vrOrder.setUseStartTime(rSet.getDate("order_useStartTime"));
			vrOrder.setUseEndTime(rSet.getDate("order_useEndTime"));
			vrOrder.setOrdStatus(rSet.getString("order_state"));
			vrOrder.setOrdRejectReason(rSet.getString("order_rejectReason"));
			vrOrder.setCustId(rSet.getInt("customer_cust_id"));
			vrOrder.setAdminId(rSet.getInt("admin_admin_id"));
			vrOrder.setVenueId(rSet.getInt("venue_venue_id"));
			vrOrder.setOrdSubmitReason(rSet.getString("order_submitReason"));
			list.add(vrOrder);
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
	public Integer findCount(Integer custId) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		int num = 0;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select count(*) as count from `order` where customer_cust_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, custId);
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
