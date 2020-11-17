package quiz.poker2;

// Rank�� enum���� ���� �����غ�����
public class RankClassVer {
	static String[] names;
	static Integer[] rankValues;
	
	public static final RankClassVer ACE; 	
	public static final RankClassVer DEUCE;
	public static final RankClassVer THREE;
	public static final RankClassVer FOUR; 	
	public static final RankClassVer FIVE; 	
	public static final RankClassVer SIX; 
	public static final RankClassVer SEVEN;
	public static final RankClassVer EIGHT;
	public static final RankClassVer NINE; 
	public static final RankClassVer TEN; 
	public static final RankClassVer JACK;
	public static final RankClassVer QUEEN;
	public static final RankClassVer KING; 
	
	public static RankClassVer[] values;
	
	static {
		names = new String[] {
				"ACE", "DEUCE", "THREE", "FOUR", "FIVE", "SIX",
				"SEVEN", "EIGHT", "NINE", "TEN", "JACK", "QUEEN", "KING"
		};
		rankValues = new Integer[] {
			12, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
		};
		
		ACE 	= new RankClassVer(0);
		DEUCE 	= new RankClassVer(1);
		THREE 	= new RankClassVer(2);
		FOUR 	= new RankClassVer(3);
		FIVE 	= new RankClassVer(4);
		SIX 	= new RankClassVer(5);
		SEVEN 	= new RankClassVer(6);
		EIGHT 	= new RankClassVer(7);
		NINE 	= new RankClassVer(8);
		TEN 	= new RankClassVer(9);
		JACK 	= new RankClassVer(10);
		QUEEN 	= new RankClassVer(11);
		KING 	= new RankClassVer(12);
		
		values = new RankClassVer[] { 
				ACE, DEUCE, THREE, FOUR, FIVE, SIX, SEVEN,
				EIGHT, NINE, TEN, JACK, QUEEN, KING
		};		
	}
	
	String name;
	Integer rankValue;
	int order;
	
	// private ������ : �ܺο����� �ν��Ͻ��� ������ �� ���� �����
	private RankClassVer(int index) {
		this.order = index;
		this.name = names[index];
		this.rankValue = rankValues[index];
	}
	
	@Override
	public String toString() {	
		return name;
	}
	
	public static void main(String[] args) {
		System.out.println(RankClassVer.ACE);
	}
}











