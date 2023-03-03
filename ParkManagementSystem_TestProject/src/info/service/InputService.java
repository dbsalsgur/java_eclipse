package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;

import info.dao.InfoDao;
import info.model.Info;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class InputService {

	private InfoDao infoDao = new InfoDao();
	
	public void input(InputRequest inputReq) throws ParseException {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
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
