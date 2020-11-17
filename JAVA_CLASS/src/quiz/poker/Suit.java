package quiz.poker;

public enum Suit {
	// order와 name은 기본적으로 설정
	// 상수를 추가하고 싶다면 생성자를 이용해야한다.
	
	SPADE(3, "스페이드", '♠'), 		//order 0, name "SPADE", suitValue 3
	DIAMOND(2, "다이아몬드" , '◇'),		//order 1, name "DIAMOND", suitValue 2 
	HEART(1, "하트", '♡'),		//order 2, name "HEART", suitValue 1
	CLOVER(0, "클로버", '♣');		//order 3, name "CLOVER", suitValue 0
	
	public static final int NUM_OF_SUITS = 4;
	
	private int suitValue;
	private String korName;
	private char suitPic;
	
	
	// enum 타입 객체는 생성자가 반드시 private이다.
	private Suit(int suitValue, String korName, char suitPic) {
		this.suitValue = suitValue;
		this.korName = korName;
		this.suitPic = suitPic;
	}
	
	public int getSuitValue() {
		return suitValue;
	}

	public String getKorName() {
		return korName;
	}

	public char getSuitPic() {
		return suitPic;
	}

}
