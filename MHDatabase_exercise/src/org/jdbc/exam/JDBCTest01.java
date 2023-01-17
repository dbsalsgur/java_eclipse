package org.jdbc.exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class JDBCTest01 {

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		Connection con = null;
		Statement stmt = null;
		try {
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "");
			stmt = con.createStatement();
			System.out.println("데이터베이스 연결 성공!");
		} catch (Exception e){
			System.out.println("데이터베이스 연결 실패!");
		} finally {
			try {
				if (con != null)
					con.close();
				if (stmt != null)
					stmt.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
