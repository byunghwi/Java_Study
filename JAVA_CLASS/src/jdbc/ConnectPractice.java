package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ConnectPractice {
	// 사용자로부터  부서번호를 입력받으면 해당 부서의 모든 사원들의 정보를 조회해서 콘솔에 출력하라.
 	public static void main(String[] args) {
 		
 		Scanner sc = new Scanner(System.in);
 		
 		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521/orcl.115.175.144";
		String user = "hr";
		String password = "1234";
		
		try {
			Class.forName(driver);
			Connection conn = DriverManager.getConnection(url, user, password);
			
			System.out.println("jdbc driver 로딩 성공");
			System.out.println("오라클 연결 성공\n");
			
			System.out.print("부서번호를 입력하세요 > ");
			int userInput = sc.nextInt();
			
			PreparedStatement pstmt = conn.prepareStatement("SELECT * FROM employees" 
														+ " WHERE department_id = ? order by employee_id" );
			pstmt.setInt(1, userInput);
			System.out.println("\temployee_id\tfirst_name\tlast_name\tmanager_id\tsalary\tcommission_pct\tdepartment_id");
			
			ResultSet rs = pstmt.executeQuery();
			int i = 1;
			while (rs.next()) {
				System.out.printf("%-8d\t%-8d\t%-13s\t%-13s\t%-13d\t%-13d\t%-13d\t%-13d\n",
																i++,
																rs.getInt("employee_id"),
																rs.getString("first_name"),
																rs.getString("last_name"),
																rs.getInt("manager_id"),
																rs.getInt("salary"),
																rs.getInt("commission_pct"),
																rs.getInt("department_id"));

			}
			System.out.println();
					
		}catch (ClassNotFoundException e) {
			System.err.println("해당하는 클래스가 없습니다.");
			e.printStackTrace();
		}catch (SQLException e) {
			System.err.println("jdbc driver 로딩 실패");
			e.printStackTrace();
		}
		
	
	}
}
