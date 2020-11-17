package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;

public class B13_count_letter_case {
	public static void main(String[] args) throws IOException {
//		사용자로부터 문장을 하나 입력받았다 치고
//		해당문장에 어떤 문자가 몇번 등장했는지 세어서 출력해보세요
//		대문자, 소문자, 숫자만 집계됩니다.
		
		BufferedReader br= new BufferedReader(new java.io.InputStreamReader(System.in));
		String userInput = br.readLine();

		int count_up[] = new int[26];
		int count_low[] = new int[26];
		int count_num[] = new int[10];
		
		int count_[][] = new int [][]{count_up, count_low, count_num};
		
		//입력받은 문장 배열의 요소에 저장
		for(int i=0; i<userInput.length(); i++) {
			char ch = userInput.charAt(i);
			
			if(ch >= 'a' && ch <='z') {
				count_low[ch-'a'] +=1;
			}
			else if(ch >= 'A' && ch <='Z') {
				count_up[ch-'A'] +=1;
			}else if(ch >= '1' && ch <= '9'){
				count_num[ch-9] +=1;
			}
		}
		
		
		for(int i =0; i< count_up.length; i++) {
			if(count_up[i] >0)
			{
				System.out.printf("%c가 등장한 횟수는 %d번 입니다.\n" ,  i+'A', count_up[i]);
			}
		}
		
		for(int i =0; i< count_low.length; i++) {
			if(count_low[i] >0)
			{
				System.out.printf("%c가 등장한 횟수는 %d번 입니다.\n" ,  i+'a', count_low[i]);
			}
		}
		
		for(int i =0; i< count_num.length; i++) {
			if(count_num[i] >0)
			{
				System.out.printf("%c가 등장한 횟수는 %d번 입니다.\n" ,  i, count_num[i]);
			}
		}
	}
}
