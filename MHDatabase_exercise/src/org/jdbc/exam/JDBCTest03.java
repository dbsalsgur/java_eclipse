package org.jdbc.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCTest03 {
	final static String sql = "insert into employee values (null,?,?,?,?)";
	//?는 바인딩 변수. 변수에 사용자의 입력 값을 담는다. 

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sname, sjobGrade, semail, stemp;
		int ndepartment;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("사원 정보 입력하기");
			
			System.out.print("이름 입력 >>");
			sname = br.readLine();
			System.out.print("직책 입력 >>");
			sjobGrade = br.readLine();
			System.out.print("부서번호 입력(10, 20, 30..) >>");
			stemp = br.readLine();
			ndepartment = Integer.parseInt(stemp);
			System.out.print("이메일 입력 >>");
			semail = br.readLine();
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, "root", "");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sname);
			pstmt.setString(2, sjobGrade);
			pstmt.setInt(3, ndepartment);
			pstmt.setString(4, semail);
			int rowCount = pstmt.executeUpdate();
			
			System.out.print(rowCount);
			
		} catch (Exception e){
			System.out.println(e);
		} finally {
			try {
				if (pstmt != null) {
					pstmt.close();
				}
				if (con != null)
					con.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
