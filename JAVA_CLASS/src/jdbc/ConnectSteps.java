package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class ConnectSteps {
	public static void main(String[] args) {
		
		// # 어떤 DataBase를 사용하더라도 밟게되는 똑같은 절차들
		
		// 1. Class.forName(driverName) 으로 해당 DB사의 jdbc 드라이버를 로드한다.
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("[ojdbc] 성공적으로 로드 되었습니다.");
		} catch (ClassNotFoundException e) {
			System.out.println("[ojdbc] 클래스 경로가 틀렸습니다.");
			e.printStackTrace();
		}
		
		// 2. DriverManager 클래스를 통해 DB와의 연결 수립
		// - DriverManager.getConnection() 메서드에 
		// DB접속 주소와 아이디/패스워드를 전달하면 연결이 반환된다.
		try {
			Connection conn = 
			DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521/orcl.115.175.144", "hr", "1234");
			
			System.out.println("연결 성공");
			
			//3. 반환된 연결에 사용할 쿼리문을 준비(; 를 사용하지 않는다.)
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees "
										+ "WHERE department_id in(?,?,?,?) AND "
										+ "last_name LIKE ? order by department_id");
			// 3-1. 준비할 구문에  물음표가 있다면 setType을 통해 값을 채워야한다.
			pstmt.setInt(1, 10);
			pstmt.setInt(2, 20);
			pstmt.setInt(3, 30);
			pstmt.setInt(4, 50);	
			pstmt.setString(5, "%a%");
 
			System.out.println("LAST_NAME\tFIRST_NAME\tSALARY\tDEPARTMENT_ID");
			
			// 3-2. 준비된 구문을 실행한다. 쿼리가 SELECT문인 경우 결과를 Set으로 받아온다.
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				
				System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\n",
				rs.getString("last_name"),
				rs.getString("first_name"),
				rs.getInt("salary"),
				rs.getInt("department_id"));
				
			}
		} catch (SQLException e) {
			System.out.println("연결 실패");
			e.printStackTrace();
		}
		
	}
}
