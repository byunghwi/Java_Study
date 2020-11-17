package quiz;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class D10_OnlyPhoneNumber {
	public static void main(String[] args) {
		// 사용자로부터 전화번호만 입력받아보세요.
		// 전화번호 형태가 아닐 경우 에러메세지를 출력 후 다시 입력
		Scanner sc = new Scanner(System.in);
		Pattern pattern = Pattern.compile("^01(?:0|1|[6-9])-(?:\\d{3}|\\d{4})-\\d{4}$");
		while(true) {
			System.out.print("전화번호를 입력하세요 > ");
			String phoneNum = sc.nextLine();
			Matcher matcher = pattern.matcher(phoneNum);
			if(matcher.find()) {
				break;	
			}
		}
	}
}
