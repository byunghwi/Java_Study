package quiz;

public class C01_functionQuiz {
	//1
	public static boolean checkAlpha(char input) {
		return (input >= 'a' && input <='z') || (input >= 'A' && input <='Z');
	}
	//2
	public static boolean checkMultiple(int input) {
		return ( input % 3 ==0);
	}
	//3
	public static String checkOdd(int input) {	
		return (input % 2 ==0)?"짝수입니다":"홀수입니다.";
	}
	//4
	public static boolean checkPrime(int input) {	
		for(int i=2; i<=input; i++) {

			if(input%i ==0) {				
				if(input != i)
					return false;
				else
					return true;
			}	
			else
				continue;
		}	
		return true;
	}
	//5
	public static int checkFactorial(int input) {
		for(int i=input-1; i>=1; i--) {
			input = input*i;
		}
		return input;
	}
	//6
	public static int checkPow(int input1, int input2) {
			int pow_rs = input1;
			
			if(input2 <=0)
				return 1;

			for (int i = 1; i < Math.abs(input2); i++) {
				pow_rs*=input1;
			}
			
			return pow_rs;
	}
	
	//7
	public static int recursivPow(int input1, int input2) {
				if(input2 < 1)
					return 1;
				
				return input1*recursivPow(input1, --input2);
		}

	public static void main(String[] args) {
//		#다음 함수를 정의하라.
//		1. 전달한 문자가 알파벳이면 true를 반환, 아니면 false를 반환하는 함수
//		2. 전달한 숫자가 3의 배수이면 true를 반환, 아니면 false,를 반환하는 함수
//		3. 숫자를 한 개 전달하면 문자열 "짝수입니다." 또는 "홀수입니다." 를 반환하는함수
//		4. 전달한 숫자가 소수인지 아닌지 판별해주는 함수 (boolean)
//		5. 숫자를 전달하면 해당 숫자의 팩토리얼 결과를 반환하는 함수
//		6. 숫자 두개 (a, b)를 전달하면 a의 b 제곱을 반환하는 함수 (0제곱은 1을 반환해야함, Math.pow금지)	
//		7. 6번을 재귀로 풀라
		
		char msg = 'ㄱ';
		int num = 2;
		int num2 = 4;
		System.out.printf("전달한 문자> %c / 전달한 숫자> %d / 전달한 숫자 a,b> (%d, %d)\n\n",msg, num, num, num2);

		System.out.println("Q1 전달한 문자가 알파벳인가 : "+checkAlpha(msg));
		System.out.println("Q2 전달한 숫자가 3의 배수인가 : "+checkMultiple(num));
		System.out.println("Q3 전달한 숫자가 홀수인가 짝수인가 : "+checkOdd(num));
		System.out.println("Q4 전달한 숫자가 소수인가 : "+checkPrime(num));
		System.out.println("Q5 전달한 숫자의 팩토리얼 값은 : "+checkFactorial(num));
		System.out.println("Q6 a의 b 제곱은 : "+checkPow(num, num2));
		System.out.println("Q7 a의 b 제곱 재귀로: "+recursivPow(num, num2));
		
	}

}
