package ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Calendar;
import java.util.Date;

import jdbc.JdbcUtil;
import ticket.model.Ticket;

public class TicketDao {
	
	private static TicketDao instance = new TicketDao();
	
	public static TicketDao getInstance() {
		return instance;
	}

	public Ticket selectById(Connection conn, int tno) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("select * from ticket_tbl_01 where tno = ?");
			pstmt.setInt(1, tno);
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
	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
	public void insert(Connection conn, Ticket tic) throws SQLException {
		Timestamp ts = new Timestamp(tic.getStartDate().getTime());
		Calendar cal = Calendar.getInstance();
		cal.setTime(ts);
		try {
			if (tic.getGrade().equals("Y")) {
				cal.add(Calendar.DAY_OF_YEAR, 365);
			} else if(tic.getGrade().equals("M")){
				cal.add(Calendar.DAY_OF_MONTH, 30);
			} else {
				throw new SQLException();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		ts.setTime(cal.getTime().getTime()); 
		ts = new Timestamp(cal.getTime().getTime());
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into ticket_tbl_01 values (?,?,?,?,?,?,?)")) {
			pstmt.setInt(1, tic.getTno());
			pstmt.setString(2, tic.getCarno());
			pstmt.setString(3, tic.getPhone());
			pstmt.setString(4, tic.getGrade());
			pstmt.setString(5, tic.getTstat());
			pstmt.setTimestamp(6, new Timestamp(tic.getStartDate().getTime()));
			pstmt.setTimestamp(7, ts);
			pstmt.executeUpdate();
		}
		
	}
}
