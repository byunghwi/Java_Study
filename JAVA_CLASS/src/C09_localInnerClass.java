
public class C09_localInnerClass {
	public static void main(String[] args) {
		
		
		String a = "대구";
		String b = "빨간색";
		
		//지역 내부클래스 (메서드가 끝나면 클래스도 사라짐)
		class Apple{
			String addr;
			String color;
			
			public Apple(){
				addr = a;
				color = b;
			}
		}
		
		
		Apple apple = new Apple();
		
		System.out.println(apple.addr);
		System.out.println(apple.color);
	}
	
	
	void method() {
		class Apple{
			int size;
			String color;
		}
		
		Apple a  = new Apple();
		System.out.println(a.size);
		System.out.println(a.color);
	}
}
