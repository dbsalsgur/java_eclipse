package ticket.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import jdbc.connection.ConnectionProvider;
import ticket.dao.TicketDao;
import ticket.model.Ticket;

public class ReadTicketService {

	private TicketDao ticketDao = new TicketDao();
	
	public List<Ticket> getDateList() {
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Ticket> dataList = ticketDao.select();
			return dataList;
		} catch(SQLException e) {
			throw new RuntimeException();
		} 
	}
}
