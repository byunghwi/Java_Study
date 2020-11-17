//package quiz.poker;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.HashSet;
//import java.util.Set;
//
//public class PokerHand2 implements Comparable<PokerHand2>{
//	ArrayList<PokerCard> hands;
//	
//	boolean [] opens;
//	
//	public PokerHand2(int handSize) {
//		hands = new ArrayList<>(handSize);
//		opens = new boolean[handSize];
//		
//		for (int i = 0; i < handSize; i++) {
//			if(i<2)
//				opens[i] = false;
//			else
//				opens[i] = true;
//		}
//	}
//	
//	public void add(PokerCard card) {
//		hands.add(card);
//	}
//	
//	public void show() {
//		for (int i = 0; size = hands.size(); i < size; i++) {
//			System.out.println((i+1) + "번째 카드: " );
//			if(opens[i]) {
//				System.out.print(hands.get(i));
//			}else
//				System.out.println("NOT OPENED");
//			
//			System.out.println();
//		}
//	}
//	
//	public void open(int hand_index) {
//		opens[hand_index] = !opens[hand_index];
//	}
//	
//	public void openAllCard() {
//		Arrays.fill(opens, true);
//	}
//	
//	Set<Rank> getRankSet(){
//		Set<Rank> ranks = new HashSet<Rank>();
//		
//		for (PokerCard hand : hands) {
//			ranks.add(hand.rank);
//		}
//		
//		return ranks;
//	}
//	
//	public static void main(String[] args) {
//		PokerDeck deck = new PokerDeck();
//		PokerHand player01 = new PokerHand();
//		
//		player01.add(deck.draw());
//	}
//
//	@Override
//	public int compareTo(PokerHand2 o) {
//		PokerHandRanking rank1 = new PokerHandRanking(this);
//		PokerHandRanking rank2 = new PokerHandRanking(o);
//		
//		System.out.println("플레이어 1 : " + rank1.getHandrank());
//		System.out.println("플레이어 2 : "+ rank2.getHandrank());
//		return rank1.getHandrank().compareTo(rank2.getHandrank());
//		
//	}
//	
//
//}
