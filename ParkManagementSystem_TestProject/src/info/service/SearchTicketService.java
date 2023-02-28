package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import ticket.model.Ticket;

public class SearchTicketService {

	private InfoDao infoDao = new InfoDao();
	
	public void searchTicket(SearchTicketRequest searchTicReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			Ticket tic = infoDao.selectByCarNo(conn, searchTicReq.getcarNo());
		} catch(SQLException e) {
			jdbc.JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
