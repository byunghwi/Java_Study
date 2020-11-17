package quiz;

public class B11_whileQuiz {
	public static void main(String[] args) {
//		while을 이용하여
//		1. 1부터 100까지의 3의 배수의 총합을 구해보시오.
//		2. 200부터 1까지 출력해보시오.
//		3. 1부터 20까지의 숫자 중 2의 배수도 아니고 3의 배수도 아닌 숫자들의 총합을 구하시오.

		int i =1;
		int q1_sum = 0;
		while(i<=100) {
			if(i%3==0) {
				q1_sum += i;
			}
			
			i++;	
		}
		System.out.println("q1 : " + q1_sum);
		System.out.println();
		
		int j=200;
		int count=1;
		System.out.println("q2 : ");
		while(j>=1) {
			System.out.printf("%4d ",j--);
			if(count%10==0) {
				System.out.println();
			}
			count++;
		}

		System.out.println();
				
		int k=1;
		int q3_sum=0;
		while(k<=20) {
			if(k%2!=0 && k%3!=0) {
				q3_sum += k;
			}		
			k++;
		}
		System.out.print("q3 : " + q3_sum);			
	}
}
