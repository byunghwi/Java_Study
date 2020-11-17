
public class C04_static {
	public static void main(String[] args) {
//		 #static 
//		static은 클래스 당 하나이기 때문에 클래스명. 으로 접근하는 것을 권장.
//		인스턴스에 .을 찍고 사용해도 어차피 다 같은 값을 바라보기 때문
//		static 영역의 변수/메서드는 인스턴스가 생기기 전에도 호출할 수 있다.
		
		
		Card card = new Card();
	}
}


class Card{
	String shape;
	int num;
	
	static int width;
	static int height;
	
	public Card() {
	}
	
	public Card(String shape, int num) {
		super();
		this.shape = shape;
		this.num = num;
		
		//생성자에서 static을 초기화하는 경우
		//초기화 되지 않은 static 필드를 사용할 위험이 있다.
//		 width = 100;
//		 height = 200;
		
		
	}
	
	//생성자 대신 static block에서 초기화를 진행하는 것이 좋다.
	static {
		width= 100;
		height= 200;
		System.out.println("static block called");
	}
	
	// static method : static 변수만 활용할 수 있는 메서드
	// 매개변수만 사용하거나 static 변수만 사용가능
	// 인스턴스와 무관하게 항상 일정한 기능을 구현할 때 사용한다.
	public static void chageCardSize(int width, int height) {
		//static 메서드에서 this는 존재하지 않는다.
		// 아직 인스턴스가 생성되지 않았을 수도 있으므로
		Card.width = width;
		Card.height = height;
	}
	
	public static int[] getCardSize() {
		return new int[] {width, height};
	}
	

}

