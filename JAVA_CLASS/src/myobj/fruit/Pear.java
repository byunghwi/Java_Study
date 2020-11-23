package myobj.fruit;

public class Pear {

	void printThis() {
		System.out.println(this);
	}
	
	Pear returnThis() {
		return this;
	}
	
	
	public static void main(String[] args) {
		Pear pear01 = new Pear();
		
		System.out.println(pear01);
		pear01.printThis();
		System.out.println(pear01.returnThis());
	}
}
