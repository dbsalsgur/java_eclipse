package org.jdbc.exam;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCTest03 {
	final static String sql = "insert into employee values (null,?,?,?,?)";
	//?�� ���ε� ����. ������ ������� �Է� ���� ��´�. 

	public static void main(String[] args) {
		String driver = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		Connection con = null;
		PreparedStatement pstmt = null;
		
		String sname, sjobGrade, semail, stemp;
		int ndepartment;
		
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("��� ���� �Է��ϱ�");
			
			System.out.print("�̸� �Է� >>");
			sname = br.readLine();
			System.out.print("��å �Է� >>");
			sjobGrade = br.readLine();
			System.out.print("�μ���ȣ �Է�(10, 20, 30..) >>");
			stemp = br.readLine();
			ndepartment = Integer.parseInt(stemp);
			System.out.print("�̸��� �Է� >>");
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
