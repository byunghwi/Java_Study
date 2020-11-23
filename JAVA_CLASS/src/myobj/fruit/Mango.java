package myobj.fruit;

public class Mango implements Comparable<Mango> {

	public int calorie;
	public int sweet;
	public int id;
	
	private static int mango_id = 0;
	
	/** 
	 *  �� ��� ���� �����ϴ� ������ 
	 * */
	public Mango(int calorie, int sweet, int id) {
		this.calorie = calorie;
		this.sweet = sweet;
		this.id = id;
	}
	
	public Mango() {
		calorie = (int)(Math.random() * 101 + 200);
		sweet = (int)(Math.random() * 6 + 5);
		
		// �ش� �ν��Ͻ��� �����ϰ� �������� �� �ִ� ��
		id = mango_id++; 
		// System.out.printf("%d�� ���� �����Ǿ����ϴ�.\n", id);
	}
	
	@Override
	public int hashCode() {
		// �� ��ü�� �����ϰ� �����Ϸ��� ��� �ؾ��ұ��? �� �����ϴ� �� 
		// (�⺻ ������ �� �ν��Ͻ��� �ּҰ��� ���)
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









