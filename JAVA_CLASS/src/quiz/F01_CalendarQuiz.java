package quiz;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.TimeZone;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class F01_CalendarQuiz {
	static final int perDay = 5;
	
	public static void main(String[] args) {
		// DB에 저장되어있는 차량정보를 조회하여 차량 5부제 적용.
		
		//DB에 저장되어있는 차량정보를 조회해서
		//오늘 출입 제한인 차량의 대수
		//오늘 출입 제한인 차량의 모든 정보를 출력하라.
		
		// 출입제한 끝번호 
		// 월 1 6
		// 화 2 7
		// 수 3 8 
		// 목 4 9
		// 금 5 0
		//공휴일 , 휴무일 제외

		TimeZone korea_tz = TimeZone.getTimeZone("Asia/Seoul");
		Calendar korea_time = Calendar.getInstance(korea_tz);
		int seoul_week = korea_time.get(Calendar.DAY_OF_WEEK);

		//오늘 요일 구하기.
		String day = getStrWeek(seoul_week);
		
		//출입제한 차량 끝번호
		int restrict  = chkregist(day);
		
		System.out.println("오늘 요일 > " + day);
		
		if(restrict < 0) {
			System.out.println("--------------차량 5부제가 실시되지 않는 날입니다--------------");
			System.exit(0);
		}
		
		System.out.printf("오늘 출입제한 차량 뒷번호  > %d , %d", restrict, restrict+perDay);
		HikariConfig config = new HikariConfig("src/jdbc/hikari.properties");
		HikariDataSource ds = new HikariDataSource(config);
		
		try {
			Connection conn = ds.getConnection();
	
			PreparedStatement pstmt = conn.prepareStatement("select carnum, cartype, usetype, (select count(substr(carnum, -1)) from car where substr(carnum, -1) in ( ? , ? )) as \"제한차량대수\" from car where substr(carnum, -1) not in ( ? , ?)");
			pstmt.setInt(1, restrict);
			pstmt.setInt(2, restrict+perDay);
			pstmt.setInt(3, restrict);
			pstmt.setInt(4, restrict+perDay);
			
			// 3-2. 준비된 구문을 실행한다. 쿼리가 SELECT문인 경우 결과를 Set으로 받아온다.
			ResultSet rs = pstmt.executeQuery();

			boolean chk = true;
			
			while(rs.next()) {
				if(chk) {
					System.out.printf("금일 제한 차량 총 대수 > %d\n\n", rs.getInt("제한차량대수"));	
					System.out.println("차량번호\t차량구분\t차량용도\t");
					chk = !chk ;
				}
				System.out.printf("%-15s\t%-15s\t%-15s\t\n", rs.getString("carnum"), rs.getString("cartype"), rs.getString("usetype"));
			}
			
			rs.close();
			pstmt.close();
			ds.close();
			conn.close();
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	public static int chkregist(String date) {
		switch (date) {
		case "월":
			return 1;
		case "화":
			return 2;
		case "수":
			return 3;
		case "목":
			return 4;
		case "금":
			return 5;
		default:
			return -1;
		}
	}
	
	public static String getStrWeek(int calendar_now) {
		
		switch (calendar_now) {
		case Calendar.MONDAY:
			return "월";
		case Calendar.TUESDAY:
			return "화";
		case Calendar.WEDNESDAY:
			return "수";
		case Calendar.THURSDAY:
			return "목";
		case Calendar.FRIDAY:
			return "금";
		case Calendar.SATURDAY:
			return "토";
		case Calendar.SUNDAY:
			return "일";
		default:
			return null;
		}
	}
}

