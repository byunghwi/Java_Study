package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

public class ResultSetMetaDataTest {
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

			String sql = "SELECT * FROM employees";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			ResultSetMetaData rsmd = rs.getMetaData();

			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.println(rsmd.getColumnName(i));
			}
			
			if (pstmt != null) pstmt.close();
			if (conn != null) conn.close();
			
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
