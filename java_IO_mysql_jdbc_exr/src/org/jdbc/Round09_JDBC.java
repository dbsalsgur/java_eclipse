package org.jdbc;

import java.util.*;
import java.sql.*;

public class Round09_JDBC {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		try {
			Class cls = Class.forName("com.mysql.jdbc.Driver");
			cls.newInstance();
		} catch (ClassNotFoundException e) {
		} catch (InstantiationException e) {
		} catch (IllegalAccessException e) {
		}
		Connection con = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String query = "";
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase", "root", "");
			query = "drop table my_data";
			stmt = con.createStatement();
			stmt.execute(query);
			stmt.close();
		} catch (SQLException e) {
		}
		try {
			query = "create table my_data(num int primary key, auto_increment, name varchar(20) not null, age int)";
			stmt = con.createStatement();
			stmt.execute(query);
			stmt.close();
		} catch (SQLException e) {
		}
		up: while (true) {
			System.out.print("1.데이터 추가 2.전체출력 3.종료 =");
			int dist = in.nextInt();
			in.nextLine();
			switch (dist) {
			case 1: {
				System.out.print("이름 =");
				String name = in.nextLine();
				System.out.print("나이 = ");
				int age = in.nextInt();
				in.nextLine();
				query = "insert into my_data values(null,?,?)";
				try {
					pstmt = con.prepareStatement(query);
					pstmt.setString(1, name);
					pstmt.setInt(2, age);
					int res_int = pstmt.executeUpdate();
					System.out.println("ressssssssssssssssssssss:" + res_int);
					if (res_int > 0)
						System.out.println("정상적으로 추가 되었습니다");
					else
						System.out.println("추가에 실패 했습니다");
					pstmt.close();
				} catch (SQLException e) {
					System.out.println("ERROR = " + e);
				}
				break;
			}
			case 2:
				System.out.println("전체 정보 출력!");
				String name = in.nextLine();
				int age = in.nextInt();
				query = "select * from my_data";
				try {
					stmt = con.createStatement();
					rs = stmt.executeQuery(query);
					while (rs.next()) {
						int num = rs.getInt("num");
						name = rs.getString("name");
						age = rs.getInt("age");
						System.out.println(num + "번 : " + name + "(" + age + "세");
					}
					rs.close();
					stmt.close();
				} catch (SQLException e) {
					System.out.println("ERROR = " + e);
				}
				break;
			case 3:
				System.out.println("프로그램 종료!");
				break up;
			default:
				System.out.println("잘못 입력 하셨습니다");
			}
			System.out.println();
			try {
				if (con != null && !con.isClosed())
					con.close();
			} catch (SQLException e) {
			}
		}
	}

}
