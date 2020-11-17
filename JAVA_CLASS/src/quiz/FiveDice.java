package quiz;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class FiveDice {
	
	private Random ran;
	private List<Integer> dices; 
	private List<Integer> counts;
	
	private static int NUM_OF_DICE = 5;
	private static int DICE_FACET = 6;
	
	private final static Set<Set<Integer>> LARGE_CASES;
	private final static Set<Set<Integer>> SMALL_CASES;
	
	Scanner sc = new Scanner(System.in);
	Scanner sc2 = new Scanner(System.in);
	String check;
	int index;
	
	static {
		LARGE_CASES = new HashSet<>(2);
		
		for (int i = 1; i <= 2; ++i) {
			Set<Integer> large = new HashSet<>(5);			
			Collections.addAll(large, i, i+1, i+2, i+3, i+4);
			LARGE_CASES.add(large);
		}
		
		SMALL_CASES = new HashSet<>(3);
		
		for (int i = 1; i <= 3; ++i) {
			Set<Integer> small = new HashSet<>(4);			
			Collections.addAll(small, i, i+1, i+2, i+3);
			SMALL_CASES.add(small);
		}
	}
	
	public FiveDice() {
		ran = new Random();

		dices = new ArrayList<>(NUM_OF_DICE); 
		counts = new ArrayList<>(DICE_FACET);
		
		Collections.addAll(dices, 0, 0, 0, 0, 0);
		Collections.addAll(counts, 0, 0, 0, 0, 0, 0);
	}
	
	private void count() {
		for (int i = 0; i < DICE_FACET; ++i) {
			int dice_num = i + 1;			
			counts.set(i, Collections.frequency(dices, dice_num));
		}
	}
	
	private String check() {
			
		// check by counts
		if (counts.contains(5)) {
			return "FIVE DICE!!!";
		} else if (counts.contains(4)) {
			return "FOUR DICE!!";
		} else if (counts.contains(2) && counts.contains(3)) {
			return "FULL HOUSE!!!";
		}
		
		// check by dices 
		for (Set<Integer> ls : LARGE_CASES) {
			if (dices.containsAll(ls)) {
				return "LARGE STRAIGHT!!!";
			}
		}
		
		for (Set<Integer> ss : SMALL_CASES) {
			if (dices.containsAll(ss)) {		
				return "SMALL STRAIGHT!!!";
			}
		}
		return "NO MATCHES";
		
	}
	
	public void roll() {		
		for (int i = 0; i < NUM_OF_DICE; ++i) {
			dices.set(i, ran.nextInt(DICE_FACET) + 1);
		}
		
		count();

		System.out.print(dices + " : ");
		System.out.println(check());
	}
	
	public int reroll() {

		System.out.print("주사위를 다시 던지시겠습니까? Y/N > ");
		check = sc.nextLine();

		if(check.equals("Y")) {
			System.out.print("바꿀 위치를 선택하세요 > ");
			index  = sc2.nextInt();
			dices.set(index-1, ran.nextInt(DICE_FACET) + 1);
			count();
			
			System.out.print(dices + " : ");
			System.out.println(check());
			return 1;
		}else {
			System.out.println("종료합니다.");
			return -1;
		}
	}
	
	public static void main(String[] args) {
		FiveDice dice01 = new FiveDice();
		
	
		dice01.roll();
		while(dice01.reroll() != -1) {
			dice01.reroll();
		}
		

		
	}
}






