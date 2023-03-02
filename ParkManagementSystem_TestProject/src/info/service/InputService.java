package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import info.dao.InfoDao;
import info.model.Info;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import ticket.service.DuplicateIdException;

public class InputService {

	private InfoDao infoDao = new InfoDao();
	
	public void input(InputRequest inputReq) throws ParseException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
			String carNo = inputReq.getCarNo();
			Info infoValue = infoDao.selectByCarNum(conn, carNo);
			if (infoValue != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			infoDao.insert(conn, new Info(
					inputReq.getCarNo(),
					inputReq.getGrade(),
					"I",
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
