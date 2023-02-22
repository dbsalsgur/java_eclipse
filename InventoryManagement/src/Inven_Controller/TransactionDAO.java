package Inven_Controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import Inven_Model.ClientVO;
import Inven_Model.ProductVO;
import Inven_Model.TransactionVO;
import Inven_Util.DBUtil;

public class TransactionDAO {
	// 데이터 입력
	public TransactionVO getTransactionExecute(TransactionVO tl) throws Exception {
		String dml = "insert into transaction values (null,?,?,?,?,?,?,?)";
		
		String qml="UPDATE product SET proquan = proquan - ? WHERE (procode = ?)";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		PreparedStatement uppstmt= null;
		
			
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			
			uppstmt=con.prepareStatement(qml);
			
			pstmt.setInt(1, tl.getTransdate());// 거래일자
			pstmt.setString(2, tl.getTransname());// 상품명
			pstmt.setInt(3, tl.getQuantity());// 상품수량
			pstmt.setInt(4, tl.getTransprice());// 단가
			pstmt.setInt(5, tl.getQuantity() * tl.getTransprice());// 총가격
			pstmt.setString(6, tl.getClient());// 거래처
			pstmt.setString(7,tl.getProno());//제품코드
			pstmt.executeUpdate();
			
			int suryang= tl.getQuantity();
			String prono=tl.getProno();
			uppstmt.setInt(1, suryang);
			uppstmt.setString(2, prono);
			uppstmt.executeUpdate();
			
			
		} catch (SQLException se) {
			System.out.println("dao33");
		} catch (Exception e) {
			System.out.println("dao35");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
				System.out.println("dao 43");
			}

		}
		return null;

	}
//입고반영 쿼리
	//select quantity from product where procode=?
	//
	public ProductVO getAutoProname(String selectedItem) throws Exception {// 자동값 불러오기
		ArrayList<String> list = new ArrayList<String>();
		String sml = "select proname, protype , proprice from product where procode = ? ";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet sr = null;
		ProductVO pi = new ProductVO();

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sml);
			pstmt.setString(1, selectedItem);
			sr = pstmt.executeQuery();
			while (sr.next()) {
				pi.setProname(sr.getString(1));
				pi.setProtype(sr.getString(2));
				pi.setProprice(sr.getInt(3));
			}
		} catch (Exception e) {
		}
		return pi;
	}

	public ArrayList<String> getClient() throws Exception {// 거래처 콤보박스내용
		ArrayList<String> list = new ArrayList<String>();
		String sml = "select comname from client";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet sr = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sml);
			sr = pstmt.executeQuery();
			while (sr.next()) {
				String str;
				ClientVO ci = new ClientVO();

				ci.setComname(sr.getString(1));
				str = ci.getComname();

				list.add(str);

			}

		} catch (Exception e) {
		}
		return list;
	}

	public ArrayList<String> getProcode() throws Exception {// 제품코드 콤보박스 내용
		ArrayList<String> list = new ArrayList<String>();
		String qml = "select procode from product";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet sr = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(qml);
			sr = pstmt.executeQuery();

			while (sr.next()) {
				String str;
				ProductVO pi = new ProductVO();

				pi.setProcode(sr.getString(1));
				str = pi.getProcode();

				list.add(str);

			}

		} catch (Exception e) {
			System.out.println("hi");
		} finally {
			try {
				if (sr != null)
					sr.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException se) {
				System.out.println("dao85");
			}
		}
		return list;
	}

//전체조회
	public ArrayList<TransactionVO> getTransactionTotal() {
		ArrayList<TransactionVO> list = new ArrayList<TransactionVO>();
		String tml = "select * from transaction";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		TransactionVO tl = null;

		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				tl = new TransactionVO(rs.getInt(1), rs.getInt(2), rs.getString(3), rs.getInt(4), rs.getInt(5),
						rs.getInt(6), rs.getString(7), rs.getString(8));

				list.add(tl);
			}
		} catch (SQLException se) {
			System.out.println("dao72");
		} catch (Exception e) {
			System.out.println("dao74");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();

			} catch (SQLException se) {
				System.out.println("dao85");
			}
		}
		return list;
	}

//전체조회 탭에서 속성명 불러오기
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName = new ArrayList<String>();

		String sql = "select * from transaction";

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
			System.out.println("dao114");
		} catch (Exception e) {
			System.out.println("dao227");
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
				System.out.println("dao127");
			}
		}
		return columnName;
	}
}