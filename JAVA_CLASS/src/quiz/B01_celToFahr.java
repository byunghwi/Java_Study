package quiz;

import java.text.DecimalFormat;
import java.util.Scanner;

public class B01_celToFahr {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		DecimalFormat form = new DecimalFormat("#.#");
		
		int celsius; // 섭씨
		float fahrenheit; // 화씨
		
		System.out.print("섭씨온도를 입력하세요: ");		
		celsius = sc.nextInt();
		
		fahrenheit =  (float) (celsius *1.8 +32);
		
		System.out.println("화씨온도는 : " + form.format(fahrenheit)+ "입니다.");
		
		sc.close();
		
	}
}
