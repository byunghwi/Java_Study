package quiz;

public class B10_Gugudan {
	public static void main(String[] args) {
		//q1. 구구단을 가로로 출력
		for(int i=2; i<=9; i++) {
			System.out.print(i+"단 : ");
			for(int j=1; j<=9; j++) {
				System.out.printf("%dx%d=%d\t", i,j,i*j);
			}
			System.out.println();
		}
		
		System.out.println();
		System.out.println();
		
		
		//Q2 구구단을 세로로 출력하라
		for(int i=2; i<=9; i++) {
			System.out.print(i+"단\t");
		}
		System.out.println();
		
		//q2 구구단 세로로
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=10; j++) {

					if(j==10)
					{	
						System.out.println();
						break;
					}
					System.out.printf("%dx%d=%d\t", j,i, i*j);
			}
			

		}
	}
}
