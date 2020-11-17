package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;



public class B13_countLetter {
	public static void main(String[] args) throws IOException {
//		사용자로부터 문장을 하나 입력받았다 치고 
//		해당 문장에 어떤 알파벳이 몇번 등장했는지 세어서 출력해보세요
		//String alpa = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";	

		BufferedReader br= new BufferedReader(new java.io.InputStreamReader(System.in));
		String userInput = (br.readLine()).toLowerCase();

		int count[] = new int[26];

		//입력받은 문장 배열의 요소에 저장
		for(int i=0; i<userInput.length(); i++) {
			char ch = userInput.charAt(i);
			
			if(ch >= 'a' && ch <='z') {
				count[ch-'a'] +=1;
			}
		}
		
		for(int i=0; i<26; i++) {
			if(count[i]>0) {
				System.out.printf("%c가 등장한 횟수는 %d번 입니다.\n" , i+'a', count[i]);
			}
		}
	}

}

