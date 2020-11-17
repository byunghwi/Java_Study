package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class B01_Dollar {
	public static void main(String[] args) {
		
//		한국 돈을 입력하면 달러 구매시 얼마를 받게 되는지 계산해주는 프로그램을 만들어보시오.
//		환율은 검색, 소수 둘째자리까지 출력, 환전 수수료 1.75%
		Scanner sc = new Scanner(System.in);
		
		DecimalFormat form = new DecimalFormat("#.##");
		
		int kor_money;
		double dollar;
		System.out.print("한국 돈을 입력하세요 : ");
		kor_money = sc.nextInt();
		
//		1달러 = 1,138.80원 0.0175
		dollar = (kor_money*0.9825*0.0008778);
		System.out.println("달러 구매시 받을 금액은 총 " + form.format(dollar)+ " 달러입니다.");
		
		sc.close();
	}

}
