import java.util.Random;

public class B12_random {
	public static void main(String[] args) {
		//원하는 범위 내의 랜덤 숫자 생성하는 순서
		// (1) Math.random()에 범위내의 숫자갯수를 곱하고
		// (2) 범위내의 나올수 있는 가장 작은 수를 더한다.
		// (3) 소숫점 아래를 버린다.
		
		
		//practice
		//3000이상 5000이하의 랜덤 정수를 100번 생성하고, 그동안 나왔던 가장 큰 수와 가장 작은 수를 출력하시오
		
//		int max =3000;
//		int min =5000;
//		int count =1;
//		
//		for(int i=0; i<100; i++) {
//			int now = (int) (Math.random()*2001+3000);
//			System.out.println(now +" : count " + count++);
//			
//			if(now >= max)
//				max = now;
//			
//			if(now <= min)
//				min = now;		
//		}
//		
//		System.out.println();
//		System.out.printf("최솟값은 : %d / 최댓값은 : %d", min, max);
		
		
		
//		 랜덤클래스 이용
//		 - 생성할 때 원하는 시드번호를 선택할 수 있다.
//		 - 같은 시드 번호로 생성하면 같은 값이 나온다.
//		 - 시드번호를 전달하지 않으면 무작위로 시드가 선택된다.
		
//		# 새로운 랜덤 시드 생성
		
		Random ran = new Random(10);
		Random ran2 = new Random(10);
		 
		System.out.println(ran.nextInt());
		System.out.println(ran2.nextInt());
		
//		# Random.nextInt(bound) : 원하는 범위의 정수를 반환한다.
//		- 0~bound 미만의 정수를 반환한다.
//		- bound를 전달하지 않으면 int범위 전체에서 랜덤 정수가 선택된다.
		System.out.println(ran.nextInt(30)); 	//0 ~ 29
		System.out.println(ran.nextInt()); 		//int 전체 범위
		System.out.println(ran.nextInt(21)+80); //80 ~ 100
				
		
		
		
	}
}


