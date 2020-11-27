package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import jdbcQuiz.Car;

public class JdbcTransaction {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.115.175.144";
		String user = "hr";
		String password = "1234";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("jdbc driver 로딩 성공");
			System.out.println("오라클 연결 성공\n");
			
			//자동 커밋이 기본적으로 활성화 되어있으므로
			//트랜잭션 제어를 위해 자동 커밋을 비활성화 한다.
			conn.setAutoCommit(false);
	
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO car " 
					+ "VALUES (car_seq.nextval, ?, ?, ?)");

	
				ResultSet rs = pstmt.executeQuery();
	
		}catch (ClassNotFoundException e) {
			System.err.println("해당하는 클래스가 없습니다.");
			e.printStackTrace();
		}catch (SQLException e) {
			System.err.println("jdbc driver 로딩 실패");
			e.printStackTrace();
		}
	}
}
