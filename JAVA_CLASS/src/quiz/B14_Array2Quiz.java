package quiz;

import java.util.Arrays;

public class B14_Array2Quiz {
	public static void main(String[] args) {
		int [][] numArr = {
				{10,10,10,10},
				{90,50,30,70},
				{800,500},
				{300,300,300}
		};
		
//		numArr의 총합과 평균(소수점 둘째자리)을 구해서 출력하라.
//		numArr의 각 행의 합과 열의 합을 모두 구해서 출력하라.
//			0행의 합은 10+10+10+10
//			0열의 합은 10+90+800+300 0,2 1,2 2,2  
		
		int sum =0;
		int items=0;
		int max_row = 0;
		for (int i = 0; i < numArr.length; i++) {
			items += numArr[i].length;
			
			//최대열 구하기.
			if(max_row <= numArr[i].length)
				max_row = numArr[i].length;

			for (int j = 0; j < numArr[i].length; j++) {
				sum += numArr[i][j];
			}
		}
		System.out.println("총 합 :"+sum+" / 평균 : "+ sum/(double)items);
		
		
		int rowSum[] = new int[numArr.length];
		int colSum[] = new int[max_row];
		
		for (int i = 0; i < numArr.length; i++) {
			for (int j = 0; j < numArr[i].length; j++) {
				rowSum[i] += numArr[i][j];
				colSum[j] += numArr[i][j];
			}
		}
		
		System.out.println("행의 합 : "+ Arrays.toString(rowSum));
		System.out.println("열의 합 : "+ Arrays.toString(colSum));
		
	}
}
