package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoDao;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class OutputService {

private InfoDao infoDao = new InfoDao();
	
	public void output(OutputRequest outputReq) {
		Connection conn = null;
		try {
			conn = ConnectionProvider.getConnection();
			conn.setAutoCommit(false);
			String carNo = outputReq.getCarNo();
			infoDao.update(conn, carNo);
			conn.commit();
		} catch(SQLException e) {
			jdbc.JdbcUtil.rollback(conn);
			throw new RuntimeException();
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
