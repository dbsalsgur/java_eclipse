package crim.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/crimerecord";
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "root", "");
		return con;
	}
}