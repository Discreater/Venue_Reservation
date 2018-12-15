package common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 封装了对MySQl的处理
 * @author Tqq
 *
 */
public class MySQLHelper {
	public static Connection connect1() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/venue_reservation?characterEncoding=gbk", "root", "159753");
			System.out.println("数据库连接失败");
			return connection;
		}catch (SQLException e) {
			System.out.println("数据库连接失败");
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
		}
		return null;
	}
	
	public static void closeResult(ResultSet rs) {
		try {
			rs.close();
		}catch (Exception e) {
			System.out.println("关闭结果集时出错");
		}
	}
	
	public static void closePreparedStatement(PreparedStatement ps) {
		try {
			ps.close();
		}catch (SQLException e) {
			System.out.println("关闭preparedStatement时出错");
		}
	}
	public static void closeConnection(Connection connection) {
		try {
			connection.close();
		} catch (SQLException e) {
			System.out.println("关闭连接失败");
		}
	}
}
