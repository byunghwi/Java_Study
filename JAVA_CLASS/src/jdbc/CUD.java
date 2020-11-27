package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CUD {
	public static void main(String[] args) {
 		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.115.175.144";
		String user = "hr";
		String password = "1234";
		String sql = "INSERT INTO coffee VALUES (coffee_seq.nextval, ?, ?)";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			System.out.println("jdbc driver 로딩 성공");
			System.out.println("오라클 연결 성공\n");
			
			//System.out.print("부서번호를 입력하세요 > ");
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, "카페라떼");
			pstmt.setInt(2, 3200);
			
			//# pstmt.executeQuery()
			// - ResultSet이 반환될 법한 쿼리 (SELECT) 를 실행시킬때 사용한다.
			
			
			// # pstmt.executeUpdate()
			// - DML 인 INSERT, UPDATE, DELETE 또는 반환되는 값이 없는
			// - DDL 같은 쿼리문을 실행시킬 때 사용한다.
			int row = pstmt.executeUpdate();
			System.out.printf("%d행이 변경되었습니다.\n", row);
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

	}
}
