package crim.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import crim.DBUtil.DBUtil;


public class CriminalDAO {
	private static final String UPDATE = "update crimerecord set region=?, sex=?, crimeRecord=?, name=?, regitNumber=?, date=?, crimDivNo=? where crimNo=?";
	private static final String SHOW_DATA = "select * from crimerecord";
	private static final String FIND_DATA = "select * from crimerecord where crimNo = ?";
	//한글좀 깨지지 마라!!!!!!!!
	
	public CrimeRecordVO getCriminalRegister(CrimeRecordVO crVO) throws Exception {
		String dml = "insert into crimerecord"
				+ " (region,sex,crimeRecord,name,regitNumber,date,crimDivNo)" + "values " + " (?,	?,	?,	?, ?, ?, ? )";
		Connection con = null;
		PreparedStatement pstmt = null;
		CrimeRecordVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, crVO.getRegion());
			pstmt.setInt(2, crVO.getSex());
			pstmt.setInt(3, crVO.getcRecord());
			pstmt.setString(4, crVO.getName());
			pstmt.setInt(5, crVO.getRegitNumber());
			pstmt.setString(6, crVO.getDate());
			pstmt.setInt(7, crVO.getCrimDivNo());
			
			int i = pstmt.executeUpdate();
			retval = new CrimeRecordVO();
		} catch(SQLException e) {
			System.out.println("e=["+e+"]");
		} catch (Exception e) {
			System.out.println("e=["+e+"]");
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				
			}
		}
		return retval;
	}
	
	public CrimeRecordVO getCriminalCheck(int no) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(FIND_DATA);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				retval = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
			}
		} catch(SQLException se) {
			System.out.println(se);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				
			}
		}
		return retval;
	}
	
	public CrimeRecordVO getCriminalUpdate(CrimeRecordVO cvo) throws Exception {
		Connection con = null;
		PreparedStatement pstmt = null;
		CrimeRecordVO resultValue = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(UPDATE);
			pstmt.setInt(1, cvo.getRegion());
			pstmt.setInt(2, cvo.getSex());
			pstmt.setInt(3, cvo.getcRecord());
			pstmt.setString(4, cvo.getName());
			pstmt.setInt(5, cvo.getRegitNumber());
			pstmt.setString(6, cvo.getDate());
			pstmt.setInt(7, cvo.getCrimDivNo());
			pstmt.setInt(8, cvo.getCrimNo());
			int i = pstmt.executeUpdate();
			resultValue = new CrimeRecordVO();
		} catch(SQLException e) {
			System.out.println("e=["+e+"]");
		} catch (Exception e) {
			System.out.println("e=["+e+"]");
		} finally {
			try {
				if (pstmt != null) pstmt.close();
				if(con != null) con.close();
			} catch (SQLException e) {
				
			}
		}
		return resultValue;
	}
	
	public ArrayList<CrimeRecordVO> getCriminaltotal() {
		ArrayList<CrimeRecordVO> list = new ArrayList<CrimeRecordVO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO crVo = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(SHOW_DATA);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				crVo = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
				list.add(crVo);
			}
		} catch(SQLException se) {
			System.out.println(se);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				
			}
		}
		return list;
	}
	
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName= new ArrayList<String>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(SHOW_DATA);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			for (int i = 1; i <= cols; i++) {
				columnName.add(rsmd.getColumnName(i));
			}
		} catch(SQLException se) {
			System.out.println(se);
		} catch(Exception e) {
			System.out.println(e);
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(con != null)	con.close();
			} catch (SQLException e) {
				
			}
		}
		return columnName;
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
	
	public ArrayList<String> getCrimeRecordTableData() {
		ArrayList<String> list = new ArrayList<String>();
		String tml = "select * from crecord";

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
}
