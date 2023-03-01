package ticket.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import ticket.dao.TicketDao;
import ticket.model.Ticket;

public class RegistService {

private TicketDao ticketDao = new TicketDao();
	
	public void regist(RegistRequest registReq) throws ParseException {
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
					dateFormat(registReq.getStartDate()),
					dateFormat(registReq.getEndDate()))
				);
			conn.commit();
		} catch(SQLException e) {
			jdbc.JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}
	
	public Date dateFormat(String inputDate) throws ParseException {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.KOREA);
		Date date = formatter.parse(inputDate);
		return date;
	}
}
