package quiz;

import java.util.Scanner;

public class B10_Prime {
	public static void main(String[] args) {
		//사용자로부터 숫자를 입력받으면 1부터 입력한 숫자 사이에 존재하는 소수를 모두 출력해보세요.
		Scanner sc = new Scanner(System.in);
		int user = sc.nextInt();
		
		for(int i=1; i<=user; i++) {
			for(int j=1; j<=i; j++) {
				//1은 소수가 아님.
				if(i==1 || j==1)
					continue;
				
				if(i%j==0 && i==j)
					System.out.print(i + " ");
				else if(i%j==0 && i!=j )
					break;
				
			}			
		}
	}
}