package quiz;

import java.util.Scanner;

public class B01_GuessAge {
	public static void main(String[] args) {
		//사용자로부터 올해의 년도와 출생년도를 입력받으면
		//한국 나이를 계산하여 몇 살인지 알려주는 프로그램을 만들어 보세요.
		int year, birth;
		Scanner sc = new Scanner(System.in);
		System.out.print("올해의 연도와 출생년도를 입력하세요 : ");
		year = sc.nextInt();
		birth = sc.nextInt();
		
		int kor_age = year-birth+1;
		System.out.println("한국 나이는 : " + kor_age + "세 입니다.");
		
		sc.close();
	}
}
			