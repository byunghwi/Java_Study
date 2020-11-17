package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10_NextPrime {
//	사용자로부터 숫자를 입력받으면
//	입력받은 수보다 더 크거나 같은 다음 소수를 찾아서 출력하라
	public static void main(String[] args) throws NumberFormatException, IOException {
			
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int user = Integer.parseInt(br.readLine());
		
			for(int i=user; true; i++) {
				for(int j=2; j<=i; j++) {				
					if(i%j==0 && i==j) {
						 System.out.println(i);
						 return;
					}
					else if(i%j==0 && i!=j )
						break;			
				}			
			}	
		}
}
