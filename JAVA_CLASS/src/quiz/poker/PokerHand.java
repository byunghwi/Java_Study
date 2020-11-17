package quiz.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class PokerHand {
	// PokerHand 클래스를 구현하라.
	
//	1. 다섯장의 PokerCard를 가지고 있어야함. - O
//	2. 다섯장의 PokerCard의 숫자/무늬를 통해 족보를 완성해야 함. - O
//	3. 다른 PokerHand 인스턴스와 족보를 통한 크기비교가 가능해야 함. - O
//	4. 다섯 장 중 원하는 카드만 공개하는 기능이 있어야 함.
//  5. 카드를 한장씩 추가하는 기능이 있어야 함. - O
	
	static int cards = 13; //카드 숫자 2 3 4 5 6 7 8 9 10 J Q K A  총 13장.
	static int shape = 4;  //카드 모양 4종류.
	
	static int heart = 1;
	static int spade = 2;
	static int clover = 3;
	static int dia = 4;
	
	int myPickCardidx;
	
	
	List<Integer> cardShape = new ArrayList<Integer>(); // 카드 모양 리스트
	List<Integer> cardNum = new ArrayList<Integer>(); // 카드 숫자 리스트
	List<Cards> totalCards = new ArrayList<Cards>();  // 모양과 숫자가 포함된 카드 형태 리스트
	Set<Cards> myPickCard = new HashSet<Cards>(); 	  // 초반 내가 뽑은 5장의 카드

	List<Integer> myCardsNums = new ArrayList<Integer>();
	List<Integer> myCardsShape = new ArrayList<Integer>();
	
	List<Integer> shapeCount = new ArrayList<Integer>(); 	  // 모양 몇개 나왔는지 카운드
	List<Integer> numCount = new ArrayList<Integer>(cards);   // 어떤 숫자가 몇번 나왔는지 체크
	
	//카드 모양과 숫자를 각 리스트에 저장
	public PokerHand() {
		Collections.addAll(cardShape, 1, 2, 3, 4);
		for (int i = 1; i <= cards; i++) {
			Collections.addAll(cardNum, i);
		}
		cardSet();
	}
	
	//카드형태 리스트로 모양과 숫자 부여.
	public void cardSet() {

		for (int i = 0; i < cardShape.size(); i++) {
			for (int j = 1; j <= cards; j++) {
				totalCards.add(new Cards(j, cardShape.get(i)));
			}
		}
		//카드 저장 다 했으면 섞어주기.
		Collections.shuffle(totalCards);
		
		Collections.addAll(shapeCount, 0, 0, 0, 0);
		Collections.addAll(numCount, 0, 0, 0, 0, 0, 0, 0, 0 ,0 ,0 ,0 ,0, 0);
		
		ranFiveCards();
	}
	
	//랜덤카드 5장 뽑기
	public void ranFiveCards() {
		while(myPickCard.size()<5) {
			myPickCardidx = (int) (Math.random()*cards+1);
			myPickCard.add(totalCards.get(myPickCardidx));

		}
	}
	
	// 추가로 1장씩 더 뽑기
	public Set<Cards> addCard() {
		myPickCardidx = (int) (Math.random()*cards+1);
		myPickCard.add(totalCards.get(myPickCardidx));	
			
		return myPickCard;
	}
	
	// 모양, 숫자 카운트
	public void count() {
		List<Cards> listMyCards = new ArrayList<Cards>(myPickCard); // 값 가져오기위해 Set 이었던 myPickCard를 List로 변환
		
		for (int i = 0; i < listMyCards.size(); i++) {
			myCardsNums.add(i, listMyCards.get(i).num); //내가 뽑은 카드를 돌면서 해당 숫자를 myCardsNums에 저장.
			myCardsShape.add(i, listMyCards.get(i).shape); 
		}
		
		for (int i = 0; i < cards; i++) {		
			numCount.set(i, Collections.frequency(myCardsNums, i+1));	// myCardsNums에 숫자 빈도수 체크해서 numCount에 저장.
		}
		
		for (int i = 0; i < shape; i++) {
			shapeCount.set(i, Collections.frequency(myCardsShape, i+1));
		}

		System.out.println(shapeCount);
		System.out.println(numCount);
		
		checkPoker();
	}
	
	// 족보 비교
	public void checkPoker() {
		if(numCount.contains(4))
			System.out.println("Four of a kind !!!");
		else if (numCount.contains(3)) 
			System.out.println("Three of a kind !!!");
		else if(numCount.contains(3) && numCount.contains(2)) 
			System.out.println("FULL HOUSE !!!");
	    else if(numCount.contains(2)) {
	    	if(numCount.indexOf(2) != numCount.lastIndexOf(2))
	    		System.out.println("Two Pair !!!");
	    	else
	    		System.out.println("One Pair !!!");
	    }
			
		
		
		if(shapeCount.contains(5)) {
			System.out.println("Flush !!!");
		}
		
	}

	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < totalCards.size(); i++) {
			result += "card : " + totalCards.get(i).shape + " / "+ totalCards.get(i).num + "\n";
		}
		return result;
	}

}
