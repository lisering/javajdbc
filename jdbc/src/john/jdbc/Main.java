package john.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String CONN_STRING = 
			"jdbc:hsqldb:data/state";
//			"jdbc:mysql://localhost:3306/state";
	public static void main(String[] args) throws SQLException {
//		Class.forName("com.mysql.jdbc.Driver");
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(CONN_STRING, USERNAME, PASSWORD);
			System.out.println("Connected!");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (conn != null) {
				conn.close();
			}
		}
	}

}
