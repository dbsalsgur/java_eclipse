package utils;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	//접속 드라이버
	static final String driver = "com.mysql.jdbc.Driver";
	//접속 주소(약속된 도메인)
	static final String url = "jdbc:mysql://localhost:3306/crimesys";
	public static Connection getConnection() throws Exception{
		//내가 쓴 이름으로 클래스를 만들어라, 객체화
		Class.forName(driver);
		//getConnection 실제로 연결시켜주는 메서드
		Connection con = DriverManager.getConnection(url, "root", "");
		return con;
	}
}
