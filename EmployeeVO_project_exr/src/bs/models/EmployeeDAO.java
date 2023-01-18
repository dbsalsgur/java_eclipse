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
		//레코드를 삽입하기 위한 쿼리 형태
		Connection con = null;
		PreparedStatement pstmt = null;
		//바인딩변수 '?'를 사용하기위해 PreparedStatement로 선언
		EmployeeVO retval = null;
		
		try {
			con = DBUtil.getConnection();
			//데이터베이스 연결
			pstmt = con.prepareStatement(dml);
			//연결한 데이터베이스에 입력할 문구 설정
			pstmt.setString(1, evo.getName());
			pstmt.setString(2, evo.getJobGrade());
			pstmt.setInt(3, evo.getDepartment());
			pstmt.setString(4, evo.getEmail());
			//이름, 직책, 부서번호, 이메일 각각 바인딩 변수에 설정
			
			int i = pstmt.executeUpdate();
			//INSERT쿼리 사용 시 쓰는 메소드
			//반영된 레코드 건수 리턴. create, drop에 대해선 -1 리턴
			retval = new EmployeeVO();
			retval.setStatus(i+"");
			//return value 변수를 객체화 하여 레코드 개수를 status에 담는다.
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
			//SELECT쿼리 사용시 쓰는 메소드
			if (rs.next()) {
				retval = new EmployeeVO(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getString(5));
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
		//사원정보조회 구현
		//사번, 이름을 통해 해당 레코드를 리턴하는 메소드
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
		//사원정보조회 구현
		//사번을 통해 해당 레코드를 리턴하는 메소드
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
		//사원정보조회 구현
		//이름을 통해 해당 레코드를 리턴하는 메소드
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
		//사원전체보기 기능 구현
		//arraylist에 다차원 배열로 레코드를 순차적으로 저장하여 해당내용 리턴
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
			//데이터베이스의 속성명 등을 저장하기 위해 ResultSetMetaData의 객체에 getMetaData()를 통해 입력
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
		//사원전체보기에서 속성명을 표기하기 위한 메소드
	}
}
