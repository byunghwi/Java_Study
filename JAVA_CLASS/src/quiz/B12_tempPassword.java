package quiz;

import java.util.Random;

public class B12_tempPassword {
	public static void main(String[] args) {
//		랜덤 4자리의 임시 비밀번호 문자열을 생성하는 프로그램을 만들어보세요.
//		비밀번호를 구성하는 문자 - 알파벳 대문자, 숫자
		
		StringBuilder st = new StringBuilder();
		//65-90 -> 대문자
		//0-9 -> 숫자
		int pw;
		Random rd = new Random();
		
		while(st.length() <=4){
			
			if(st.length() ==4)
				break;
			
			pw = rd.nextInt(90);
			
			if(pw >=0 && pw <= 9) {
				st.append(pw);
			}else if((char) pw >= 'A' && (char)pw <='Z') {
				st.append((char)pw);
			}
		}
		
		System.out.println(st);
		
		
	}
}
