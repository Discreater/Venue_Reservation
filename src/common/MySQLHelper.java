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
	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection = DriverManager.getConnection("jdbc:mysql://192.168.1.100:3306/venue_reservation?serverTimezone=GMT%2B8&useUnicode=true&characterEncoding=utf-8&useSSL=false", "root", "159753");
			return connection;
		}catch (SQLException e) {
			System.out.println("数据库连接失败");
			System.out.println(e);
		} catch (ClassNotFoundException e) {
			System.out.println("驱动加载失败");
		}
		return null;
	}
	
	public static void closeResult(ResultSet rSet) {
		try {
			rSet.close();
		}catch (Exception e) {
			System.out.println("关闭结果集时出错");
		}
	}
	
	public static void closePreparedStatement(PreparedStatement pStatement) {
		try {
			pStatement.close();
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
