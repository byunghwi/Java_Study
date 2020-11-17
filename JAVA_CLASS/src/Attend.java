import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Attend {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("시간과 분을 입력하세요 > ");
		
		String time[]  = br.readLine().split(" ");
		char hourChar = time[0].charAt(0);
		char minChar = time[1].charAt(0);
		
		//사용자로부터 입력받은 값이 숫자일 경우
		if(( hourChar >=48 && hourChar<= 57 ) && (minChar >=48 && minChar <= 57 ) ) {
			
			int hour = 	Integer.parseInt(time[0]);
			int min = 	Integer.parseInt(time[1]);
			
			//정상적인 시간,분 범위내
			if( (hour >= 0 && hour <=24) && (min >= 0 && min <= 59)) {
				if(hour <= 9 && min < 10) {
					System.out.println("정상");
				}else if(hour >= 15) {
					System.out.println("결석");
				}
				else if(hour >= 9 && min >= 10){
					System.out.println("지각");
				}
				
			}else 
				System.err.println("에러");	
		}else {
			System.err.println("에러");
			System.exit(0);
		}
	}
}
