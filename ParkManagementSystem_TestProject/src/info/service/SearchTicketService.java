package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoDao;
import jdbc.connection.ConnectionProvider;
import ticket.model.Ticket;

public class SearchTicketService {

	private InfoDao infoDao = new InfoDao();
	
	public Ticket searchTicket(SearchRequest searchReq) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			
			return infoDao.selectByCarNo(conn, searchReq.getcarNo());
		} catch(SQLException e) {
			throw new RuntimeException();
		} 
	}
}
