package Inven_Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Inven_Model.ClientVO;
import Inven_Util.DBUtil;

public class ClientDAO {
	public ArrayList<ClientVO> getClientTotal() {
		ArrayList<ClientVO> list = new ArrayList<ClientVO>();
		String dml = "select * from client";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ClientVO cl = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				cl = new ClientVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6));

				list.add(cl);
			}
		} catch (SQLException se) {
			System.out.println("sql 예외발생");
		} catch (Exception e) {
			System.out.println("예외발생");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException se) {
				System.out.println("sql 예외발생");
			}
		}
		return list;
	}

//전체조회 탭에서 속성명 불러오기
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();

		String sql = "select * from Client";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();

			int cols = rsmd.getColumnCount();
			for (int i = 1; i <= cols; i++) {
				columnName.add(rsmd.getColumnName(i));
			}

		} catch (SQLException se) {
			System.out.println("sql 예외발생");
		} catch (Exception e) {
			System.out.println("예외발생");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println("sql 예외발생");
			}
		}
		return columnName;
	}
}
