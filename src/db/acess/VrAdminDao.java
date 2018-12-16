package db.acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.MySQLHelper;
import db.inter.IVrAdminDao;
import db.model.VrAdmin;

public class VrAdminDao implements IVrAdminDao {

	@Override
	public void insert(VrAdmin obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "insert into admin (admin_name, admin_password) values(?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getAdminName());
			pStatement.setString(2, obj.getAdminPassword());
			pStatement.executeUpdate();
		} catch (Exception e) {

		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
	}

	@Override
	public void update(VrAdmin obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "update admin set admin_name=?, admin_password=? where admin_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getAdminName());
			pStatement.setString(2, obj.getAdminPassword());
			pStatement.setInt(3, obj.getAdminId());
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
			String sql = "delete from admin where admin_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			pStatement.executeUpdate();
		} catch (Exception e) {
			
		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}

	}

	@Override
	public VrAdmin findById(Integer id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrAdmin vrAdmin = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from admin where admin_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrAdmin = new VrAdmin();
				vrAdmin.setAdminId(rSet.getInt("admin_id"));
				vrAdmin.setAdminName(rSet.getString("admin_name"));
				vrAdmin.setAdminPassword(rSet.getString("admin_password"));
				vrAdmin.setAdminCreatTime(rSet.getDate("creat_time"));
			}
		} catch (Exception e) {

		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrAdmin;
	}

	@Override
	public List<VrAdmin> findAll() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrAdmin> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from admin";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrAdmin vrAdmin = null;
			while (rSet.next()) {
				vrAdmin = new VrAdmin();
				vrAdmin.setAdminId(rSet.getInt("admin_id"));
				vrAdmin.setAdminName(rSet.getString("admin_name"));
				vrAdmin.setAdminPassword(rSet.getString("admin_password"));
				vrAdmin.setAdminCreatTime(rSet.getDate("creat_time"));
				list.add(vrAdmin);
			}
		} catch (Exception e) {

		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}

		return list;
	}

	@Override
	public List<VrAdmin> findPage(int pageSize, int pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrAdmin> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from admin limit " + (pageNo-1)*pageSize + ","+pageSize;
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrAdmin vrAdmin = null;
			while (rSet.next()) {
				vrAdmin = new VrAdmin();
				vrAdmin.setAdminId(rSet.getInt("admin_id"));
				vrAdmin.setAdminName(rSet.getString("admin_name"));
				vrAdmin.setAdminPassword(rSet.getString("admin_password"));
				vrAdmin.setAdminCreatTime(rSet.getDate("creat_time"));
				list.add(vrAdmin);
			}
		} catch (Exception e) {

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
			String sql = "select count(*) as count from admin";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			if(rSet.next()){
				num =rSet.getInt("count"); 
			}
		}catch (Exception e) {
			
		}finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return num;
	}

	@Override
	public VrAdmin findOne(String adminName, String admimnPassword) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrAdmin vrAdmin = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from admin where admin_name=?, admin_password=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, adminName);
			pStatement.setString(2, admimnPassword);
			rSet = pStatement.executeQuery();
			if(rSet.next()) {
				vrAdmin = new VrAdmin();
				vrAdmin.setAdminId(rSet.getInt("admin_id"));
				vrAdmin.setAdminName(rSet.getString("admin_name"));
				vrAdmin.setAdminPassword(rSet.getString("admin_password"));
				vrAdmin.setAdminCreatTime(rSet.getDate("creat_time"));
			}
		}catch (Exception e) {
			
		}finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrAdmin;
	}

}
