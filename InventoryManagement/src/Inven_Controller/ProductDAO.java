package Inven_Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Inven_Model.ProductVO;
import Inven_Util.DBUtil;

public class ProductDAO {
	// 입력_제품 입력
	public ProductVO InsertProduct(ProductVO pvo) throws Exception {
		String dml = "insert into product values (?,?,?,?,?)";

		Connection con = null;
		PreparedStatement pstmt = null;
		ProductVO retval = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, pvo.getProcode());
			pstmt.setString(2, pvo.getProname());
			pstmt.setString(3, pvo.getProtype());
			pstmt.setInt(4, pvo.getProprice());
			pstmt.setInt(5, pvo.getProquan());

			int i = pstmt.executeUpdate();
			retval = new ProductVO();

		} catch (SQLException e) {
			System.out.println("sql예외발생");
		} catch (Exception e) {
			System.out.println("예외발생");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {

			}

		}
		return retval;
	}

	// 제품 삭제
	public ProductVO DeleteProduct(ProductVO pvo) throws Exception {
		String dml = "delete from product where procode = ?";

		Connection con = null;
		PreparedStatement pstmt = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, pvo.getProcode());
			pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("제품 삭제 sql 예외발생");
		} catch (Exception e) {
			System.out.println("제품 삭제 예외발생");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
		return null;
	}

	// 조회_procode 불러오기
	public ArrayList<String> getProcode() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		String dml = "select procode from product";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				String str;
//				ProductVO pi = new ProductVO();
//
//				pi.setProcode(rs.getString(1));
//				str = pi.getProcode();
//
//				list.add(str);
				list.add(rs.getString(1));
			}

		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
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
				System.out.println(se);
				System.out.println("sql 예외발생");
			}
		}
		return list;
	}

	// 조회_proname 불러오기
	public ArrayList<String> getProname() throws Exception {
		ArrayList<String> list = new ArrayList<String>();
		String dml = "select proname from product";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
//				String str;
//				ProductVO pi = new ProductVO();
//
//				pi.setProcode(retval.getString(2));
//				str = pi.getProname();
//
//				list.add(str);
				list.add(rs.getString(1));
			}

		} catch (Exception e) {
			System.out.println(e);
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
				System.out.println(se);
				System.out.println("sql 예외발생");
			}
		}
		return list;
	}

	// 전체조회 속성명 불러오기
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();

		String sql = "select * from product";
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
			System.out.println("sql예외발생");
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
			}
		}
		return columnName;
	}

	// 전체 조회
	public ArrayList<ProductVO> getProducttotal() {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		String tml = "select * from product";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO prvo = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				prvo = new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				list.add(prvo);
			}

		} catch (SQLException se) {
			System.out.println("sql예외발생");
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
			}
		}
		return list;

	}
	public ArrayList<ProductVO> getRecordByRandomCondition(ProductVO prVO) throws Exception {
		ArrayList<ProductVO> list = new ArrayList<ProductVO>();

		String procodeSql;
		String pronameSql;
		String nullSql = " is not null ";

		if (prVO.getProcode() != "") {
			procodeSql = "=" + "'" + prVO.getProcode() + "'" + " ";
		} else {
			procodeSql = nullSql;
		}

		if (prVO.getProname() != "") {
			pronameSql = "=" + "'"+ prVO.getProname() + "'" + " ";
		} else {
			pronameSql = nullSql;
		}
		
		String dml = "select * from product where procode" + procodeSql + "and " + "proname" + pronameSql;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ProductVO prVOtoArray = null;
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				prVOtoArray = new ProductVO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5));
				list.add(prVOtoArray);
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
//		System.out.println(tml);
//		System.out.println("사이즈입니다." + list.size());

		return list;
	}
}
