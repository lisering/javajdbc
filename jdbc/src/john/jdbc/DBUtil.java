package john.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

	private static final String USERNAME = "root";
	private static final String PASSWORD = "";
	private static final String M_CONN_STRING = "jdbc:mysql://localhost:3306/state";
	private static final String H_CONN_STRING = "jdbc:hsqldb:data:3306/state";

	public static Connection getConnection(DBType dbType) throws SQLException {
		switch (dbType) {
		case MYSQL:
			return DriverManager.getConnection(M_CONN_STRING, USERNAME, PASSWORD);
		case HSQLDB:
			return DriverManager.getConnection(H_CONN_STRING, USERNAME, PASSWORD);
		default:
			return null;
		}
	}
}
