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
				emVo = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
						rs.getInt(6), rs.getString(7), rs.getInt(8));
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
				emVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
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
				emVO = new CrimeRecordVO(rs.getInt(1), rs.getInt(2), rs.getInt(3), rs.getInt(4), rs.getString(5),
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
		return emVO;
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

	public ArrayList<String> getGenderChart() {
		ArrayList<String> list = new ArrayList<String>();
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
			Counting.counting(list);

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

	public ArrayList<String> getRegionChart() {
		ArrayList<String> list = new ArrayList<String>();
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
			Counting.counting(list);

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

	public ArrayList<String> getCrimCateChart() {
		ArrayList<String> list = new ArrayList<String>();
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
			Counting.counting(list);

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
