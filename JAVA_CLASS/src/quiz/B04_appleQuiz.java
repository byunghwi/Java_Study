package quiz;

import java.util.Scanner;

public class B04_appleQuiz {
	public static void main(String[] args) {
		
//		ctrl shift o 임포트 찾기
		
		//사과를 10개씩 담을 수 있는 바구니
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("사과의 개수를 입력하세요 : ");
		int apple_count = sc.nextInt();
		
		
		int bucket_count =  apple_count/10; 
		int remain_count = apple_count%10;
		int result;
		
		if (remain_count == 0) {
			result = bucket_count;
		}else {
			result = bucket_count+1; 
		}
		
		System.out.println("필요한 바구니의 개수는 : "+ result+ "입니다.");
		
		
	}
}
