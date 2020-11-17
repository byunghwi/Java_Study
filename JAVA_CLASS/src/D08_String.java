import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D08_String {
	
	public static void main(String[] args) {
		String msg = "가나다/라마바/사아자/차카타";
		String [] str = msg.split("/");
		
		System.out.println(Arrays.toString(str));
		
		System.out.println(String.join(", ", str));
		
		msg = "ABCDEFG";
		
//		byte[] bytes = msg.getBytes();
//		System.out.println(Arrays.toString(bytes));
//		
		msg = "안녕하세요";
//		
//		bytes = msg.getBytes();
//		System.out.println(new String(bytes));
		
		try {
			//문자열을 코드화 한다. (인코딩)
			byte[] utf8_bytes  = msg.getBytes("UTF-8");
			byte[] euc_bytes = msg.getBytes("EUC-KR");
			
			System.out.println(Arrays.toString(utf8_bytes));
			System.out.println(Arrays.toString(euc_bytes));
			
			System.out.println(new String(utf8_bytes, "UTF-8"));
			System.out.println(new String(utf8_bytes, "EUC-KR"));
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		
		//getChars : char[] 에 문자열의 원하는 부분을 담아준다.
		msg = "Hello Java Python C-lang";
		
		char[] buffer = new char[11];
		msg.getChars(6, 17, buffer, 0);
		System.out.println(buffer);
		
		// valueOf : 다른 타입의 값을 문자열로 변홚나다.
		//		(해당 객체의 toString 결과를 반환받는다.)
		String ott =  String.valueOf(123);
		System.out.println(ott);
		
		//StringTokenizer
		// - 문자열을 자르는데 특화된 클래스
		// - split의 빠른버전
		ott = "99/88/77/66/55/44/33/22/11";
		
		//자를때 사용했던 문자열이 필요하다면 세번째 파라미터값을 true로 활성화
		StringTokenizer st = new StringTokenizer(ott, "/");
		
		System.out.println("토큰개수 : " + st.countTokens());
		
		//Tokens는 String 타입으로 반환한다.
		//Elements는 Object 타입으로 반환한다.
		while(st.hasMoreTokens()) {
			System.out.print(" "+st.nextToken());
		}
		
		
		// String 생성자
		new String();
		System.out.println();
	}
	
}
