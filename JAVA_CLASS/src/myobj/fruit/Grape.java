package myobj.fruit;


public class Grape {
	String color;
	int size;
	int taste;
	int grade;
	
	public Grape() {}
	public Grape(String color, int size, int taste, int grade) {
		super();
		this.color = color;
		this.size = size;
		this.taste = taste;
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "Grape [color=" + color + ", size=" + size + ", taste=" + taste + ", grade=" + grade + "]";
	}
	
	
}
