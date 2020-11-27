import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

public class F01_Calendar {
	public static void main(String[] args) {
		System.out.println(System.currentTimeMillis());
		Date now = new Date();
		System.out.println(now);
		
		// 달력을 표현한 클래스
		// 생성자 대신 getInstance() 함수를 통해 인스턴스를 받아옴
		Calendar now2 = Calendar.getInstance();
		
		// # timeZone 클래스
		// - 경도를 설정할 수 있는 클래스
		for (String zone_id : TimeZone.getAvailableIDs()) {
			System.out.println(zone_id);
		}
		
		System.out.println(now2);
		
		
		TimeZone zone1 = TimeZone.getTimeZone("US/Samoa");
		
		//Korea_time도 samoa_time처럼 출력하라.
		TimeZone korea_tz = TimeZone.getTimeZone("Asia/Seoul");
		
		Calendar korea_time = Calendar.getInstance(korea_tz);
		Calendar samoa_time = Calendar.getInstance(zone1);
		
		int samoa_year = samoa_time.get(Calendar.YEAR);
		//Calendar는 Month만 1월이 0이다.
		int samoa_mon = samoa_time.get(Calendar.MONTH)+1;
		int samoa_day = samoa_time.get(Calendar.DATE);
		//Hour 12시, HOUR_OF_DAY 24시
		int samoa_hour = samoa_time.get(Calendar.HOUR);
		int samoa_min = samoa_time.get(Calendar.MINUTE);
		int samoa_sec = samoa_time.get(Calendar.SECOND);
		
		int samoa_week = samoa_time.get(Calendar.DAY_OF_WEEK);
		
		
		int seoul_week = korea_time.get(Calendar.DAY_OF_WEEK);
		
		int seoul_year = korea_time.get(Calendar.YEAR);
		int seoul_mon = korea_time.get(Calendar.MONTH)+1;
		int seoul_day = korea_time.get(Calendar.DATE);
		
		int seoul_hour = korea_time.get(Calendar.HOUR);
		int seoul_min = korea_time.get(Calendar.MINUTE);
		int seoul_sec = korea_time.get(Calendar.SECOND);
		
		
		System.out.printf("samoa time - %d/%02d/%02d %d:%d:%d %s \n",samoa_year,  samoa_mon, samoa_day, samoa_hour, samoa_min, samoa_sec, getStrWeek(samoa_week));
		System.out.printf("seoul time - %d/%02d/%02d %d:%d:%d %s \n",seoul_year,  seoul_mon, seoul_day, seoul_hour, seoul_min, seoul_sec, getStrWeek(seoul_week));
		
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
