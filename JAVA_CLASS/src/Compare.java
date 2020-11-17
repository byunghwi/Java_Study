
public class Compare {
	public static void main(String[] args) {
		//	Q. 다음을 만족하는 비교 연산을 작성해보세요 (변수는 이미 선언 및 초기화 된것으로 가정) (배점:30)
		//		1. int타입 변수 a가 홀수일 때 true
		//		2. char타입 변수 ch가 영문자가 아닐 때 true
		//		3. boolean타입 변수 complete가 false일 때 true
		//		4. String타입 참조변수 str이 "yes"일 때 true
		//		5. String타입 참조변수 command가 8글자일 때 true
		//		6. String타입 참조변수 command의 세 번째 글자가 대/소문자 관계없이 q일때 true

		int a = 3;
		char ch = 'a';
		boolean complete = false;
		String str ="yes";
		String command = "seQenbvq";
	
		String result;
		// q1.
		result = (a % 2 != 0)?"true":"false";
		System.out.println("q1 > "+ result);
		
		//q2.
		result = ( (ch >= 'a' && ch <='z') || (ch >= 'A' && ch <= 'Z') )?"true":"false";
		System.out.println("q2 > "+ result);
		
		//q3.
		result = (complete == true)?"false":"true";
		System.out.println("q3 > "+ result);
		
		//q4.
		result = (str.equals("yes"))?"true":"false";
		System.out.println("q4 > "+ result);
		
		//q5.
		result = (command.length()==8)?"true":"false";
		System.out.println("q5 > "+ result);
		
		//q6.
		result = (command.toLowerCase().charAt(2)=='q')?"true":"false";
		System.out.println("q6 > "+ result);
	}
}
