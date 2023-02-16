package guestbook.service;

import java.sql.Connection;
import java.sql.SQLException;

import guestbook.dao.MessageDao;
import guestbook.model.Message;
import jdbc.JdbcUtil;
import jdbc.connection.ConnectionProvider;

public class DeleteMessageService {
	
	private static DeleteMessageService instance = new DeleteMessageService();
	
	public static DeleteMessageService getInstance() {
		return instance;
	}
	
	private DeleteMessageService() {}
	
	public void deleteMessage(int messageId, String password) {
		Connection conn = null;
		try {
			//커넥션 풀에 접속
			conn = ConnectionProvider.getConnection();
			//오류가 발생하면 rollback을 하고, try문 안에 있는 것이 정상적으로 수행되면 커밋이 되도록한다.
			conn.setAutoCommit(false);
			
			MessageDao messageDao = MessageDao.getInstance();
			Message message = messageDao.select(conn, messageId);
			if (message == null) {
				throw new MessageNotFoundException("메세지 없음");
			}
			if (!message.matchPassword(password)) {
				throw new InvalidPasswordException("bad password");
			}
			messageDao.delete(conn, messageId);
			conn.commit();
		} catch (SQLException e) {
			JdbcUtil.rollback(conn);
			throw new ServiceException("삭제 실패 : "+e.getMessage(), e);
		} catch (InvalidPasswordException | MessageNotFoundException ex) {
			JdbcUtil.rollback(conn);;
			throw ex;
		} finally {
			JdbcUtil.close(conn);
		}
	}
}
