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
import ticket.model.Ticket;

public class InfoDao {
	
	public Ticket selectByCarNo(Connection conn, String carNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from ticket_tbl_01 where carno = ?");
			pstmt.setString(1, carNo);
			rs = pstmt.executeQuery();
			Ticket ticket = null;
			if (rs.next()) {
				ticket = new Ticket(
						rs.getInt("tno"),
						rs.getString("carno"),
						rs.getString("phone"),
						rs.getString("grade"),
						rs.getString("tstat"),
						toDate(rs.getTimestamp("startdate")),
						toDate(rs.getTimestamp("enddate")));
			}
			return ticket;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}

	public Info selectById(Connection conn, Info info) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from park_info_tbl where parkno = ?");
			pstmt.setInt(1, info.getParkNo());
			rs = pstmt.executeQuery();
			if (rs.next()) {
				info = new Info(
						rs.getInt("parkno"),
						rs.getString("carno"),
						rs.getString("grade"),
						rs.getString("tstat"),
						toDate(rs.getTimestamp("indate")),
						toDate(rs.getTimestamp("outdate")));
			}
			return info;
		} catch(NullPointerException e) {
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
//		Timestamp ts = new Timestamp(info.getInDate().getTime());
//		Calendar cal = Calendar.getInstance();
//		cal.setTime(ts);
//		try {
//			if (info.getGrade().equals("Y")) {
//				cal.add(Calendar.DAY_OF_YEAR, 365);
//			} else if(info.getGrade().equals("M")){
//				cal.add(Calendar.DAY_OF_MONTH, 30);
//			} else {
//				throw new SQLException();
//			}
//		} catch(Exception e) {
//			e.printStackTrace();
//		}
//		ts.setTime(cal.getTime().getTime()); 
//		ts = new Timestamp(cal.getTime().getTime());
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into park_info_tbl values (?,?,?,?,?,?)")) {
			pstmt.setInt(1, info.getParkNo());
			pstmt.setString(2, info.getCarNo());
			pstmt.setString(3, info.getGrade());
			pstmt.setString(4, info.getTstat());
			pstmt.setTimestamp(5, new Timestamp(info.getInDate().getTime()));
			pstmt.setTimestamp(6, new Timestamp(info.getOutDate().getTime()));
			pstmt.executeUpdate();
		}
		
	}
}
