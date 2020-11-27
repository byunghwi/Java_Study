package jdbc;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class HikariCpTest {
	public static void main(String[] args) {		
		
//		1.		
//		HikariDataSource ds = new HikariDataSource();
//		ds.setDriverClassName("oracle.jdbc.pool.OracleDataSource");
//		ds.setJdbcUrl("jdbc:oracle:thin:@localhost:1521/orcl.115.175.144");		
//		ds.setUsername("hr");
//		ds.setPassword("1234");	

//		2.
		HikariConfig config = new HikariConfig("src/jdbc/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
//		3.		
//		Properties props = new Properties();
//		props.setProperty("dataSourceClassName", "oracle.jdbc.pool.OracleDataSource");
//		props.setProperty("dataSource.url", "jdbc:oracle:thin:@localhost:1521/orcl.115.175.144");
//		props.setProperty("dataSource.user", "hr");
//		props.setProperty("dataSource.password", "1234");
//		props.setProperty("dataSource.databaseName", "hr_db");
//		props.put("dataSource.logWriter", new PrintWriter(System.out));
//
//		HikariConfig config = new HikariConfig(props);
//		HikariDataSource ds = new HikariDataSource(config);

		try {
			Connection conn = ds.getConnection();
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees "
										+ "order by department_id");

			// 3-2. 준비된 구문을 실행한다. 쿼리가 SELECT문인 경우 결과를 Set으로 받아온다.
			ResultSet rs = pstmt.executeQuery();

			System.out.println("last_name\tfirst_name\tmanager_id\tsalary\tdepartment_id\n");
			while (rs.next()) {
				
				System.out.printf("%-15s\t%-10s\t%-10d\t%-10d\t%-10d\n",
				rs.getString("last_name"),
				rs.getString("first_name"),
				rs.getInt("manager_id"),
				rs.getInt("salary"),
				rs.getInt("department_id"));
				
			}
			
			rs.close();
			pstmt.close();
			ds.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
}
