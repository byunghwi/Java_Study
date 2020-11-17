import java.util.Scanner;

public class B01_Scanner {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("아무 값이나 입력해보세요 : ");
		int a = sc.nextInt();
		
		System.out.println("입력받은 값 : " + a);
		
		sc.close();
	}
}
