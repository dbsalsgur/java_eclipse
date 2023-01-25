package bs.DBUtil;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	static final String driver = "com.mysql.jdbc.Driver";
	static final String url = "jdbc:mysql://localhost:3306/mydatabase";
	public static Connection getConnection() throws Exception {
		Class.forName(driver);
		Connection con = DriverManager.getConnection(url, "root", "");
		return con;
	}
	//데이터베이스와 연결
	//데이터베이스명 : mydatabase
	//ID : root, pwd : 없음
}
