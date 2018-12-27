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
		VrCommitDao vrCommitDao = new VrCommitDao();
		VrCommit vrCommit = null;
		Integer hash = ("" + obj.getAdminId() + obj.getCustId() + System.currentTimeMillis() % Integer.MAX_VALUE
				+ obj.getCommitContext()).hashCode();
		int i = 1;
		while (true) {
			vrCommit = vrCommitDao.findByHash(hash);
			if (vrCommit == null) {
				break;
			}
			hash = (hash + (i * i) % Integer.MAX_VALUE) % Integer.MAX_VALUE;
			i++;
		}
		obj.setHash(hash);
		try {
			connection = MySQLHelper.getConnection();
			String sql = "insert into commit " + "(commit_state, " + "commit_context, " + "commit_type, commit_hash) "
					+ " values(?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getCommitState());
			pStatement.setString(2, obj.getCommitContext());
			pStatement.setString(3, obj.getCommitType());
			pStatement.setInt(4, obj.getHash());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			obj.setCommitId(vrCommitDao.findByHash(hash).getCommitId());
			obj.setCommitSubmitTime(vrCommitDao.findByHash(hash).getCommitSubmitTime());
			vrCommitDao.update(obj);
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
			String sql = "update commit set " + "commit_state=?, " + "commit_context=?, commit_submitTime=?, "
					+ ((obj.getCustId() != null && obj.getCustId() != 0) ? "customer_cust_id=?, " : "")
					+ ((obj.getAdminId() != null && obj.getAdminId() != 0) ? "admin_admin_id=?, " : "")
					+ "commit_type=?, commit_hash=? " + "where commit_id=?";
			pStatement = connection.prepareStatement(sql);
			int i = 1;
			pStatement.setString(i++, obj.getCommitState());
			pStatement.setString(i++, obj.getCommitContext());
			pStatement.setTimestamp(i++, obj.getCommitSubmitTime());
			if ((obj.getCustId() != null && obj.getCustId() != 0)) {
				pStatement.setInt(i++, obj.getCustId());
			}
			if (obj.getAdminId() != null && obj.getAdminId() != 0) {
				pStatement.setInt(i++, obj.getAdminId());
			}
			pStatement.setString(i++, obj.getCommitType());
			pStatement.setInt(i++, obj.getHash());
			pStatement.setInt(i++, obj.getCommitId());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
			for (StackTraceElement ste : e.getStackTrace()) {
				System.err.println(ste);
			}
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
				vrCommit.setHash(rSet.getInt("commit_hash"));
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
	public VrCommit findByHash(Integer hash) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrCommit vrCommit = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit where commit_hash=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, hash);
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
				vrCommit.setHash(rSet.getInt("commit_hash"));
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
			String sql = "select * from commit limit " + (pageNo - 1) * pageSize + "," + pageSize;
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
	public List<VrCommit> findByReverse(Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit order by commit_id desc limit " + (pageNo - 1) * pageSize + ","
					+ pageSize;
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
	public List<VrCommit> findByReverse(String type, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit where commit_type=? and commit_state<>'reject' order by commit_id desc limit "
					+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, type);
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
			String sql = "select * from commit where customer_cust_id=? limit " + (pageNo - 1) * pageSize + ","
					+ pageSize;
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
			String sql = "select * from commit where admin_admin_id=? limit " + (pageNo - 1) * pageSize + ","
					+ pageSize;
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
	public List<VrCommit> findByState(String state, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrCommit> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from commit where commit_state=? limit " + (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, state);
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
