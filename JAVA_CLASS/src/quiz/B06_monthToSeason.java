package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class B06_monthToSeason {
	public static void main(String[] args) throws IOException {
		//사용자로부터 달을 입력 받으면 해당하는 계절 출력
		// 3 4 5 봄 / 6 7 8 9 여름 / 10 11가을 // 12 1 2 겨울
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int month = Integer.parseInt(br.readLine());
		
		if( month >= 1 && month <=12) {
			
			switch (month) {
			case 3:
			case 4:
			case 5:
				System.out.println("봄");
				break;
			case 6:
			case 7:
			case 8:
			case 9:
				System.out.println("여름");
				
			case 10:
			case 11:
				System.out.println("가을");
			default:
				System.out.println("겨울");
				break;
			}
		
		}else {
			System.out.println("올바른 월을 입력하세요.");
			return;
		}
	}
		
}
