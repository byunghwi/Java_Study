package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B09_forQuiz {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		사용자가 숫자를 입력했을 때 ,
//		1. 10부터 입력한 숫자까지의 총 합을 구해보세요.
//		2. 1부터 입력한 숫자 사이의 3의 배수만 모두 출력하고 총 몇개인지 출력.
		
		int sum = 0;
		int count = 0;
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		
		
		//입력한 수가 음수일 경우
		if(num < 0) {
			for(int i=num; i<= 10; i++)
				sum += i;
			
			//음의 정수일때 3의배수 개수
			for(int j=num; j<=1; j++) {
				if(j%3==0 && j!=0) {
					System.out.println("입력한 수가 음의 정수 일 때의 3의 배수 : " + j );
					count++;
				}
			}
			
		}else {
			//입력한 수가 10보다 클때
			if(num >= 10) {
				for(int i=10; i<= num; i++)
					sum += i;
			}//입력한 수가 10보다 작을 때
			else {
				for(int i=num; i<=10; i++)
					sum += i;
			}
			
			//양의 정수일때 3의배수 개수
			for(int j=1; j<=num; j++) {
				if(j%3==0) {
					System.out.println("입력한 수가 양의 정수 일 때의 3의 배수 : " + j );
					count++;
				}
			}
				
		}

		
		System.out.println("10부터 "+ num+"까지의 총 합은 : " + sum);


		System.out.println("1부터 "+num+"까지 3의배수의 총 갯수 : " + count);
		
		
	}
}
