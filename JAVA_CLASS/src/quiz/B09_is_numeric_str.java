package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B09_is_numeric_str {
	public static void main(String[] args) throws IOException {
		//입력받은 문자열에 숫자만 포함되어 있으면 1을 출력
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		br.close();
		
		//졍규식 숫자
		String numeric = "^[0-9]+$";

			if(str.matches(numeric))
				System.out.println("숫자만입니다. 결과: 1");
			else if(str.equals("") || str ==null)
				System.out.println("비어있습니다. 결과: 2");
			else
				System.out.println("숫자이외 문자가 포함되어 있습니다. 결과 : 0");
	}
}
