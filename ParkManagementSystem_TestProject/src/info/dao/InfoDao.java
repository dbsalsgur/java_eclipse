package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import info.model.Info;
import jdbc.JdbcUtil;

public class InfoDao {

	public Info selectById(Connection conn, int parkNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from park_info_tbl where parkno = ?");
			pstmt.setInt(1, parkNo);
			rs = pstmt.executeQuery();
			Info info = null;
			if (rs.next()) {
				info = new Info(
						rs.getInt("tno"),
						rs.getString("carno"),
						rs.getString("grade"),
						rs.getString("tstat"),
						toDate(rs.getTimestamp("startdate")),
						toDate(rs.getTimestamp("enddate")));
			}
			return info;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
	public void insert(Connection conn, Info info) throws SQLException {
		Timestamp ts = new Timestamp(info.getInDate().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		try {
			if (info.getGrade().equals("Y")) {
				cal.add(Calendar.DAY_OF_YEAR, 365);
			} else if(info.getGrade().equals("M")){
				cal.add(Calendar.DAY_OF_MONTH, 30);
			} else {
				throw new SQLException();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		ts.setTime(cal.getTime().getTime()); 
		ts = new Timestamp(cal.getTime().getTime());
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into park_info_tbl values (?,?,?,?,?,?,?)")) {
			pstmt.setInt(1, info.getParkNo());
			pstmt.setString(2, info.getCarNo());
			pstmt.setString(3, info.getGrade());
			pstmt.setString(4, info.getTstat());
			pstmt.setTimestamp(5, new Timestamp(info.getInDate().getTime()));
			pstmt.setTimestamp(6, ts);
			pstmt.executeUpdate();
		}
		
	}
}
