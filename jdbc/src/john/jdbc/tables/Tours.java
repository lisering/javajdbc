package john.jdbc.tables;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Tours {
	
	public static void displayData(ResultSet rs) throws SQLException {
		while (rs.next()) {
			StringBuffer buffer = new StringBuffer();
			buffer.append("id: " + rs.getInt("id") + " ");
			buffer.append("站名: " + rs.getString("stateName"));
			System.out.println(buffer.toString());
		}
	}
}
