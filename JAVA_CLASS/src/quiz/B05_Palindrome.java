package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B05_Palindrome {
	public static void main(String[] args) throws IOException {
		System.out.println("확인하려는 단어를 입력하시오");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String word = br.readLine();


		if(isPalindrome(word) == true)
			System.out.println("PALINDROME 입니다.");
		else
			System.out.println("PALINDROME이 아닙니다.");
		
		
	}
	
	public static boolean isPalindrome(String wd) {
		int size = wd.length()-1;
		char first = wd.charAt(0);
		char last = wd.charAt(size);
		
		//문자열  start위치 부터 end전까지 문자열 발췌
		String wd_sub = wd.substring(1, size);
		
		//System.out.println("size:" +size + " /// first:" + first + "//// last: " + last + "///ct_sub: "+ ct_sub + "///ct.length : " + ct.length());
	
		if(first == last) {
			//짝수개
			if(wd_sub.equals("")) {
				
				return true;
				
			//홀수개
			}else if(wd_sub.length() == 1) {
				
				return true;
				
			}	
			
			//재귀
			return isPalindrome(wd_sub);
		}
		else {
			return false;
		}

	}
}
