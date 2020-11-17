
public class C13_throws {
	// # throws 
	// - 현재 메서드에서 발생하는 예외의 처리를 메서드를 호출한 곳으로 미룬다ㅣ
	// - 메서드 뒤에 발생할 위험이 있는 예외를 함께 정의한다.
	
	public static void stupid_method1() throws ArrayIndexOutOfBoundsException{
		int[] a = new int[10];
		System.out.println(a[999]);
	}
	public static void main(String[] args) {
		stupid_method1();
	}
}
