package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {
	final static String driver = "oracle.jdbc.driver.OracleDriver";
	final static String url = "jdbc:oracle:thin:@localhost:1521/orcl.115.175.144";
	final static String user = "hr";
	final static String password = "1234";
	
	static {
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	//리스트에 커넥션을 미리 생성해두고, 사용중이지 않은 커넥션을 꺼내주기
	List<JdbcConnection> pool;
	
	public ConnectionPool(int size) {
		pool = new ArrayList<>(size);
		
		for (int i = 0; i < size; i++) {
			pool.add(new JdbcConnection());
		}
	}
	
	public JdbcConnection getConnection() {
		for (JdbcConnection jconn : pool) {
			if(!jconn.using) {
				jconn.using = true;
				return jconn;
			}
		}
		System.out.println("전부 사용 중입니다.");
		return null;
	}
	
	class JdbcConnection{
		Connection conn;
		boolean using = false;
		
		public JdbcConnection() {
			try {
				conn = DriverManager.getConnection(url, user, password);
				using = true;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		public void close() {
			using = false;
		}
	}
	
	public static void main(String[] args) {
		ConnectionPool src = new ConnectionPool(3);
		
		JdbcConnection conn1 = src.getConnection();
		System.out.println("conn1 addr : "+ conn1);
		
		
		JdbcConnection conn2 = src.getConnection();
		System.out.println("conn2 addr : "+ conn2);
		
		JdbcConnection conn3 = src.getConnection();
		System.out.println("conn3 addr : "+ conn3);
	
		JdbcConnection conn4 = src.getConnection();
		System.out.println("conn4 addr : "+ conn4);
		//close를 하면 Connection을 끊는 대신 사용 중이지 않는 상태로 변경한다.
		conn1.close();
	}
}
