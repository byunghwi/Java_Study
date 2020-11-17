
public class C06_abstract {
	public static void main(String[] args) {
		C06_Cat cat = new C06_Cat("Cat");
		C06_Dog dog =  new C06_Dog("Dog");
		
		System.out.println("cat's howling > " + cat.howling());
		System.out.println("dog's howling >  " + dog.howling());
		
		System.out.println(" cat swimming > " + cat.swimming());
		System.out.println(" dog swimming > " + dog.swimming());
	}
}

//abstract 클래스와 그것을 상속받는 클래스를 설계해보세요
// (추상 메서드가 반드시 존재해야함)