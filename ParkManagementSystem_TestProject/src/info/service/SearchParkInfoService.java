package info.service;

import java.sql.Connection;
import java.sql.SQLException;

import info.dao.InfoDao;
import info.model.Info;
import jdbc.connection.ConnectionProvider;

public class SearchParkInfoService {

	private InfoDao infoDao = new InfoDao();
	
	public Info searchParkInfo(SearchRequest searchReq) {
		try(Connection conn = ConnectionProvider.getConnection()) {
			return infoDao.selectByCarNum(conn, searchReq.getcarNo());
		} catch(SQLException e) {
			throw new RuntimeException();
		} 
	}
}
