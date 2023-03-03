package ticket.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import ticket.model.Ticket;

public class TicketDao {
	
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
	
	public List<Ticket> select() throws SQLException {
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		try {
			conn = ConnectionProvider.getConnection();
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from ticket_tbl_01");
			java.util.List<Ticket> records = new ArrayList<>();
			while (rs.next()) {
				records.add(listingRecord(rs));
			}
			return records;
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
			JdbcUtil.close(conn);
		}
	}
	
	private Ticket listingRecord(ResultSet rs) throws SQLException {
		Ticket record = new Ticket(
				rs.getInt("tno"),
				rs.getString("carno"),
				rs.getString("phone"),
				rs.getString("grade"),
				rs.getString("tstat"),
				toDate(rs.getTimestamp("startdate")),
				toDate(rs.getTimestamp("enddate")));
		return record; 
	}
	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
	public void insert(Connection conn, Ticket tic) throws SQLException {
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into ticket_tbl_01 values (?,?,?,?,?,?,?)")) {
			pstmt.setInt(1, tic.getTno());
			pstmt.setString(2, tic.getCarno());
			pstmt.setString(3, tic.getPhone());
			pstmt.setString(4, tic.getGrade());
			pstmt.setString(5, tic.getTstat());
			pstmt.setTimestamp(6, new Timestamp(tic.getStartDate().getTime()));
			pstmt.setTimestamp(7, new Timestamp(tic.getEndDate().getTime()));
			pstmt.executeUpdate();
		}
		
	}
}
