package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B09_printReverse {
	public static void main(String[] args) throws IOException {
		//사용자가 입력한 문장을 거꾸로 출력하라.
		
		System.out.println("문장을 입력하시오.");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		
		char arr[] = str.toCharArray();
	
		for(int i =0; i<= str.length()-1; i++) {
			arr[i] = str.charAt(i);
		}

		System.out.print("변환된 문자열은 : ");
		
		for (int j=arr.length-1; j>=0; j--) {
			System.out.print(arr[j]);
		}
		
		
	}
}
