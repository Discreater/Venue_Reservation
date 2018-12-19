package db.acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.MySQLHelper;
import db.inter.IVrCommitDao;
import db.model.VrCommit;

public class VrCommitDao implements IVrCommitDao {

	@Override
	public void insert(VrCommit obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "insert into commit " 
					+ "(commit_state, "
					+ "commit_context, commit_submitTime, " 
					+ "commit_type) " 
					+ "values(?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getCommitState());
			pStatement.setString(2, obj.getCommitContext());
			pStatement.setTimestamp(3, obj.getCommitSubmitTime());
			pStatement.setString(4, obj.getCommitType());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
	}

	@Override
	public void update(VrCommit obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "update commit set " 
					+ "commit_state=?, "
					+ "commit_context=?, commit_submitTime=?, " 
					+ "customer_cust_id=?, admin_admin_id=?, "
					+ "commit_type " 
					+ "where commit_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getCommitState());
			pStatement.setString(2, obj.getCommitContext());
			pStatement.setTimestamp(3, obj.getCommitSubmitTime());
			pStatement.setInt(4, obj.getCustId());
			pStatement.setInt(5, obj.getAdminId());
			pStatement.setString(6, obj.getCommitType());
			pStatement.setInt(7, obj.getCommitId());
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
			String sql = "delete from commit where commit_id=?";
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
	public VrCommit findById(Integer id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrCommit vrCommit = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit where commit_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrCommit = new VrCommit();
				vrCommit.setCommitId(rSet.getInt("commit_id"));
				vrCommit.setCommitState(rSet.getString("commit_state"));
				vrCommit.setCommitContext(rSet.getString("commit_context"));
				vrCommit.setCommitSubmitTime(rSet.getTimestamp("commit_submitTime"));
				vrCommit.setCustId(rSet.getInt("customer_cust_id"));
				vrCommit.setAdminId(rSet.getInt("admin_admin_id"));
				vrCommit.setCommitType(rSet.getString("commit_type"));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrCommit;
	}

	@Override
	public List<VrCommit> findAll() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrCommit vrCommit = null;
			while (rSet.next()) {
				vrCommit = new VrCommit();
				vrCommit.setCommitId(rSet.getInt("commit_id"));
				vrCommit.setCommitState(rSet.getString("commit_state"));
				vrCommit.setCommitContext(rSet.getString("commit_context"));
				vrCommit.setCommitSubmitTime(rSet.getTimestamp("commit_submitTime"));
				vrCommit.setCustId(rSet.getInt("customer_cust_id"));
				vrCommit.setAdminId(rSet.getInt("admin_admin_id"));
				vrCommit.setCommitType(rSet.getString("commit_type"));
				list.add(vrCommit);
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
	public List<VrCommit> findPage(int pageSize, int pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrCommit vrCommit = null;
			while (rSet.next()) {
				vrCommit = new VrCommit();
				vrCommit.setCommitId(rSet.getInt("commit_id"));
				vrCommit.setCommitState(rSet.getString("commit_state"));
				vrCommit.setCommitContext(rSet.getString("commit_context"));
				vrCommit.setCommitSubmitTime(rSet.getTimestamp("commit_submitTime"));
				vrCommit.setCustId(rSet.getInt("customer_cust_id"));
				vrCommit.setAdminId(rSet.getInt("admin_admin_id"));
				vrCommit.setCommitType(rSet.getString("commit_type"));
				list.add(vrCommit);
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
			String sql = "select count(*) as count from commit";
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
	public List<VrCommit> findByCustId(Integer custId, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit where customer_cust_id=? limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, custId);
			rSet = pStatement.executeQuery();
			VrCommit vrCommit = null;
			while (rSet.next()) {
				vrCommit = new VrCommit();
				vrCommit.setCommitId(rSet.getInt("commit_id"));
				vrCommit.setCommitState(rSet.getString("commit_state"));
				vrCommit.setCommitContext(rSet.getString("commit_context"));
				vrCommit.setCommitSubmitTime(rSet.getTimestamp("commit_submitTime"));
				vrCommit.setCustId(rSet.getInt("customer_cust_id"));
				vrCommit.setAdminId(rSet.getInt("admin_admin_id"));
				vrCommit.setCommitType(rSet.getString("commit_type"));
				list.add(vrCommit);
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
	public List<VrCommit> findByAdminId(Integer adminId, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit where admin_admin_id=? limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, adminId);
			rSet = pStatement.executeQuery();
			VrCommit vrCommit = null;
			while (rSet.next()) {
				vrCommit = new VrCommit();
				vrCommit.setCommitId(rSet.getInt("commit_id"));
				vrCommit.setCommitState(rSet.getString("commit_state"));
				vrCommit.setCommitContext(rSet.getString("commit_context"));
				vrCommit.setCommitSubmitTime(rSet.getTimestamp("commit_submitTime"));
				vrCommit.setCustId(rSet.getInt("customer_cust_id"));
				vrCommit.setAdminId(rSet.getInt("admin_admin_id"));
				vrCommit.setCommitType(rSet.getString("commit_type"));
				list.add(vrCommit);
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
			String sql = "select count(*) as count from commit where customer_cust_id=?";
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
