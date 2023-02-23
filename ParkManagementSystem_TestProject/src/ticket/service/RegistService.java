package ticket.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import ticket.dao.TicketDao;
import ticket.model.Ticket;

public class RegistService {

private TicketDao ticketDao = new TicketDao();
	
	public void regist(RegistRequest registReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			int ticketNo = Integer.parseInt(registReq.getTno());
			Ticket ticket = ticketDao.selectById(conn, ticketNo);
			if (ticket != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			ticketDao.insert(conn, new Ticket(
					Integer.parseInt(registReq.getTno()),
					registReq.getCarno(),
					registReq.getPhone(),
					registReq.getGrade(),
					registReq.getTstat(),
					new Date())
				);
			conn.commit();
		} catch(SQLException e) {
			jdbc.JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
