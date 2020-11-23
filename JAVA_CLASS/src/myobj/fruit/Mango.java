package myobj.fruit;

public class Mango implements Comparable<Mango> {

	public int calorie;
	public int sweet;
	public int id;
	
	private static int mango_id = 0;
	
	/** 
	 *  비교 대상 망고를 생성하는 생성자 
	 * */
	public Mango(int calorie, int sweet, int id) {
		this.calorie = calorie;
		this.sweet = sweet;
		this.id = id;
	}
	
	public Mango() {
		calorie = (int)(Math.random() * 101 + 200);
		sweet = (int)(Math.random() * 6 + 5);
		
		// 해당 인스턴스를 유일하게 구분해줄 수 있는 값
		id = mango_id++; 
		// System.out.printf("%d번 망고가 생성되었습니다.\n", id);
	}
	
	@Override
	public int hashCode() {
		// 이 객체를 유일하게 구분하려면 어떻게 해야할까요? 를 정의하는 곳 
		// (기본 동작은 이 인스턴스의 주소값을 사용)
		return id;
	}
	
	@Override
	public String toString() {	
		return String.format("%05d: %d/%d\n", id, calorie, sweet);
	}
	
	@Override
	public int compareTo(Mango o) {
		int calorie_result = this.calorie - o.calorie;
		
		return calorie_result == 0 ? 
				this.sweet - o.sweet : calorie_result;
	}

}









