package info.service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import info.dao.InfoDao;
import info.model.Info;
import jdbc.connection.ConnectionProvider;

public class ReadParkInfoService {

	private InfoDao infoDao = new InfoDao();
	
	public List<Info> getDateList() {
		try (Connection conn = ConnectionProvider.getConnection()) {
			List<Info> dataList = infoDao.select();
			return dataList;
		} catch(SQLException e) {
			throw new RuntimeException();
		} 
	}
}
