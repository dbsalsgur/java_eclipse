package bs.models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

import bs.DBUtil.DBUtil;

public class EmployeeDAO {
	public EmployeeVO getEmployeeregiste(EmployeeVO evo) throws Exception {
		String dml = "insert into employee" + " (name,jobGrade,department,email)" + "values " + " (?,	?,	?,	?)";
		//���ڵ带 �����ϱ� ���� ���� ����
		Connection con = null;
		PreparedStatement pstmt = null;
		//���ε����� '?'�� ����ϱ����� PreparedStatement�� ����
		EmployeeVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			//�����ͺ��̽� ����
			pstmt = con.prepareStatement(dml);
			//������ �����ͺ��̽��� �Է��� ���� ����
			pstmt.setString(1, evo.getName());
			pstmt.setString(2, evo.getJobGrade());
			pstmt.setInt(3, evo.getDepartment());
			pstmt.setString(4, evo.getEmail());
			//�̸�, ��å, �μ���ȣ, �̸��� ���� ���ε� ������ ����
			
			int i = pstmt.executeUpdate();
			//INSERT���� ��� �� ���� �޼ҵ�
			//�ݿ��� ���ڵ� �Ǽ� ����. create, drop�� ���ؼ� -1 ����
			retval = new EmployeeVO();
			retval.setStatus(i+"");
			//return value ������ ��üȭ �Ͽ� ���ڵ� ������ status�� ��´�.
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
		//SQLException�� ���� ĳġ, SQL�� ���þ��� ���ܵ� ĳġ�ϱ� ���� Exception�� ��ġ
		//Ŭ������ ������ ������ ��������, pstmt�� ��� ������ null�� ����ش�.
		return retval;
	}
	
	public EmployeeVO getEmployeeCheck(int no, String name) throws Exception {
		String dml = "select * from employee where no = ? and name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			//SELECT���� ���� ���� �޼ҵ�
			if (rs.next()) {
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
			}
			//ResultSet�� �̿��� �����ͺ��̽��� ����� ���� ��ȯ.
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
		//���������ȸ ����
		//���, �̸��� ���� �ش� ���ڵ带 �����ϴ� �޼ҵ�
	}
	
	public EmployeeVO getEmployeeNo(int no) throws Exception {
		String dml = "select * from employee where no = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setInt(1, no);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
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
		//���������ȸ ����
		//����� ���� �ش� ���ڵ带 �����ϴ� �޼ҵ�
	}
	
	public EmployeeVO getEmployeeName(String name) throws Exception {
		String dml = "select * from employee where name = ?";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(dml);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
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
		//���������ȸ ����
		//�̸��� ���� �ش� ���ڵ带 �����ϴ� �޼ҵ�
	}
	
	public ArrayList<EmployeeVO> getEmployeetotal() {
		ArrayList<EmployeeVO> list = new ArrayList<EmployeeVO>();
		String tml = "select * from employee";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmployeeVO emVo = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(tml);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				emVo = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
				list.add(emVo);
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
		//�����ü���� ��� ����
		//arraylist�� ������ �迭�� ���ڵ带 ���������� �����Ͽ� �ش系�� ����
	}
	
	public ArrayList<String> getColumnName() {
		ArrayList<String> columnName= new ArrayList<String>();
		String sql = "select * from employee";
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		
		try {
			con = DBUtil.getConnection();
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			//�����ͺ��̽��� �Ӽ��� ���� �����ϱ� ���� ResultSetMetaData�� ��ü�� getMetaData()�� ���� �Է�
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
		//�����ü���⿡�� �Ӽ����� ǥ���ϱ� ���� �޼ҵ�
	}
}
