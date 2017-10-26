package john.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import john.jdbc.tables.Tours;
import john.jdbc.util.InputHelper;

public class Main {
	private static final String SQL = "SELECT * FROM state WHERE id <= ?";
	public static void main(String[] args) throws SQLException {
		ResultSet rs = null;
		double id;
		try {
			id = InputHelper.getDoubleInput("Enter a id: ");
		} catch (NumberFormatException e) {
			System.err.println("Error: invalid number");
			return;
		}
		try (
			Connection conn = DBUtil.getConnection(DBType.MYSQL);
			PreparedStatement stmt = conn.prepareStatement(
					SQL,
					ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);
				) {
			stmt.setDouble(1, id);
			rs = stmt.executeQuery();
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
