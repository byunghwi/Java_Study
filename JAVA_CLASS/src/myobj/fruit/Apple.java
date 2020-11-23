package myobj.fruit;

// �� Ŭ���� �ϳ��� ���� �ϳ��� �ٶ����ϴ� 
public class Apple {
	 int calorie;
	public String color;
	
	public Apple() {
		
	}
	
	public Apple(String color) {
		calorie = 300;
		
		if (!color.equals("red")) {
			throw new InvalidColorException();
		}
	}
	
	public Apple(Integer calorie, String color) {
		this.calorie = calorie;
		this.color = color;
	}
	
	public Apple eat() throws NoMoreCalorieException {		
		if (calorie <= 0) {				
			throw new NoMoreCalorieException();
		}			
		
		System.out.println("���ְ� �� �Ծ����ϴ�.");
		this.calorie -= 100; // @69222c14.calorie
		return this; // return @69222c14
	}
	
	public static void main(String[] args) {
		
		Apple apple01 = new Apple("red"); 
		System.out.println(apple01);
		
		try {
			apple01.eat(); // @69222c14.eat();
		} catch (NoMoreCalorieException e1) {			
			e1.printStackTrace();
		}
		
		// @69222c14.calorie; 
		System.out.println(apple01.calorie);
		
		Apple apple02 = new Apple("red"); // @606d8acf.calorie;
		System.out.println(apple02);
		
		System.out.println(apple02.calorie);
		
		try {
			new Apple("red").eat().eat().eat().eat().eat().eat();
		} catch (NoMoreCalorieException e) {		
			System.out.println(e.getMessage());
		}		
		
	}
}









