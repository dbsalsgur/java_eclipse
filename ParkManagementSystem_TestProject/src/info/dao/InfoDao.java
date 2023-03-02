package info.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Date;

import info.model.Info;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
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

	public Info selectByCarNum(Connection conn, String carNo) throws SQLException {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Info info = null;
		try {
			pstmt = conn.prepareStatement("select * from park_info_tbl where carno = ?");
			pstmt.setString(1, carNo);
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
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	public void update(Connection conn, String carNo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			pstmt = conn.prepareStatement("update park_info_tbl set tstat='O', outdate=now() where carno = ?");
			pstmt.setString(1, carNo);
			pstmt.executeUpdate();
			System.out.println(6);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
	}
	
	private Date toDate(Timestamp date) {
		return date == null ? null : new Date(date.getTime());
	}
	
	public void insert(Connection conn, Info info) throws SQLException {
		
		try(PreparedStatement pstmt = conn.prepareStatement("insert into park_info_tbl(parkno, carno, grade, tstat, indate) values (0,?,?,?,?)")) {
			pstmt.setString(1, info.getCarNo());
			pstmt.setString(2, info.getGrade());
			pstmt.setString(3, info.getTstat());
			pstmt.setTimestamp(4, new Timestamp(info.getInDate().getTime()));
			pstmt.executeUpdate();
		}
		
	}
}
