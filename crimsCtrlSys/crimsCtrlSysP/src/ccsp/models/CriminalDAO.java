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
			//SELECT쿼리 사용시 쓰는 메소드
			if (rs.next()) {
				retval = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5), rs.getInt(6), rs.getString(7), rs.getInt(8));
			}
			//ResultSet을 이용해 데이터베이스에 저장된 값을 반환.
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
		//범죄자 정보조회 구현
		//범죄번호를 통해 해당 레코드를 리턴
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
//			if (i <= 0) {
//				System.out.println("잘못 입력하셨습니다.");
//			}
//			System.out.println(i);
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
		//SQLException을 먼저 캐치, SQL과 관련없는 예외도 캐치하기 위해 Exception도 배치
		//클래스의 동작이 끝나면 연결해제, pstmt에 담긴 문구도 null로 비워준다.
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
