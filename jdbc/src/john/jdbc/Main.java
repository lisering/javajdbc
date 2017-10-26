package john.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import john.jdbc.tables.Tours;

public class Main {
	public static void main(String[] args) throws SQLException {
		ResultSet rs = null;
		try (
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
				) {
			stmt.setMaxRows(10);
			rs = stmt.executeQuery("SELECT * FROM state");
			Tours.displayData(rs);
		} catch (SQLException e) {
			DBUtil.processException(e);
		} finally {
			if (rs != null) {
				rs.close();
			}
		}
	}

}
