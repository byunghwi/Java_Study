//package quiz.poker;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.LinkedList;
//
//public class PokerDeck {
//	LinkedList<PokerCard> deck;
//	
//	public static final int DECKSIZE = 52;
//	
//	public  PokerDeck() {
//			for (Rank rank : Rank.values()) {
//				for(Suit suit : Suit.values()) {
//					deck.add(new PokerCard(rank, suit));
//				}
//			}
//
//			Collections.shuffle(deck);
//			System.out.println("[System] New deck created and shuffled");
//	}
//	
//	public PokerCard draw() {
//		//ArrayList의 remove()는 pop의 기능도 한다.
//		return deck.remove(0); 
//	}
//
//}
