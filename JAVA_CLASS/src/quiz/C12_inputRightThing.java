package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



public class C12_inputRightThing {
	public static void main(String[] args) throws IOException {
		//사용자로부터 int 타입의 데이터를 입력받고 출력해보세요
		//잘못된 타입의 데이터가 들어오더라도 프로그램이 종료되지 않아야 합니다.
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int num;
		
		while(true) {
			System.out.print("숫자를 입력하세요 > ");
			
			try {
				num = Integer.parseInt(br.readLine());
				break;
			} catch (NumberFormatException e) {
				System.out.println(e.getMessage());
			}
			
		}
		
		System.out.println("입력한 숫자는 > "+ num);
		
	}
}
