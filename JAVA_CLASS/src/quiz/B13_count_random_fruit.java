package quiz;

import java.util.Arrays;
import java.util.Random;



public class B13_count_random_fruit {
	public static void main(String[] args) {
//		크기 100의 배열에 랜덤 과일 문자열을 저장 해보세요.
//		등장하는 과일 : apple, banana, orange, peach, kiwi
//		각 과일이 몇 번 등장했는지 모두 기록하고 출력해보세요.
		Random rd = new Random();
		String fruit [] = new String[] {"apple","banana","orange","peach","kiwi"};
		int fruit_ct[] = new int[fruit.length];
		String newArr[] = new String[100];

		for(int i=0; i<newArr.length; i++) {
			
			int rand =rd.nextInt(5);
			
			//배열에 랜덤 과일 저장하기
			newArr[i] = fruit[rand];

		}	
		for(int i=0; i<newArr.length; i++) {
			int start = 0;
			
			while(start!=5) {
				if(newArr[i]==fruit[start]) {
					fruit_ct[start] += 1;
					break;
				}else
					start++;	
			}
		}
		System.out.printf("사과는 %d회, 바나나는 %d회, 오렌지는 %d회, 복숭아는 %d회, 키위는 %d회 입니다.", fruit_ct[0], fruit_ct[1], fruit_ct[2], fruit_ct[3], fruit_ct[4]);
	}
}
