package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B09_strupcase {
	public static void main(String[] args) throws IOException {
		// 입력받은 문자열의 모든 알파벳을 대문자로 만들어보세요
		// 원본이 훼손되지 않고, 새로운 문자열이 생성되어야함.
		
		System.out.println("문자열을 입력하세요.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		String isengDown = "^.*[a-z].*";
		
		if(str.matches(isengDown)) {
			char arr[] = str.toCharArray();
			
			char arr_rs[] = new char[arr.length];
			
			for(int i=0; i<arr.length; i++) {
				if(arr[i]>='a' && arr[i] <= 'z' ) {
					arr_rs[i] = (char) (arr[i] - 32);
				}else
					arr_rs[i] = arr[i];
			}
			
			//새로운 문자열 생성
			StringBuffer st = new StringBuffer("");
			
			for(int i=0; i<arr_rs.length; i++) {
				st.append(arr_rs[i]);
			}	
			System.out.println(st);
		
		}else 
			System.out.println("모두 대문자입니다.");


		
	
	}
}
