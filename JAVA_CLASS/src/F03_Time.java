import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class F03_Time {
	public static void main(String[] args) {
		
		// # java.time의 시간 객체들은 set이 없다.
		
		// 1. now를 통해 지금의 인스턴스를 생성하기.
		//날짜만 저장
		LocalDate today = LocalDate.now();
		System.out.println(today);
		
		// 시간만 저장
		LocalTime now = LocalTime.now();
		System.out.println(now);
		
		//날짜와 시간을 저장
		LocalDateTime datetime = LocalDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(datetime);
		
		//날짜와 시간과 경도를 저장
		ZonedDateTime zoned = ZonedDateTime.now(ZoneId.of("US/Samoa"));
		System.out.println(zoned);
		
		
		// 2. of()를 이용해서 해당 날짜/시간의 인스턴스를 생성할 수 있다.
		LocalDate birthday = LocalDate.of(1991, 07, 23);
		System.out.println(birthday);
		
		LocalTime birthtime = LocalTime.of(5,5,5,1234);
		System.out.println(birthtime);
		
		LocalDateTime birthdatetime = LocalDateTime.of(birthday, birthtime);
		System.out.println(birthdatetime);
		
		ZonedDateTime birthdayzoned = ZonedDateTime.of(birthdatetime, ZoneId.of("Asia/Seoul"));
		System.out.println(birthdayzoned);
		
		Instant start_time = Instant.now();
		System.out.println("start : " + start_time);
		
		Instant end_time = Instant.now();
		System.out.println(start_time.isAfter(end_time));
		System.out.println(end_time.isAfter(start_time));
		
		// 날짜 / 시간 계산
		LocalDate date1 = LocalDate.now();
		LocalDate date2 = LocalDate.of(1991, 07, 23);
		
		System.out.println(today.minusYears(5));
		
		// 문자열을 날짜/시간 객체로 변환 (파싱 / Parsing)
		// YYYY-MM-dd가 가장 기본형태의 날짜 문자열이다.
		LocalDate test1 = LocalDate.parse("2019-12-12");
		System.out.println(test1.plusDays(5));
		
		//DateTimeFormatter.ofPattern() 을 이용해 원하는 패턴을 생성할 수 있다.
		LocalDateTime test2 = LocalDateTime.parse("2021년 05월 05일 19시 05분 35초", DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분 ss초"));
		System.out.println(test2);
		
		// # java.time 객체를 문자열로 변경하기
		// format() 메서드를 이용한다.
		// 날짜 객체를 문자열 변환할때도 DateTimeFormatter를 사용한다.
		ZonedDateTime zdt = ZonedDateTime.now();
		System.out.println("ISO_DATE : " + zdt.format(DateTimeFormatter.ISO_DATE));
		System.out.println("BASIC_ISO_DATE : " + zdt.format(DateTimeFormatter.BASIC_ISO_DATE));
		System.out.println("ISO_ZONED_DATE_TIME : " + zdt.format(DateTimeFormatter.ISO_ZONED_DATE_TIME));
		System.out.println("ISO_DATE_TIME : " + zdt.format(DateTimeFormatter.ISO_DATE_TIME));
		
	}
}
