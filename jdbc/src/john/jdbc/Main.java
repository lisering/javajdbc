package john.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	public static void main(String[] args) throws SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
//			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			conn = DBUtil.getConnection(DBType.MYSQL);
			stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			rs = stmt.executeQuery("SELECT * FROM state");
			rs.last();
			System.out.println("Number of rows: " + rs.getRow());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (rs != null) {
				rs.close();
			}
			if (stmt!= null) {
				stmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		}
	}

}
