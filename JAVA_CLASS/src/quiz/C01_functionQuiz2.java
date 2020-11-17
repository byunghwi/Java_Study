package quiz;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class C01_functionQuiz2 {
	public static void main(String[] args) throws IOException {
//		1. 최소값과 최대값을 매개변수로 받고, 그 사이의 모든 값을 포함하는 int 배열 생성하여 반환하는 range 함수를 만들라
//			(최소값 이상, 최대값 미만)
//		
//		2. 최대값을 매개변수로 전달 받으면, 0부터 최대값 미만의 모든 값을 포함하는 int 배열을 생성하여 반환하는range2 함수를 만들라.
//		
//		3. 문자열 배열을 전달받으면 해당 배열을 모두 "/"를 이어 붙이는 join 함수를 만들어보세요
//			ex) {"apple", "banana" , "orange"} -> "apple/banana/orange"
//
//		4. 문자열 타입의 숫자(num), 원래 진법(base_from), 바꾸려는 진법(base_to)를 전달받으면 base_from의 진법이었던 해당 숫자를 base_to 진법의 문자열로 변환하여 반환하는 함수를 만들라.
//		*만약 진법이 잘못된 경우 null을 반환.
//		반환할 수 있는 최대 진법은 36진법, 최소진법은 2진법	
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.print("원하는 범위의 숫자를 2개 입력하세요 > ");
		String num[] = br.readLine().split(" ");
		int max = Integer.parseInt(num[0]); 
		int min = Integer.parseInt(num[1]);
		
		String msgArr[] = {"apple", "banana", "orange", "grape"};
		
		//num1최대값, num2최소값 만들기
		if(min > max) {
			int temp = max;
			max = min;
			min = temp;
		}
	
		//Q1.
		System.out.println( "Q1. " + Arrays.toString(range(max,min)));
		//Q2.
		System.out.println( "Q2. " + Arrays.toString(range2(max)));
		//Q3.
		System.out.println( "Q3. join1 함수: " + join1(msgArr));
		System.out.println( "Q3. join2 함수: " + join2(msgArr));
		//Q4
		System.out.println(convert_base("1010", 2, 8));

	}
	
	
	//Q1. 최소값과 최대값을 매개변수로 받고, 그 사이의 모든 값을 포함하는 int 배열 생성하는 함수
	public static int[] range(int max, int min ) {
		int arr[] = new int[max-min];
		
		for (int i = 0; i < arr.length; i++) {
			arr[i] = min++;
		}
		
		return arr;
		
	}
	
	//Q2. 0부터 최대값 미만의 모든 값을 포함하는 int 배열을 생성하는 함수
	public static int[] range2(int max) {
		int arr[] = new int[Math.abs(max)];
		int min =0;
		if(max < 0) {
			for (int i = 0; i < Math.abs(max); i++) {
				arr[i] = min--;
			}
		}else {
			for (int i = 0; i < arr.length; i++) {
				arr[i] = min++;
			}
		}

		return arr;
	}
	
	//Q3. 문자열 치환
	public static String join1(String[] msg) {
		String toStr = Arrays.toString(msg).replace(", ", "/").replace("[", "").replace("]", "");

		return toStr;
	}
	
	//Q3. 문자열 치환
	public static String join2(String[] msg) {
		String toStr = "";
		
		for (int i = 0; i < msg.length; i++) {
			toStr += (msg[i]+"/");
		}
	
		return toStr.substring(0, toStr.length()-1);
	}
	
	public static String convert_base(String num, int base_from, int base_to) {
		num = num.toUpperCase();
		
		if(base_from <2 || base_from >36 || base_to <2 || base_to >36) {
			System.err.println("사용가능한 진법은 2~36입니다.");
			return null;
		}
				
		int pow = num.length()-1;
		long real_value = 0;
		
		for (int i = pow; i > -1; i--) {
			char digit = num.charAt(pow-i);
			int value = getValue(digit);
			
			//예외처리.
			//8진법인데 8 이상의 숫자가 있으면 에러
			if (value >= base_from) {
				System.err.println("base_from 이상의 값을 지닌 문자가 있습니다. ");
				return null;
			}
			
			System.out.println(digit);
			System.out.println("\t실제 값 : " + value);
			System.out.println("\t"+Math.pow(base_from, i) + "의 자리");
			
			real_value += value * Math.pow(base_from, i);
		}
		System.out.println( base_from +"진법 문자열 \"" + num + "\"의 값은 실제로 "+ real_value + " 입니다.");
		
		StringBuilder result = new StringBuilder();
		
		while (real_value > 0) {
			result.append(getSymbol(((int)real_value % base_to))); // long타입이었으므로 int타입으로 변환
			real_value /= base_to;
		}
		
		return result.reverse().toString();
		
	}
	
	public static char digits[] = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
	
	public static char getSymbol(int value) {
		return digits[value];
	}
	
	public static int getValue(char digit) {		
		for (int i = 0; i < digits.length; i++) {
			if(digits[i] == digit) {
				return i;
			}
		}
		return -1;
	}

}
