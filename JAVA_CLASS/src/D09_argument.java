
public class D09_argument {
	public static void main(String[] args) {
		
		System.out.println("받은 실행 옵션 : "+ args.length);
		for (int i = 0; i < args.length; i++) {
			System.out.println(i+"번째 프로그램 실행 옵션 : " + args[i]);
		}
	}
}
