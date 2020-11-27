import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class F02_SimpleDateFormat {

	public static void main(String[] args) {
		// 날짜/시간을 문자열로 변환하는 방법
		SimpleDateFormat simple = new SimpleDateFormat("YYYY년 MM월  dd일");
		
		Date now = new Date();
		
		//Calendar의 인스턴스는 getTime() 메서드를 이용하면 Date타입으로 변환이 가능하다.
		Calendar korea_time = Calendar.getInstance();
		System.out.println(korea_time.getTime());
		
		System.out.println("Date 클래스의 toString > " + now);
		System.out.println("SimpleDateFormat 사용 > " + simple.format(now));
		System.out.println("SimpleDateFormat 사용 > " + simple.format(korea_time.getTime()));
	}
	
}
