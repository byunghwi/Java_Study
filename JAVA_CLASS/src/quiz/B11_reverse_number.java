package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B11_reverse_number {
	public static void main(String[] args) throws NumberFormatException, IOException {
//		사용자로부터 정수를 하나 입력받고
//		그 정수를 일의 자리부터 한자리씩 출력해보세요
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		String user = br.readLine();
//
//		int length = user.length();
//
//		//123
//		if(length >=2) {
//			while(length>=1) {
//				System.out.print(user.charAt(length-1));
//				length--;
//			}
//			
//		}else if(user.equals("") || user.isEmpty() || user ==null || length ==1){
//			System.out.println("한자리 수 이상을 입력해주세요.");
//		}
		
		//123
		int user = Integer.parseInt(br.readLine());
		int reverse = 0;
		while(true) {
			//System.out.print(user%10);
			reverse += user%10;
			user /= 10;
			
			
			if(user <= 0)
				break;
			
			reverse *= 10;
		}
		System.out.println(reverse);
		
		
		
	}
}
