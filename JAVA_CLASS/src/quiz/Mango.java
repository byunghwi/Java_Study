package quiz;

public class Mango {
	public int calrorie;
	public int sweet;
	public int id;
	public static int mango_id = 0;
	
	public Mango() {
		super();
		this.calrorie = (int)(Math.random()*50+50);
		this.sweet = (int)(Math.random()*10+1);;
		id = mango_id++;
		System.out.printf("%d번 망고가 생성되었습니다.\n", id );
	}
	
	//비교대상 망고를 생성하는 생성자
	public Mango(int calrorie, int sweet, int id) {
		this.calrorie = calrorie;
		this.sweet = sweet;
		this.id = id;
	}


	@Override
	public String toString() {
		return String.format("%04X : %d/%d\n ", id, calrorie, sweet); //04X는 16진수 표현
	}

	@Override
	public int hashCode() {
		//이 개체를 유일하게 구분하려면 어떻게 해야하는가 를 정의 하는 곳
		//기본 동작은 이 인스턴스의 주소값을 사용
		//return super.hashCode();
		
		return id;
	}
	
	
	
}
