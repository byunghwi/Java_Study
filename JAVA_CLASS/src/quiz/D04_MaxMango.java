package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class D04_MaxMango {
	public static void main(String[] args) {
		//칼로리가 랜덤으로 설정되는 망크 클래스를 하나 생성하고
		// 100개의 망고 인스턴스 중 가장 칼로리가 높은 망고를 선택해보세요.
		//	* 만약 칼로리가 같은 경우 더 높은 당도를 가진 인스턴스를 선택해야함.
		
		List<Mango> mangoList = new ArrayList<Mango>();
		
		for (int i = 0; i < 100; i++) {
			mangoList.add(new Mango());
		}
		Collections.sort(mangoList, new Comparator<Mango>() {

			@Override
			public int compare(Mango mango1, Mango mango2) {
				if (mango1.calrorie > mango2.calrorie)
					return -1;
				else if(mango1.calrorie < mango2.calrorie) 
					return 1;
				else {
					if(mango1.sweet > mango2.sweet)
						return -1;
					else if(mango1.sweet < mango2.sweet)
						return 1;
					else
						return 0;
				}
					
			}
		});
		
		System.out.println(mangoList);
		System.out.println();
		
		System.out.println( "가장 칼로리가 높은 망고는 > " + mangoList.get(0));
		
	}
}
