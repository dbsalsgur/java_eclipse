package jdbc;

import java.sql.DriverManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.ConnectionFactory;
import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet {
	
	@Override
	public void init() throws ServletException {
		loadJDBCDriver();
		initConnectionPool();
	}
	
	//jdbc드라이버 접속
	private void loadJDBCDriver() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("fail to load JDBC Driver", e);
		}
	}
	
	//커넥션 풀 초기화
	private void initConnectionPool() {
		try {
			String jdbcUrl = "jdbc:mysql://localhost:3306/chap14";
			String username = "root";
			String pw = "";
			
			//커넥션 풀이 새로운 커넥션을 생성할 때 사용할 커넥션 팩토리 생성
			//커넥션 팩토리의 계정정보로 url과 id, password를 생성자로 지정한다.
			ConnectionFactory connFactory = new DriverManagerConnectionFactory(jdbcUrl, username, pw);
			PoolableConnectionFactory poolableConnFactory = new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("select 1"); //insert, delete같은 쿼리는 데이터가 변하기 때문에 select로 유효성 검증
			
			//커넥션 풀의 설정 정보 생성.
			GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
			poolConfig.setTimeBetweenEvictionRunsMillis(1000L * 60L * 5L); //커넥션 검사 주기
			poolConfig.setTestWhileIdle(true);	//풀에 보관 중인 커넥션의 유효성을 검사할지 여부
			poolConfig.setMinIdle(4);	//커넥션 최소개수
			poolConfig.setMaxTotal(50);	//커넥션 최대개수
			
			
			//커넥션 풀 생성
			GenericObjectPool<PoolableConnection> connectionPool = new GenericObjectPool<>(poolableConnFactory, poolConfig);
			poolableConnFactory.setPool(connectionPool); //커넥션 풀 연결
			
			//커넥션 풀 등록. 커넥션풀에 맞는 JDBC 드라이버를 등록해야한다.
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = (PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("chap14", connectionPool); //커넥션 풀 이름에 연동할 데이터베이스 이름을 적어야 해당 데이터베이스와 연결된다.
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
