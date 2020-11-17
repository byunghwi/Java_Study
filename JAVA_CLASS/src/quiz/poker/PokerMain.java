package quiz.poker;

import java.util.ArrayList;
import java.util.List;

public class PokerMain {
	public static void main(String[] args) {
		
		PokerHand ph = new PokerHand(); //생성자에서 총 52장 카드셋 및 셔플 완료 후 초기 5장 뽑기.
		char shape = 0;
		
		List<Cards> checkCard = new ArrayList<Cards>();
		
		checkCard.addAll(ph.myPickCard);
		
		for (int i = 0; i < checkCard.size(); i++) {
			System.out.println( "내가 고른 카드 : " + checkCard.get(i).shape + " / " + checkCard.get(i).num);
		}
		
		//카드 추가하기.
		checkCard.clear();
		checkCard.addAll(ph.addCard());
		
		System.out.println();
		
		System.out.println("카드를 하나 더 뽑고 나서의 나의 카드 목록");
		for (int i = 0; i < checkCard.size(); i++) {
			if(checkCard.get(i).shape == 1)
				shape = '♡';
				else if (checkCard.get(i).shape == 2)
					shape = '♠';
					else if (checkCard.get(i).shape == 3)
						shape = '♣';
						else if (checkCard.get(i).shape == 4)
							shape = '◇';
			
			
			
			System.out.println( "내가 고른 카드2 : " + shape + " / " + checkCard.get(i).num);
		}
		
		ph.count();
	}
}
