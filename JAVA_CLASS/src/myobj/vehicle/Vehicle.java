package myobj.vehicle;

public class Vehicle {
	public int size;
	public String color;
	public int speed;
	public int grade;
	
	public Vehicle() {}
	
	public Vehicle(int size, String color, int speed, int grade) {
		super();
		this.size = size;
		this.color = color;
		this.speed = speed;
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Vehicle [size=" + size + ", color=" + color + ", speed=" + speed + ", grade=" + grade + "]";
	}

	public String upGrade(int up) {
		int origin = this.grade;
		this.grade = up;
		return  origin+"등급에서 "+up+"등급으로 업그레이드 되었습니다." ;
	}
	
}
