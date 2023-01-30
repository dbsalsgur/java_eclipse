package ccsp.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import ccsp.utils.DBUtil;

public class CrimeSysDAO {
	public ArrayList<CrimeRecordVO> getCrimeRecordtotal() {
		ArrayList<CrimeRecordVO> list = new ArrayList<CrimeRecordVO>();
		String tml = "select*from CrimeRecord";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO emVo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				emVo = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getDate(7), rs.getInt(8));
				list.add(emVo);
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}

	public ArrayList<String> getCrimeRegionTableData() {
		ArrayList<String> list = new ArrayList<String>();
		String tml = "select * from Crimeregion";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(2));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}

	public ArrayList<String> getCrimeCategoryTableData() {
		ArrayList<String> list = new ArrayList<String>();
		String tml = "select * from Crimecategory";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(2));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}
	
	public ArrayList<String> getCrimeSexTableData() {
		ArrayList<String> list = new ArrayList<String>();
		String tml = "select * from sex";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(rs.getString(2));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
		return list;
	}
	
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();

		String sql = "select * from CrimeRecord";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();// 메타데이터는 데이터를 설명하는 데이터(속성)

			int cols = rsmd.getColumnCount();

			for (int i = 1; i <= cols; i++) {
				columnName.add(rsmd.getColumnName(i));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
			return columnName;

		}

	}

	// 이름과 주민등록번호
	/**/public CrimeRecordVO getCrimeCheck(String name, int regitNumber) throws Exception {
		String tml = "select * from crime where name = ? and regitNumber=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO emVO = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			pstmt.setString(1, name);
			pstmt.setInt(2, regitNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getDate(7), rs.getInt(8));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return emVO;
	}

	// 범죄분류와 지역
	public CrimeRecordVO getCrimeGroup(int crimNo, int region) throws Exception {
		String tml = "select * from crime where crimNo = ? and region=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO emVO = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			pstmt.setInt(1, crimNo);
			pstmt.setInt(2, region);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				emVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getInt(6), rs.getDate(7), rs.getInt(8));
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return emVO;
	}

}
