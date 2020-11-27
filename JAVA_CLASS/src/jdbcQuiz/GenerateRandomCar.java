package jdbcQuiz;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Map;

public class GenerateRandomCar {
	// 랜덤 값을 가진 자동차들이 100대 생성되어 DB에 저장되는 프로그램을 만들어 보세요.
	// 차량번호판 - 사이트참조
	// 번호를 랜덤 생성한 뒤에 번호에 따라 결정되는 것들 적용 (차종)
	// 차량객체 생성 후 DB에 알맞게 저장.
	
	// Java코드와 DB스크린샷 전송할 것.
	
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
			
			Car car = new Car();
			car.createRanNumber();
			
			PreparedStatement pstmt = conn.prepareStatement("INSERT INTO car " 
					+ "VALUES (car_seq.nextval, ?, ?, ?)");

			for(Map.Entry<String, String> entry: car.carGroup.entrySet()) {
				
				String types[] = entry.getValue().split("/");
	
				pstmt.setString(1, entry.getKey());
				pstmt.setString(2, types[0]);
				pstmt.setString(3, types[1]);
				
				System.out.println(entry.getKey() + " : " + types[0] + ", " + types[1]);

				ResultSet rs = pstmt.executeQuery();
			}		
		}catch (ClassNotFoundException e) {
			System.err.println("해당하는 클래스가 없습니다.");
			e.printStackTrace();
		}catch (SQLException e) {
			System.err.println("jdbc driver 로딩 실패");
			e.printStackTrace();
		}

	}
}
