package quiz;

import java.util.Arrays;
import java.util.Random;

public class B13_lotto_quiz {
	public static void main(String[] args) {
		//1부터 45사이의 중복없는 랜덤 숫자 6개로 이루어진 배열을 생성하라.
		Random rd = new Random();
		
		int lotto[] = new int[6];
		int i = 0;
		while(i != 6) {
			
			boolean duple = false;
			
			lotto[i] = rd.nextInt(45)+1;
			
			for(int j=0; j<i; j++) {
				if(lotto[i] == lotto[j]) {
					duple = true;
					break;
				}
			}
			
			if(!duple) {
				i++;
			}
			
		}
		
		System.out.println(Arrays.toString(lotto));
		
	}
}
