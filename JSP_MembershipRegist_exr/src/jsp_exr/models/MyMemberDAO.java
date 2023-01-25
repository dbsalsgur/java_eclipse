package jsp_exr.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;

public class MyMemberDAO {
	private Connection con;
	public MyMemberDAO() throws ServletException {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch(ClassNotFoundException ex) {
			throw new ServletException("드라이버 오류!");
		}
		String url = "jdbc:mysql://localhost:3306/mydatabase";
		String id = "root";
		String pw = "";
		try {
			con = DriverManager.getConnection(url, id, pw);
		} catch (SQLException e) {
			throw new ServletException("접속 오류!");
		}
	}
	
	public boolean registerMember(MyMemberDTO dto) throws ServletException {
		String query = "insert into mymember values(null, ?, ?, ?)";
		try {
			PreparedStatement pstmt = con.prepareStatement(query);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getTel());
			pstmt.setString(3, dto.getAddr());
			pstmt.executeUpdate();
			pstmt.close();
		} catch(SQLException ex) {
			throw new ServletException("등록 실패!");
		} finally {
			this.close();
		}
		return true;
	}
	private void close() {
		try {
			if(con != null && !con.isClosed())
				con.close();
		} catch (SQLException ex) {
			con = null;
		}
	}
}
