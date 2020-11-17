package quiz;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class D02_LottoSet {
	public static void main(String[] args) {
		//1부터 45의 숫자로 이루어진 6자리 HashSet을 생성해보세요
		Set<Integer> set = new HashSet<Integer>();
		
		while (set.size() < 6) {
			int num = (int)(Math.random()*45+1);
			set.add(num);
		}		
		for(int a : set) {
			System.out.print(a+" ");
		}
	}	
}
