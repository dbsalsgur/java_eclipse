package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import info.dao.InfoDao;
import info.model.Info;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;
import ticket.service.DuplicateIdException;

public class InputService {

	private InfoDao infoDao = new InfoDao();
	
	public void input(InputRequest inputReq) throws ParseException {
		Connection conn = null;
		Info info = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			
//			int parkNo = Integer.parseInt(inputReq.getParkNo());
			Info infoValue = infoDao.selectById(conn, info);
			if (infoValue != null) {
				JdbcUtil.rollback(conn);
				throw new DuplicateIdException();
			}
			infoDao.insert(conn, new Info(
					Integer.parseInt(inputReq.getParkNo()),
					inputReq.getCarNo(),
					inputReq.getGrade(),
					inputReq.getTstat(),
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
