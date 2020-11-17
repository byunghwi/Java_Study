package quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CheckDice implements ThrowDice{
	// 주사위를 다섯번 던진다
	//풀하우스 (같은 숫자가 2개 + 3개)
	//스몰스트레이트 (1234/2345/3456)
	//라지스트레이트 (12345/23456)
	//4다이스 (같은 숫자 4개)
	//5다이스 (같은 숫자 5개) - 
	//를 구분하는 클래스를 작성하고 테스트 해보세요
	//*다른 파일에 작성하고 여기서는 갖다 쓰기만 할 것.
	
	static int diceNum = 5;
	
	List<Integer> diceList = new ArrayList<>();
	Set<Integer> set = new HashSet<>();
	
	@Override
	public List<Integer> throwDice() {
		
		for (int i = 0; i < diceNum; i++) {
			int num =(int)(Math.random()*6+1);
			diceList.add(num);
		}
		return diceList;
	}
	
	public void checkDice(List<Integer> diceList) {
	
		set.addAll(diceList);
		
		//스트레이트카운트
		int countST = 0;
		for (int i = 0; i < diceList.size()-1; i++) {
			if(diceList.get(diceList.size()-1)-diceList.get(i)== (diceList.size()-1)-i && diceList.get(i+1)-diceList.get(i)==1) {
				countST++;
			}
		}
		
		int countSM = 0;
		for (int i = 0; i < diceList.size(); i++) {
			for (int j = i+1; j < diceList.size(); j++) {
				if(diceList.get(i) == diceList.get(j))
					countSM++;
			}
		}

		System.out.println("========================결과========================");
		System.out.println("당신이 던진 주사위 > "+ diceList);
		
		if(set.size() == 1) {
			System.out.println("\t> 5다이스");
		}else if(set.size() == 2 && countSM ==4) {
			System.out.println("\t> 풀하우스");
		}else if(set.size() == 2 && countSM ==6){
			System.out.println("\t> 4다이스");
		}else {
			if(countST >= 4) {
				System.out.println("\t라지스트레이트");
			}else if(countST >=3) {
				System.out.println("\t스몰스트레이트");
			}else {
				System.out.println("\t아무 것도 아닙니다.");
			}
		}
		System.out.println();	
	}

}
