//package quiz.poker;
//
//import java.util.ArrayList;
//import java.util.Collections;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
//public class PokerHandRanking {
//	private static Set<Rank> MOUNTAIN;
//	private static Set<Set<Rank>> STRAIGHT;
//	
//	static {
//		MOUNTAIN = new HashSet<Rank>(5);
//		Collections.addAll(MOUNTAIN, Rank.TEN, Rank.QUEEN, Rank.KING, Rank.ACE );
//		
//		STRAIGHT = new HashSet<>();
//		// A2345 ~ 910JQK
//		Rank[] rank_values = Rank.values();
//		
//		for (Rank rank : rank_values) {
//			Set<Rank> straight = new HashSet<Rank>();
//			straight.add(rank);
//			straight.add(rank_values[rank.ordinal() + 1]);
//			straight.add(rank_values[rank.ordinal() + 2]);
//			straight.add(rank_values[rank.ordinal() + 3]);
//			straight.add(rank_values[rank.ordinal() + 4]);
//			STRAIGHT.add(straight);
//			
//			if (rank.equals(Rank.NINE)) {
//				break;
//			}
//			
//		}
//	}
// 	
//	public HandRank handrank;
//	
//	private List<Integer> rankCount;
//	private List<Integer> suitCount;
//	
//	public PokerHandRanking(PokerHand2 hands) {
//		rankCount = new ArrayList<Integer>(Rank.NUM_OF_RANK);
//		suitCount = new ArrayList<Integer>(Suit.NUM_OF_SUITS);
//		
//		for (int i = 0; i < Rank.NUM_OF_RANK; i++) {
//			rankCount.add(0);
//		}
//		for (int i = 0; i < Suit.NUM_OF_SUITS; i++) {
//			suitCount.add(0);
//		}
//		
//		check(hands);
//	}
//	
//	private boolean checkMountain(Set<Rank> ranks) {
//		return ranks.containsAll(MOUNTAIN);
//	}
//	
//	private boolean checkStraight(Set<Rank> ranks) {
//		for (Set straight : STRAIGHT) {
//			if (ranks.containsAll(straight)) {
//				return true;
//			}
//		}
//		
//		return false;
//	}
//	
//	public void check(PokerHand2 player) {
//		List<PokerCard> hands = player.hands;
//		
//		for (PokerCard hand : hands) {
//			int rv = hand.rank.getRankValue();
//			int sv = hand.suit.getSuitValue();
//			
//			rankCount.set(rv, rankCount.get(rv)+1);
//			suitCount.set(sv, rankCount.get(sv)+1);
//		}
//		
//		Set<Rank> ranks = player.getRankSet();
//		
//		if(suitCount.contains(5) && checkMountain(ranks)) {
//			this.handrank = HandRank.ROYAL_FLUSH;
//		}else if(suitCount.contains(5) && checkStraight(ranks)) {
//			this.handrank = HandRank.STRAIGHT_FLUSH;
//		}else if(rankCount.contains(4)) {
//			this.handrank = HandRank.FOUR_KIND;
//		}else if(rankCount.contains(3) && rankCount.contains(2)) {
//			this.handrank = HandRank.FULL_HOUSE;
//		}
//		else if(suitCount.contains(5)) {
//			this.handrank = HandRank.FLUSH;
//		}else if(checkStraight(ranks)) {
//			this.handrank = HandRank.STRAIGHT;
//		}else if(rankCount.contains(3)) {
//			this.handrank = HandRank.THREE_KIND;
//		}else if(rankCount.contains(2)) {
//			if(rankCount.indexOf(2) != rankCount.lastIndexOf(2))
//				this.handrank = HandRank.TWO_PAIR;
//			else
//				this.handrank = HandRank.ONE_PAIR;
//		}else {
//			this.handrank = HandRank.HIGH_CARD;
//		}
//		
//		//System.out.println(rankCount);
//		//System.out.println(suitCount);
//	}
//}
