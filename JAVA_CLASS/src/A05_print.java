
public class A05_print {
	public static void main(String[] args) {
		System.out.print("Hello World");
		System.out.println("Hello World");
		System.out.println();
		
		int year = 2020;
		int month = 10;
		int day = 20;
 		System.out.printf("%d년 %d월 %d일 ", year, month, day);
 		
 		// printf에 사용하는 서식문자
 		// %d = 10진수 정수
 		// %x , X = 16진수 정수 
 		// %o  = 8진수 정수
 		
 		System.out.printf("%x%X%x%X", 10,11,12,13);
 		System.out.println();
 		
 		// # 서식문자 옵션
 		// %d만 넣어야 하는 것은 아님
 		
 		// %숫자d : 숫자만큼 칸을 확보한 뒤 오른쪽 정렬하여 출력한다.
 		System.out.printf("이름 : %15s\n", "Hong Gildong");
 		System.out.printf("나이 : %15d\n", 15);
 		System.out.println();
 		
 		// %-숫자d : 숫자만큼 칸을 확보한 뒤 왼쪽 정렬하여 출력한다.
 		System.out.printf("%-10s : Hong gildong\n", "FullName");

 		
 		System.out.println();
 		
 		//%+숫자d : 양수 앞에도 부호를 붙이게 된다.
 		System.out.printf("오늘은 섭씨 %+d℃ 입니다. \n", 20);
 		
 		System.out.println();
 		
 		// %.숫자f : 소수 자릿수를 설정한다.
 		System.out.printf(".3 : %.3f\n", 123.123);
 		System.out.printf("default : %f\n", 123.123);
 		System.out.printf(".10 : %.10f\n", 123.123);
 		System.out.printf(".20 : %.20f\n", 123.123);
 		System.out.printf(".255 : %.255f\n", 123.123);
 		
 		System.out.println();
 		
 		//제곱
 		System.out.println(Math.pow(2,4));
 		//제곱근
 		System.out.println(Math.sqrt(2));
 		//절대값
 		System.out.println(Math.abs(-20));
 		//반올림
 		System.out.println(Math.round(1.234));
 		
 		
	
	}
}
