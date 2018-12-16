package db.acess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import common.MySQLHelper;
import db.inter.IVrVenueDao;
import db.model.VrVenue;

public class VrVenueDao implements IVrVenueDao {

	@Override
	public void insert(VrVenue obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "insert into venue" + " (venue_name, venue_ownerName, "
					+ "venue_ownerPhone, venue_ownerEmail, " + "venue_ownerAddress, venue_picture,"
					+ "venue_address, venue_info, " + "venue_state) " + "values(?,?,?,?,?,?,?,?,?)";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getVenueName());
			pStatement.setString(2, obj.getVenueOwnerName());
			pStatement.setString(3, obj.getVenueOwnerPhone());
			pStatement.setString(4, obj.getVenueOwnerEmail());
			pStatement.setString(5, obj.getVenueOwnerAddress());
			pStatement.setString(6, obj.getVenuePicture());
			pStatement.setString(7, obj.getVenueAddress());
			pStatement.setString(8, obj.getVenueInfo());
			pStatement.setString(9, obj.getVenueState());
			pStatement.executeUpdate();
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
	}

	@Override
	public void update(VrVenue obj) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "update order set " + "venue_name=?, venue_ownerName=?, "
					+ "venue_ownerPhone=?, venue_ownerEmail=?, " + "venue_ownerAddress=?, venue_picture=?,"
					+ "venue_address=?, venue_info=?, " + "venue_state=? where venue_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, obj.getVenueName());
			pStatement.setString(2, obj.getVenueOwnerName());
			pStatement.setString(3, obj.getVenueOwnerPhone());
			pStatement.setString(4, obj.getVenueOwnerEmail());
			pStatement.setString(5, obj.getVenueOwnerAddress());
			pStatement.setString(6, obj.getVenuePicture());
			pStatement.setString(7, obj.getVenueAddress());
			pStatement.setString(8, obj.getVenueInfo());
			pStatement.setString(9, obj.getVenueState());
			pStatement.setInt(10, obj.getVenueId());
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
			String sql = "delete from venue where venue_id=?";
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
	public VrVenue findById(Integer id) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		VrVenue vrVenue = null;
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue where venue_id=?";
			pStatement = connection.prepareStatement(sql);
			pStatement.setInt(1, id);
			rSet = pStatement.executeQuery();
			if (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
			}
		} catch (Exception e) {
			System.err.println(e);
		} finally {
			MySQLHelper.closeResult(rSet);
			MySQLHelper.closePreparedStatement(pStatement);
			MySQLHelper.closeConnection(connection);
		}
		return vrVenue;
	}

	@Override
	public List<VrVenue> findAll() {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue";
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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
	public List<VrVenue> findPage(int pageSize, int pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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
			String sql = "select count(*) as count from venue";
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
	public List<VrVenue> findPageByVenueName(String catVenueName, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue where venue_name like '%?' limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, catVenueName);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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
	public List<VrVenue> findPageByOwnerName(String catOwnerName, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue where venue_ownerName like '%?' limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, catOwnerName);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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
	public List<VrVenue> findPageByAddress(String catVenueAddress, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue where venue_address like '%?' limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, catVenueAddress);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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
	public List<VrVenue> findPageByInfo(String catInfo, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue where venue_info like '%?' limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, catInfo);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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
	public List<VrVenue> findPageByState(String state, Integer pageSize, Integer pageNo) {
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		List<VrVenue> list = new ArrayList<>();
		try {
			connection = MySQLHelper.getConnection();
			String sql = "select * from venue where venue_state=? limit "+ (pageNo - 1) * pageSize + "," + pageSize;
			pStatement = connection.prepareStatement(sql);
			pStatement.setString(1, state);
			rSet = pStatement.executeQuery();
			VrVenue vrVenue = null;
			while (rSet.next()) {
				vrVenue = new VrVenue();
				vrVenue.setVenueId(rSet.getInt("venue_id"));
				vrVenue.setVenueName(rSet.getString("venue_name"));
				vrVenue.setVenueOwnerName(rSet.getString("venue_ownerName"));
				vrVenue.setVenueOwnerPhone(rSet.getString("venue_ownerPhone"));
				vrVenue.setVenueOwnerAddress(rSet.getString("venue_ownerAddress"));
				vrVenue.setVenuePicture(rSet.getString("venue_picture"));
				vrVenue.setVenueAddress(rSet.getString("venue_address"));
				vrVenue.setVenueInfo(rSet.getString("venue_info"));
				vrVenue.setVenueState(rSet.getString("venue_state"));
				vrVenue.setVenueCreateTime(rSet.getDate("create_time"));
				list.add(vrVenue);
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

//	@Override
//	public Integer findCount(Integer catId, String venueName) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
