package ccsp.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import ccsp.utils.Counting;
import ccsp.utils.DBUtil;

public class CrimeSysDAO {
	
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
		String FIND_DATA = "select * from crimerecord where crimNo = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO retval = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(FIND_DATA);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			// SELECT쿼리 사용시 쓰는 메소드
			if (rs.next()) {
				retval = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
			}
			// ResultSet을 이용해 데이터베이스에 저장된 값을 반환.
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
		return retval;
		// 범죄자 정보조회 구현
		// 범죄번호를 통해 해당 레코드를 리턴
	}

	public CrimeRecordVO getCriminalUpdate(CrimeRecordVO cvo) throws Exception {
		String UPDATE = "update crimerecord set region=?, sex=?, crimeRecord=?, name=?, regitNumber=?, date=?, crimDivNo=? where crimNo=?";
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
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {

			}
		}
		// SQLException을 먼저 캐치, SQL과 관련없는 예외도 캐치하기 위해 Exception도 배치
		// 클래스의 동작이 끝나면 연결해제, pstmt에 담긴 문구도 null로 비워준다.
		return resultValue;
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

	public ArrayList<String> getCRecordTableData() {
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

	public ArrayList<CrimeRecordVO> getCrimeRecordtotal() {
		ArrayList<CrimeRecordVO> list = new ArrayList<CrimeRecordVO>();
		String tml = "select*from CrimeRecord";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO crVO = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				crVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
				list.add(crVO);
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
				e.printStackTrace();
			}
		}
		return columnName;
	}

	// 이름과 주민등록번호
	/**/public CrimeRecordVO getCrimeCheck(String name, int regitNumber) throws Exception {
		String tml = "select * from crime where name = ? and regitNumber=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO crVO = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			pstmt.setString(1, name);
			pstmt.setInt(2, regitNumber);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				crVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
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
		return crVO;
	}

	// 범죄분류와 지역
	public CrimeRecordVO getCrimeGroup(int crimNo, int region) throws Exception {
		String tml = "select * from crime where crimNo = ? and region=?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO crVO = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			pstmt.setInt(1, crimNo);
			pstmt.setInt(2, region);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				crVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
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
		return crVO;
	}

//
	public ArrayList<CrimeRecordVO> getRecordByRandomCondition(CrimeRecordVO crVO) throws Exception {
		ArrayList<CrimeRecordVO> list = new ArrayList<CrimeRecordVO>();

		String crimNoSql;
		String regionSql;
		String sexSql;
		String cRecordSql;
		String nameSql;
		String regitNumberSql;
		String dateSql;
		String crimDivNoSql;
		String nullSql = " is not null ";

		if (crVO.getCrimNo() != 0) {
			crimNoSql = "=" + "'" + crVO.getCrimNo() + "'" + " ";
		} else {
			crimNoSql = nullSql;
		}

		if (crVO.getRegion() != 0) {
			regionSql = "=" + crVO.getRegion() + " ";
		} else {
			regionSql = nullSql;
		}

		if (crVO.getSex() != 0) {
			sexSql = "=" + crVO.getSex() + " ";
		} else {
			sexSql = nullSql;
		}

		if (crVO.getcRecord() != 0) {
			cRecordSql = "=" + crVO.getcRecord() + " ";
		} else {
			cRecordSql = nullSql;
		}

		if (crVO.getName() != "") {
			nameSql = "=" + "'" + crVO.getName() + "'" + " ";
		} else {
			nameSql = nullSql;
		}

		if (crVO.getRegitNumber() != 0) {
			regitNumberSql = "=" + "'" + crVO.getRegitNumber() + "'" + " ";
		} else {
			regitNumberSql = nullSql;
		}

		if (crVO.getDate() != "") {
			dateSql = "=" + "'" + crVO.getDate() + "'" + " ";
		} else {
			dateSql = nullSql;
		}

		if (crVO.getCrimDivNo() != 0) {
			crimDivNoSql = "=" + crVO.getCrimDivNo() + " ";
		} else {
			crimDivNoSql = nullSql;
		}

		String tml = "select * from crimeRecord where crimNo" + crimNoSql + "and " + "region" + regionSql + "and "
				+ "sex" + sexSql + "and " + "crimerecord" + cRecordSql + "and " + "name" + nameSql + "and "
				+ "regitNumber" + regitNumberSql + "and " + "date" + dateSql + "and " + "crimDivNo" + crimDivNoSql;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CrimeRecordVO crVOtoArray = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				crVOtoArray = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
				list.add(crVOtoArray);
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
		System.out.println(tml);
		System.out.println("사이즈입니다." + list.size());

		return list;
	}

	public ArrayList<ChartDataSet> getGenderChart() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ChartDataSet> chartList = new ArrayList();
		String tml = "select crimerecord.sex, sex.sex from crimerecord left join sex on crimerecord.sex = sex.sexNo";

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
			chartList = Counting.counting(list);

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
		return chartList;

	}

	public ArrayList<ChartDataSet> getRegionChart() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ChartDataSet> chartList = new ArrayList();

		String tml = "select crimerecord.sex, crimeregion.regionName from crimerecord left join crimeregion on crimerecord.region = crimeregion.regionNo";

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
			chartList = Counting.counting(list);

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
		return chartList;

	}

	public ArrayList<ChartDataSet> getCrimCateChart() {
		ArrayList<String> list = new ArrayList<String>();
		ArrayList<ChartDataSet> chartList = new ArrayList();

		String tml = "select crimerecord.crimDivNo, crimecategory.category from crimerecord left join crimecategory on crimerecord.crimDivNo = crimecategory.categoryNo";

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
			chartList = Counting.counting(list);

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
		return chartList;

	}

}
